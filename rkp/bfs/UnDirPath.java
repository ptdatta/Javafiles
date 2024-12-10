package bfs;

import java.util.*;

public class UnDirPath {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public UnDirPath(int vertices) {
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

    public void bfsShortestPath(int startVertex, int endVertex) {
        boolean[] visited = new boolean[vertices];
        int[] distance = new int[vertices];
        int[] parent = new int[vertices];
        
        Arrays.fill(distance, -1); 
        Arrays.fill(parent, -1); 
        
        Queue<Integer> queue = new LinkedList<>();
        
        visited[startVertex] = true;
        distance[startVertex] = 0;
        queue.add(startVertex);
        
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            
            for (int neighbor : adjacencyList[currentVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[currentVertex] + 1;
                    parent[neighbor] = currentVertex;
                    queue.add(neighbor);
                    
                    if (neighbor == endVertex) break;
                }
            }
        }

        if (distance[endVertex] == -1) {
            System.out.println("No path exists between " + startVertex + " and " + endVertex);
        } else {
            System.out.println("Shortest distance from " + startVertex + " to " + endVertex + ": " + distance[endVertex]);
            System.out.print("Path: ");
            printPath(endVertex, parent);
        }
    }
    
    private void printPath(int currentVertex, int[] parent) {
        List<Integer> path = new ArrayList<>();
        for (int vertex = currentVertex; vertex != -1; vertex = parent[vertex]) {
            path.add(vertex);
        }
        Collections.reverse(path);
        System.out.println(String.join("->", path.stream().map(String::valueOf).toArray(String[]::new)));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        UnDirPath graph = new UnDirPath(vertices);

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter each edge (source and destination): ");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }

        System.out.print("Enter the start vertex: ");
        int startVertex = scanner.nextInt();

        System.out.print("Enter the end vertex: ");
        int endVertex = scanner.nextInt();

        graph.bfsShortestPath(startVertex, endVertex);
        scanner.close();
    }
}
