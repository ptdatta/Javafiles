package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import minimum_spanning_tree.MinimumSpanningTree;

public class GraphEdge {

    int vertices;
    List<Edge> l;
    public GraphEdge(int vertices){
        this.vertices = vertices;
        this.l = new ArrayList<>(vertices);
    }

    public void addEdge(int s,int d,int w){
        l.add(new Edge(s, d, w));
    }

    public void CMST(){
        Collections.sort(l);
        int[] parent = new int[this.vertices];
        for(int i=0;i<vertices;i++){
            parent[i] = i;
        }

        List<Edge> mst =new ArrayList<>();
        for(Edge e: l){
           int s = find(parent, e.source);
           int d = find(parent,e.destination);
           if(s!=d){
              mst.add(e);
              parent[s] = d;
           }
        }
        System.out.println(mst.toString());
    }

    public int find(int[] parent,int s){
        if(parent[s] != s){
            parent[s] = find(parent, parent[s]);
        }
        return parent[s];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        GraphEdge graph = new GraphEdge(vertices);

        System.out.println("Enter each edge as (source destination weight):");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(source, destination, weight);
        }

        graph.CMST();

        scanner.close();
    }
    

    static class Edge implements Comparable<Edge>{
        int source, destination, weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        public String toString(){
            return this.source + " " + this.destination + " " + this.weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
        
    }
}
