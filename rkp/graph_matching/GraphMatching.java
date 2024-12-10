package graph_matching;

import java.util.*;

public class GraphMatching {
    private int vertices;
    private List<Edge> edges;

    public GraphMatching(int vertices) {
        this.vertices = vertices;
        this.edges = new ArrayList<>();
    }

    public void addEdge(int source, int destination) {
        edges.add(new Edge(source, destination));
    }

    public Set<Edge> computeMatching() {
        Set<Edge> matching = new HashSet<>();
        Set<Integer> matchedVertices = new HashSet<>();

        for (Edge edge : edges) {
            // If neither of the vertices is already matched, add the edge to the matching set
            if (!matchedVertices.contains(edge.source) && !matchedVertices.contains(edge.destination)) {
                matching.add(edge);
                matchedVertices.add(edge.source);
                matchedVertices.add(edge.destination);
            }
        }

        return matching;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        GraphMatching graph = new GraphMatching(vertices);

        System.out.println("Enter each edge as (source destination):");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }

        Set<Edge> matching = graph.computeMatching();

        System.out.println("Matching set of edges:");
        for (Edge edge : matching) {
            System.out.println(edge.source + " -- " + edge.destination);
        }

        scanner.close();
    }

    static class Edge {
        int source, destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }

        @Override
        public String toString() {
            return source + " -- " + destination;
        }
    }
}
