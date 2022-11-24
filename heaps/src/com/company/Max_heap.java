package com.company;

import java.util.Arrays;

public class Max_heap {
    static void heapify(int[] arr, int n, int i)
    {
        // Find parent
        int parent = (i - 1) / 2;


            if (arr[i] > arr[parent]) {

                // swap arr[i] and arr[parent]
                int temp = arr[i];
                arr[i] = arr[parent];
                arr[parent] = temp;

                // Recursively heapify the parent node
                heapify(arr, n, parent);
            }

    }


    static void insert(int[] arr,int n,int val){
        n+=1;
        arr[n-1]=val;
        heapify(arr,n,n-1);
        return ;
    }
    static void delete(int arr[], int n)
    {
        // Get the last element
        int lastElement = arr[n - 1];

        // Replace root with first element
        arr[0] = lastElement;

        // Decrease size of heap by 1
        n = n - 1;

        // heapify the root node
        heapify(arr, n, 0);

    }
    static void build(int arr[],int n){
        int s=(arr.length/2)-1;
        for(int i=s;i>=0;i--){
            heapify(arr,n,i);
        }
    }
    public static void main(String[] args) {
        int []arr=new int[10];
        arr[0] = 3;
        arr[1] = 5;
        arr[2] = 7;
        arr[3] = 12;
        arr[4] = 20;
        build(arr,5);
        System.out.println(Arrays.toString(arr));
        insert(arr, 5,100);
        insert(arr,6,1);
        System.out.println(Arrays.toString(arr));
        delete(arr,7);
        System.out.println(Arrays.toString(arr));
    }
}
