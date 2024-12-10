package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Graph {

    int vertices;
    List<Integer>[] adjacencyList;
    boolean[] isVisited;
    int time;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList[vertices];
        isVisited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        time = 0;
    }

    public void findBCCUtil(int u, int[] discoveryTime, int[] lowTime, int[] parent, Stack<int[]> s) {
        isVisited[u] = true;
        discoveryTime[u] = lowTime[u] = ++time;

        int children = 0;
        for (int v : adjacencyList[u]) {
            if (!isVisited[v]) {
                children++;
                parent[v] = u;
                s.push(new int[] { u, v });
                findBCCUtil(v, discoveryTime, lowTime, parent, s);
                lowTime[u] = Math.min(lowTime[v], lowTime[u]);
                if ((parent[u] == -1 && children > 1) || (parent[u] != -1 && lowTime[v] >= discoveryTime[u])) {
                    List<String> l = new ArrayList<>();
                    while (true) {
                        int[] edge = s.pop();
                        l.add(Arrays.toString(edge));
                        if(edge[0] == u && edge[1] == v) break;
                    }
                    System.out.println(l.toString());
                }

            } else if (v != parent[u] && discoveryTime[v] < discoveryTime[u]) {
                lowTime[u] = Math.min(lowTime[u], discoveryTime[v]);
                s.push(new int[] { u, v });
            }
        }
    }

    public void findBCC() {
        Stack<int[]> s = new Stack<>();
        int[] parent = new int[vertices];
        int[] discoveryTime = new int[vertices];
        int[] lowTime = new int[vertices];
        Arrays.fill(parent, -1);

        for (int i = 0; i < vertices; i++) {
            if (!isVisited[i]) {
                findBCCUtil(i, discoveryTime, lowTime, parent, s);
            }
        }

        while (!s.empty()) {
            List<String> l = new ArrayList<>();
            while (!s.empty()) {
                l.add(Arrays.toString(s.pop()));
            }
            System.out.println(l.toString());
        }
    }

    public void addEdge(int source, int destination) {
        if (!adjacencyList[source].contains(destination)) {
            adjacencyList[source].add(destination);
            // adjacencyList[destination].add(source);
        }
    }

    public void topoSort(){
        int[] indegree = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            for (int neighbor : adjacencyList[i]) {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<vertices;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        List<Integer> l = new ArrayList<>();
        while(!q.isEmpty()){
            int v = q.poll();
            l.add(v);
            for(int i : adjacencyList[v]){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                }
            }
        }
        System.out.println(l);
    }

    public void removeEdge(int source, int destination) {
        if (adjacencyList[source].contains(destination)) {
            adjacencyList[source].remove(destination);
        } else {
            System.out.println("Edge not found");
        }
    }

    public void dfs(int startVertex, List<Integer> l) {
        for (int i : adjacencyList[startVertex]) {
            dfs(i, l);
        }
        l.add(startVertex);
    }

    public List<Integer> bfs(int startVertex,int endVertex) {
        int[] parent = new int[vertices];
        int[] distance = new int[vertices];
        Arrays.fill(parent, -1);
        Arrays.fill(distance,-1);
        List<Integer> ans = new ArrayList<>(this.vertices);
        isVisited[startVertex] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(startVertex);
        distance[startVertex] = 0;
        while (!q.isEmpty()) {
            int v = q.poll();
            ans.add(v);
            for (int i : adjacencyList[v]) {
                if (!isVisited[i]) {
                    q.add(i);
                    isVisited[i] = true;
                    parent[i] = v;
                    distance[i] = distance[v]+1;

                    if(i == endVertex) break;
                }
            }
        }
        PrintPath(endVertex,parent);
        return ans;
    }

    public void PrintPath(int endVertex,int[] parent){
        List<Integer> l = new ArrayList<>();
        for(int v = endVertex;v!=-1;v= parent[v]){
            l.add(v);
        }
        Collections.reverse(l);
        System.out.println(l);
    }

    // public void printBfs() {
    //     System.out.println(bfs(0));
    // }

    public void printDfs() {
        int[] parent = new int[vertices];
        int[] discoveryTime = new int[vertices];
        int[] lowTime = new int[vertices];
        ArrayList ans = new ArrayList<>(vertices);
        dfs(0, ans);
        System.out.println(ans);
    }

    public void printGraph() {
        for (List<Integer> a : adjacencyList) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Vertices No: ");
        // int v = sc.nextInt();
        // System.out.println("Edge no: ");
        // int e = sc.nextInt();

        // Graph g = new Graph(v);

        // for (int i=0;i<e;i++){
        // System.out.println("Add Edge: ");
        // g.addEdge(sc.nextInt(), sc.nextInt());
        // }

        // g.printGraph();
        Graph g = new Graph(6);
        g.addEdge(0, 2);
        g.addEdge(0, 1);
        g.addEdge(1 , 3);
        g.addEdge(3, 2);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 4);

        // Graph g = new Graph(4);
        // g.addEdge(1,0 );
        // g.addEdge(2, 1);
        // g.addEdge(3, 1);
        // g.addEdge(3, 2);
        // g.findBCC();
        g.bfs(0, 4);
    }
}
