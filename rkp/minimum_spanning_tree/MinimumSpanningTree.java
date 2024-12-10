package minimum_spanning_tree;

import java.util.*;

public class MinimumSpanningTree {
    private int vertices;
    private List<Edge> edges;

    public MinimumSpanningTree(int vertices) {
        this.vertices = vertices;
        this.edges = new ArrayList<>();
    }

    public void addEdge(int source, int destination, int weight) {
        edges.add(new Edge(source, destination, weight));
    }

    public void findMST() {
        Collections.sort(edges);

        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }

        List<Edge> mst = new ArrayList<>();
        int mstWeight = 0;

        for (Edge edge : edges) {
            int rootSource = find(parent, edge.source);
            int rootDestination = find(parent, edge.destination);

            if (rootSource != rootDestination) {
                mst.add(edge);
                mstWeight += edge.weight;
                union(parent, rootSource, rootDestination);
            }
        }

        System.out.println("Minimum Spanning Tree (MST):");
        for (Edge edge : mst) {
            System.out.println(edge.source + " -- " + edge.destination + " == " + edge.weight);
        }
        System.out.println("Total Weight of MST: " + mstWeight);
    }

    private int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);
        }
        return parent[vertex];
    }

    private void union(int[] parent, int root1, int root2) {
        parent[root1] = root2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        MinimumSpanningTree graph = new MinimumSpanningTree(vertices);

        System.out.println("Enter each edge as (source destination weight):");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(source, destination, weight);
        }

        graph.findMST();

        scanner.close();
    }

    static class Edge implements Comparable<Edge> {
        int source, destination, weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
}
