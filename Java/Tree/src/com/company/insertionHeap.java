package com.company;

// Java program for implementing insertion in Heaps
public class insertionHeap {

    // Function to heapify ith node in a Heap
    // of size n following a Bottom-up approach
    static void heapify(int[] arr, int n, int i)
    {
        // Find parent
        int parent = (i - 1) / 2;

        if (arr[parent] > 0) {
            // For Max-Heap
            // If current node is greater than its parent
            // Swap both of them and call heapify again
            // for the parent
            if (arr[i] > arr[parent]) {

                // swap arr[i] and arr[parent]
                int temp = arr[i];
                arr[i] = arr[parent];
                arr[parent] = temp;

                // Recursively heapify the parent node
                heapify(arr, n, parent);
            }
        }
    }

    // Function to insert a new node to the heap.
    static int insertNode(int[] arr, int n, int Key)
    {
        // Increase the size of Heap by 1
        n = n + 1;

        // Insert the element at end of Heap
        arr[n - 1] = Key;

        // Heapify the new node following a
        // Bottom-up approach
        heapify(arr, n, n - 1);

        // return new size of Heap
        return n;
    }

    /* A utility function to print array of size n */
    static void printArray(int[] arr, int n)
    {
        for (int i = 0; i < n; ++i)
            System.out.println(arr[i] + " ");

        System.out.println();
    }

    static int PowerOf2(int power)
    {
        return (1<<power);
    }
    static void PrintTreeArray(int array[], int arrayLength)
    {
        int currentLevel = 0;
        int maxPerLevel = PowerOf2(currentLevel);
        for(int i = 0; i < arrayLength; i++)
        {
            if(i == maxPerLevel-1)
            {
                System.out.println("\n");
                currentLevel++;
                maxPerLevel = PowerOf2(currentLevel);
            }
            System.out.print(" "+array[i]);
        }
    }

    // Driver Code
    public static void main(String args[])
    {
        // Array representation of Max-Heap
        // 10
        // / \
        // 5 3
        // / \
        // 2 4

        // maximum size of the array
        int MAX = 1000;
        int[] arr = new int[MAX];

        // initializing some values
        arr[0] = 10;
        arr[1] = 5;
        arr[2] = 3;
        arr[3] = 2;
        arr[4] = 4;

        // Current size of the array
        int n = 5;

        // the element to be inserted
        int Key = 15;

        // The function inserts the new element to the heap and
        // returns the new size of the array
        n = insertNode(arr, n, Key);

        printArray(arr, n);
        PrintTreeArray(arr,n);
        // Final Heap will be:
        // 15
        // / \
        // 5	 10
        // / \ /
        // 2 4 3
    }
}

// The code is contributed by Gautam goel
