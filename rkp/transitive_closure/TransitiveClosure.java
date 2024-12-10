package transitive_closure;

import java.util.*;

public class TransitiveClosure {
    private int vertices;
    private int[][] transitiveClosureMatrix;

    public TransitiveClosure(int vertices) {
        this.vertices = vertices;
        this.transitiveClosureMatrix = new int[vertices][vertices];
    }

    public void addEdge(int source, int destination) {
        transitiveClosureMatrix[source][destination] = 1;
    }

    public void computeTransitiveClosure() {
        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    transitiveClosureMatrix[i][j] = transitiveClosureMatrix[i][j] 
                                                    | (transitiveClosureMatrix[i][k] & transitiveClosureMatrix[k][j]);
                }
            }
        }
    }

    public void printTransitiveClosure() {
        System.out.println("Transitive Closure Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(transitiveClosureMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        TransitiveClosure graph = new TransitiveClosure(vertices);

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter each edge as (source destination):");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }

        graph.computeTransitiveClosure();
        graph.printTransitiveClosure();

        scanner.close();
    }
}
