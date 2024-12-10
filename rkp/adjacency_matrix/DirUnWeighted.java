package adjacency_matrix;

import java.util.Scanner;

public class DirUnWeighted {
    private int vertices;
    private int[][] adjacencyMatrix;
    
    public DirUnWeighted(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }
    
    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
    }
    
    public void removeEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 0;
    }
    
    public boolean isEdge(int source, int destination) {
        return adjacencyMatrix[source][destination] == 1;
    }
    
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public int getVertices() {
        return vertices;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vertex start from  0");
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        DirUnWeighted graph = new DirUnWeighted(vertices);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1 - Add an edge");
            System.out.println("2 - Remove an edge");
            System.out.println("3 - Print the adjacency matrix and exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter source and destination vertices to add an edge: ");
                int source = scanner.nextInt();
                int destination = scanner.nextInt();
                if (source >= 0 && source < vertices && destination >= 0 && destination < vertices) {
                    graph.addEdge(source, destination);
                    System.out.println("Edge added between " + source + " and " + destination);
                } else {
                    System.out.println("Invalid vertices! Please enter vertices between 0 and " + (vertices - 1));
                }
            } else if (choice == 2) {
                System.out.print("Enter source and destination vertices to remove an edge: ");
                int source = scanner.nextInt();
                int destination = scanner.nextInt();
                if (source >= 0 && source < vertices && destination >= 0 && destination < vertices) {
                    if(graph.isEdge(source, destination)){
                        graph.removeEdge(source, destination);
                        System.out.println("Edge removed between " + source + " and " + destination);
                    }else {
                        System.out.println("Edge does not exist between " + source + " and " + destination);
                    }
                } else {
                    System.out.println("Invalid vertices! Please enter vertices between 0 and " + (vertices - 1));
                }
            } else if (choice == 3) {
                System.out.println("Graph adjacency matrix:");
                graph.printGraph();
                break;
            } else {
                System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            }
        }

        scanner.close();
    }
}
