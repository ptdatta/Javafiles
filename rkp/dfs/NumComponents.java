package dfs;

import java.util.LinkedList;
import java.util.Scanner;

public class NumComponents {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public NumComponents(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source); 
    }

    public int countComponents() {
        boolean[] visited = new boolean[vertices];
        int components = 0;

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfsUtil(i, visited);
                components++; 
            }
        }
        
        return components;
    }

    private void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;

        for (int neighbor : adjacencyList[vertex]) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        NumComponents graph = new NumComponents(vertices);

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter each edge (source and destination): ");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }

        int componentCount = graph.countComponents();
        System.out.println("Number of connected components: " + componentCount);

        scanner.close();
    }
}