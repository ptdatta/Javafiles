package com.company;

public class Segment_sum {
    int st[]=new int[40]; //array to store segment tree



    int RMQUtil(int ss, int se, int qs, int qe, int index)
    {
        // If segment of this node is a part of given range, then
        // return the min of the segment
        if (qs <= ss && qe >= se)
            return st[index];

        // If segment of this node is outside the given range
        if (se < qs || ss > qe)
            return 0;

        // If a part of this segment overlaps with the given range
        int mid = ss+(se-ss)/2;
        return RMQUtil(ss, mid, qs, qe, 2 * index + 1)+
                RMQUtil(mid + 1, se, qs, qe, 2 * index + 2);
    }

    void updateValueUtil(int ss, int se, int i, int diff, int si)
    {

        if (i < ss || i > se)
            return;

        st[si] += diff;
        if (se != ss) {
            int mid = ss+(se-ss)/2;
            updateValueUtil(ss, mid, i, diff, 2 * si + 1);
            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
        }
    }

    void updateValue(int arr[], int n, int i, int new_val)
    {
        // Check for erroneous input index
        if (i < 0 || i > n - 1) {
            System.out.println("Invalid Input");
            return;
        }

        // Get the difference between new value and old value
        int diff = new_val - arr[i];

        // Update the value in array
        arr[i] = new_val;

        // Update the values of nodes in segment tree
        updateValueUtil(0, n - 1, i, diff, 0);
    }


    // A recursive function that constructs Segment Tree for
    // array[ss..se]. si is index of current node in segment tree st
    int constructSTUtil(int arr[], int ss, int se, int si)
    {

        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }

        int mid = ss+(se-ss)/2;
        st[si] = constructSTUtil(arr, ss, mid, si * 2 + 1)+
                constructSTUtil(arr, mid + 1, se, si * 2 + 2);
        return st[si];
    }

    // Driver program to test above functions
    public static void main(String args[])
    {
        int arr[] = {1, 3, 5, 7, 9, 11};
        int n = arr.length;
        Segment_sum tree = new Segment_sum();

        // Build segment tree from given array
        tree.constructSTUtil(arr,0, n-1,0);

        System.out.println(tree.RMQUtil(0,n-1,0,3,0));
        tree.updateValue(arr, arr.length, 1,10);
        System.out.println(tree.RMQUtil(0,n-1,0,3,0));
    }

}
