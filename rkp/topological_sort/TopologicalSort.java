package topological_sort;

import java.util.*;

public class TopologicalSort {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public TopologicalSort(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    public void topologicalSort() {
        int[] inDegree = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            for (int neighbor : adjacencyList[i]) {
                inDegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> topologicalOrder = new ArrayList<>();

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            topologicalOrder.add(currentVertex);

            for (int neighbor : adjacencyList[currentVertex]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if (topologicalOrder.size() != vertices) {
            System.out.println("The graph contains a cycle. Topological sort is not possible.");
        } else {
            System.out.println("Topological Sort (DAG): " + topologicalOrder);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        TopologicalSort graph = new TopologicalSort(vertices);

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter each edge as (source destination):");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }

        graph.topologicalSort();

        scanner.close();
    }
}
