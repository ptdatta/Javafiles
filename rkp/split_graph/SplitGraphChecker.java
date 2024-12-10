package split_graph;

import java.util.*;

public class SplitGraphChecker {
    private int vertices;
    private int[][] adjMatrix;

    public SplitGraphChecker(int vertices) {
        this.vertices = vertices;
        this.adjMatrix = new int[vertices][vertices];
    }

    public void addEdge(int u, int v) {
        if (u < 0 || u >= vertices || v < 0 || v >= vertices) {
            System.out.println("Invalid vertices! Please enter valid vertices.");
            return;
        }
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1; // Undirected graph
    }

    private boolean isClique(List<Integer> verticesSubset) {
        for (int i = 0; i < verticesSubset.size(); i++) {
            for (int j = i + 1; j < verticesSubset.size(); j++) {
                if (adjMatrix[verticesSubset.get(i)][verticesSubset.get(j)] == 0) {
                    return false; // Not a clique
                }
            }
        }
        return true;
    }

    private boolean isIndependentSet(List<Integer> verticesSubset) {
        for (int i = 0; i < verticesSubset.size(); i++) {
            for (int j = i + 1; j < verticesSubset.size(); j++) {
                if (adjMatrix[verticesSubset.get(i)][verticesSubset.get(j)] == 1) {
                    return false; // Not independent
                }
            }
        }
        return true;
    }

    public boolean isSplitGraph() {
        int[] degrees = new int[vertices];
        List<Integer> vertexOrder = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            vertexOrder.add(i);
            for (int j = 0; j < vertices; j++) {
                if (adjMatrix[i][j] == 1) {
                    degrees[i]++;
                }
            }
        }

        System.out.println(vertexOrder);
        // Sort vertices by degree in descending order
        vertexOrder.sort((a, b) -> degrees[b] - degrees[a]);
        System.out.println(vertexOrder);

        List<Integer> clique = new ArrayList<>();
        List<Integer> independentSet = new ArrayList<>();

        // Try to form a clique with the highest degree vertices
        for (int i : vertexOrder) {
            boolean canBeClique = true;
            for (int c : clique) {
                if (adjMatrix[i][c] == 0) {
                    canBeClique = false;
                    break;
                }
            }
            if (canBeClique) {
                clique.add(i);
            } else {
                independentSet.add(i);
            }
        }

        // Verify the partition
        if (isClique(clique) && isIndependentSet(independentSet)) {
            // Print the result
            System.out.println("\nClique vertices: " + clique);
            System.out.println("Independent set vertices: " + independentSet);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        SplitGraphChecker graph = new SplitGraphChecker(vertices);

        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < edges; i++) {
            System.out.print("Edge " + (i + 1) + ": ");
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.addEdge(u, v);
        }

        if (graph.isSplitGraph()) {
            System.out.println("\nThe graph is a split graph.");
        } else {
            System.out.println("\nThe graph is not a split graph.");
        }

        scanner.close();
    }
}
