package incidence_matrix;

import java.util.ArrayList;
import java.util.Scanner;

public class UnDirWeighted {
     private int vertices;
    private ArrayList<int[]> incidenceMatrix;
    private int edgeCount;

    public UnDirWeighted(int vertices) {
        this.vertices = vertices;
        this.incidenceMatrix = new ArrayList<>();
        this.edgeCount = 0;
    }
    
    public void addEdge(int source, int destination,int value) {
        if (source < 0 || source >= vertices || destination < 0 || destination >= vertices) {
            System.out.println("Invalid vertices! Please enter vertices between 0 and " + (vertices - 1));
            return;
        }
        
        int[] edge = new int[vertices];
        edge[source] = value;
        edge[destination] = value;
        incidenceMatrix.add(edge);
        edgeCount++;
        System.out.println("Edge added between " + source + " and " + destination);
    }
    
    public void removeEdge(int edgeIndex) {
        if (edgeIndex < 0 || edgeIndex >= edgeCount) {
            System.out.println("Invalid edge index! Please enter an index between 0 and " + (edgeCount - 1));
            return;
        }
        
        incidenceMatrix.remove(edgeIndex);
        edgeCount--;
        System.out.println("Edge at index " + edgeIndex + " removed.");
    }
    
    public void printGraph() {
        System.out.println("Incidence Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < edgeCount; j++) {
                System.out.print(incidenceMatrix.get(j)[i] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vertex indices start from 0.");
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        
        UnDirWeighted graph = new UnDirWeighted(vertices);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1 - Add an edge");
            System.out.println("2 - Remove an edge by index");
            System.out.println("3 - Print the incidence matrix and exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter source, destination and value vertices to add an edge: ");
                int source = scanner.nextInt();
                int destination = scanner.nextInt();
                int value  = scanner.nextInt();
                graph.addEdge(source, destination,value);

            } else if (choice == 2) {
                System.out.print("Enter the edge index to remove: ");
                int edgeIndex = scanner.nextInt();
                graph.removeEdge(edgeIndex);

            } else if (choice == 3) {
                graph.printGraph();
                break;

            } else {
                System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            }
        }

        scanner.close();
    }
}