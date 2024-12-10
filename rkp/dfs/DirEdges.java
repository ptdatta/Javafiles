package dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class DirEdges {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public DirEdges(int vertices) {
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
        int[] parent = new int[vertices];
        Arrays.fill(parent, -1); 
        int[] discoveryTime = new int[vertices]; 
        int[] lowTime = new int[vertices]; 
        Arrays.fill(discoveryTime, -1);
        Arrays.fill(lowTime, -1);
        int time = 0;

        System.out.println("DFS traversal with edge classification:");

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfsUtil(i, visited, parent, discoveryTime, lowTime, time);
            }
        }
    }

    private void dfsUtil(int vertex, boolean[] visited, int[] parent, int[] discoveryTime, int[] lowTime, int time) {
        visited[vertex] = true;
        discoveryTime[vertex] = lowTime[vertex] = ++time;
        System.out.println("Visiting: " + vertex);

        for (int neighbor : adjacencyList[vertex]) {
            if (!visited[neighbor]) {
                System.out.println("Tree Edge: " + vertex + " -> " + neighbor);
                parent[neighbor] = vertex;
                dfsUtil(neighbor, visited, parent, discoveryTime, lowTime, time);
            } else if (parent[vertex] != neighbor) {
                if (discoveryTime[neighbor] < discoveryTime[vertex]) {
                    System.out.println("Back Edge: " + vertex + " -> " + neighbor);
                } else if (discoveryTime[vertex] < discoveryTime[neighbor]) {
                    System.out.println("Forward Edge: " + vertex + " -> " + neighbor);
                } else {
                    System.out.println("Cross Edge: " + vertex + " -> " + neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        DirEdges graph = new DirEdges(vertices);

        System.out.print("Enter the number of edges: ");
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
