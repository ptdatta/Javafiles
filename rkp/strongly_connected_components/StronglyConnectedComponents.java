package strongly_connected_components;

import java.util.*;

public class StronglyConnectedComponents {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public StronglyConnectedComponents(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    private void fillOrder(int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;
        for (int neighbor : adjacencyList[vertex]) {
            if (!visited[neighbor]) {
                fillOrder(neighbor, visited, stack);
            }
        }
        stack.push(vertex);
    }

    private StronglyConnectedComponents getTranspose() {
        StronglyConnectedComponents transposeGraph = new StronglyConnectedComponents(vertices);
        for (int i = 0; i < vertices; i++) {
            for (int neighbor : adjacencyList[i]) {
                transposeGraph.addEdge(neighbor, i);
            }
        }
        return transposeGraph;
    }

    private void dfs(int vertex, boolean[] visited, List<Integer> component) {
        visited[vertex] = true;
        component.add(vertex);
        for (int neighbor : adjacencyList[vertex]) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, component);
            }
        }
    }

    public void findSCCs() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                fillOrder(i, visited, stack);
            }
        }

        System.out.println(stack.toString());

        StronglyConnectedComponents transposeGraph = getTranspose();
        Arrays.fill(visited, false);

        System.out.println("Strongly Connected Components:");
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!visited[vertex]) {
                List<Integer> component = new ArrayList<>();
                transposeGraph.dfs(vertex, visited, component);
                System.out.println(component);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        StronglyConnectedComponents graph = new StronglyConnectedComponents(vertices);

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter each edge as (source destination):");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }

        graph.findSCCs();

        scanner.close();
    }
}
