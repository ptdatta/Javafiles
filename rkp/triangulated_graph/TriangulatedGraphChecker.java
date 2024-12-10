package triangulated_graph;

import java.util.*;

import java.util.*;

public class TriangulatedGraphChecker {
    private int vertices;
    private int[][] adjMatrix;

    public TriangulatedGraphChecker(int vertices) {
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

    private boolean isClique(List<Integer> vertices) {
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = i + 1; j < vertices.size(); j++) {
                if (adjMatrix[vertices.get(i)][vertices.get(j)] == 0) {
                    return false; // Not a clique
                }
            }
        }
        return true;
    }

    public boolean isTriangulated() {
        int[] degree = new int[vertices];
        boolean[] visited = new boolean[vertices];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Calculate degrees and initialize the priority queue
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (adjMatrix[i][j] == 1) {
                    degree[i]++;
                }
            }
            pq.add(new int[]{degree[i], i});
        }

        // Perfect elimination order (PEO)
        List<Integer> peo = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int v = current[1];
            if (visited[v]) continue;
            visited[v] = true;
            peo.add(v);

            for (int u = 0; u < vertices; u++) {
                if (adjMatrix[v][u] == 1 && !visited[u]) {
                    degree[u]--;
                    pq.add(new int[]{degree[u], u});
                }
            }
        }
        System.out.println(peo);

        // Check for chordality
        for (int i = 0; i < vertices; i++) {
            int v = peo.get(i);
            List<Integer> laterNeighbors = new ArrayList<>();
            for (int j = i + 1; j < vertices; j++) {
                if (adjMatrix[v][peo.get(j)] == 1) {
                    laterNeighbors.add(peo.get(j));
                }
            }
            if (!isClique(laterNeighbors)) {
                return false; // Not chordal
            }
        }
        return true; // Chordal
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // System.out.print("Enter the number of vertices: ");
        // int vertices = scanner.nextInt();

        // System.out.print("Enter the number of edges: ");
        // int edges = scanner.nextInt();

        // TriangulatedGraphChecker graph = new TriangulatedGraphChecker(vertices);

        // System.out.println("Enter the edges (u v):");
        // for (int i = 0; i < edges; i++) {
        //     System.out.print("Edge " + (i + 1) + ": ");
        //     int u = scanner.nextInt();
        //     int v = scanner.nextInt();
        //     graph.addEdge(u, v);
        // }
        TriangulatedGraphChecker graph = new TriangulatedGraphChecker(4);
        graph.addEdge(0, 1);
        graph.addEdge(1 , 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        graph.addEdge(1, 3);


        if (graph.isTriangulated()) {
            System.out.println("\nThe graph is triangulated (chordal).");
        } else {
            System.out.println("\nThe graph is not triangulated (chordal).");
        }

        scanner.close();

        // PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // pq.add(new int[]{2,0});
        // pq.add(new int[]{3,1});
        // pq.add(new int[]{3,3});
        // pq.add(new int[]{2,2});
        // System.out.println(Arrays.toString(pq.poll()));
        // System.out.println(Arrays.toString(pq.poll()));
        // System.out.println(Arrays.toString(pq.poll()));
        // System.out.println(Arrays.toString(pq.poll()));
        
    }
}
