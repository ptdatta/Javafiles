package adjacency_list;

import java.util.LinkedList;
import java.util.Scanner;

public class DirUnWeighted {
     private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public DirUnWeighted(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        if (source < 0 || source >= vertices || destination < 0 || destination >= vertices) {
            System.out.println("Invalid vertices! Please enter vertices between 0 and " + (vertices - 1));
            return;
        }
        adjacencyList[source].add(destination);
        System.out.println("Edge added between " + source + " and " + destination);
    }

    public void removeEdge(int source, int destination) {
        if (source < 0 || source >= vertices || destination < 0 || destination >= vertices) {
            System.out.println("Invalid vertices! Please enter vertices between 0 and " + (vertices - 1));
            return;
        }
        adjacencyList[source].remove((Integer) destination);
        System.out.println("Edge removed between " + source + " and " + destination);
    }

    public void printGraph() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < adjacencyList[i].size(); j++) {
                System.out.print(adjacencyList[i].get(j));
                if (j < adjacencyList[i].size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vertex indices start from 0.");
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        DirUnWeighted graph = new DirUnWeighted(vertices);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1 - Add an edge");
            System.out.println("2 - Remove an edge");
            System.out.println("3 - Print the adjacency list and exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter source and destination vertices to add an edge: ");
                int source = scanner.nextInt();
                int destination = scanner.nextInt();
                graph.addEdge(source, destination);

            } else if (choice == 2) {
                System.out.print("Enter source and destination vertices to remove an edge: ");
                int source = scanner.nextInt();
                int destination = scanner.nextInt();
                graph.removeEdge(source, destination);

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