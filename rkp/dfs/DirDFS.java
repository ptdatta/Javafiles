package dfs;

import java.util.*;

public class DirDFS {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public DirDFS(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    public void dfs() {
        boolean[] visited = new boolean[vertices];
        System.out.println("DFS traversal and DFS tree of each component:");
        
        System.out.println("Components: ");
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                System.out.print(i);
                dfsUtil(i, visited);
                System.out.println();
            }
        }
    }

    private void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        
        LinkedList<Integer> children = adjacencyList[vertex];
        boolean isFirstChild = true;
        for (int child : children) {
            if (!visited[child]) {
                if (isFirstChild) {
                    System.out.print(" -> ");
                    isFirstChild = false;
                } else {
                    System.out.print(" -> ");
                }
                System.out.print(child);
                dfsUtil(child, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        DirDFS graph = new DirDFS(vertices);

        System.out.println("Enter the number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter each edge (source and destination): ");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }

        graph.dfs();
        scanner.close();
    }
}
