package bi_connected_components;

import java.util.*;

public class BiConnectedComponents {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;
    private int time;

    public BiConnectedComponents(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
        time = 0;
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source);
    }

    private void findBCCsUtil(int u, boolean[] visited, int[] discoveryTime, int[] lowTime, int[] parent, Stack<int[]> stack) {
        visited[u] = true;
        discoveryTime[u] = lowTime[u] = ++time;

        int children = 0;

        for (int v : adjacencyList[u]) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                stack.push(new int[]{u, v});

                findBCCsUtil(v, visited, discoveryTime, lowTime, parent, stack);

                lowTime[u] = Math.min(lowTime[u], lowTime[v]);

                if ((parent[u] == -1 && children > 1) || (parent[u] != -1 && lowTime[v] >= discoveryTime[u])) {
                    List<String> component = new ArrayList<>();
                    while (true) {
                        int[] edge = stack.pop();
                        component.add(Arrays.toString(edge));
                        if (edge[0] == u && edge[1] == v) break;
                    }
                    System.out.println("BCC: " + component);
                }
            } else if (v != parent[u] && discoveryTime[v] < discoveryTime[u]) {
                lowTime[u] = Math.min(lowTime[u], discoveryTime[v]);
                stack.push(new int[]{u, v});
            }
        }
    }

    public void findBCCs() {
        boolean[] visited = new boolean[vertices];
        int[] discoveryTime = new int[vertices];
        int[] lowTime = new int[vertices];
        int[] parent = new int[vertices];
        Stack<int[]> stack = new Stack<>();

        Arrays.fill(parent, -1);

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                findBCCsUtil(i, visited, discoveryTime, lowTime, parent, stack);
            }
        }

        while (!stack.isEmpty()) {
            List<String> component = new ArrayList<>();
            while (!stack.isEmpty()) {
                component.add(Arrays.toString(stack.pop()));
            }
            System.out.println("BCC: " + component);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        BiConnectedComponents graph = new BiConnectedComponents(vertices);

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter each edge as (source destination):");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }

        System.out.println("Bi-Connected Components:");
        graph.findBCCs();

        scanner.close();
    }
}
