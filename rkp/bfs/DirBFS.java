package bfs;

import java.util.*;

public class DirBFS {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public DirBFS(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    public void bfs() {
        boolean[] visited = new boolean[vertices];
        
        System.out.println("BFS traversal for each component:");
        
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                printBFSComponent(i, visited);
            }
        }
    }

    private void printBFSComponent(int startVertex, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);
        
        List<Integer> component = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            component.add(currentVertex);

            for (int neighbor : adjacencyList[currentVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        
        System.out.println(String.join("->", component.stream().map(String::valueOf).toArray(String[]::new)));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        DirBFS graph = new DirBFS(vertices);

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter each edge (source and destination): ");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }

        graph.bfs();
        scanner.close();
    }
}
