package graph_sort;

import java.util.*;

public class GraphSort {
    private int[] arr;
    private List<List<Integer>> adjList;
    private int[] indegree;
    private int n;

    public GraphSort(int n, int[] arr) {
        this.n = n;
        this.arr = arr;
        adjList = new ArrayList<>();
        indegree = new int[n];

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void createAdjacencyList() {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] >= arr[i]) {
                    adjList.get(i).add(j);
                    indegree[j]++;
                }
            }
        }
    }

    public List<Integer> topologicalSort() {
        Stack<Integer> source = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                source.push(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!source.isEmpty()) {
            int pos = source.pop();
            result.add(arr[pos]);
            for (int position : adjList.get(pos)) {
                indegree[position]--;
                if (indegree[position] == 0) {
                    source.push(position);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the length of the array:");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        GraphSort graphSort = new GraphSort(n, arr);

        graphSort.createAdjacencyList();
        List<Integer> sortedArray = graphSort.topologicalSort();

        System.out.println("The sorted array will be:");
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
    }
}
