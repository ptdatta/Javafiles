package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Segment {
    // Program for range minimum query using segment tree

        int st[]=new int[40]; //array to store segment tree



        int RMQUtil(int ss, int se, int qs, int qe, int index)
        {
            // If segment of this node is a part of given range, then
            // return the min of the segment
            if (qs <= ss && qe >= se)
                return st[index];

            // If segment of this node is outside the given range
            if (se < qs || ss > qe)
                return Integer.MAX_VALUE;

            // If a part of this segment overlaps with the given range
            int mid = ss+(se-ss)/2;
            return Math.min(RMQUtil(ss, mid, qs, qe, 2 * index + 1),
                    RMQUtil(mid + 1, se, qs, qe, 2 * index + 2));
        }


        // A recursive function that constructs Segment Tree for
        // array[ss..se]. si is index of current node in segment tree st
        int constructSTUtil(int arr[], int ss, int se, int si)
        {
            // If there is one element in array, store it in current
            // node of segment tree and return
            if (ss == se) {
                st[si] = arr[ss];
                return arr[ss];
            }

            // If there are more than one elements, then recur for left and
            // right subtrees and store the minimum of two values in this node
            int mid = ss+(se-ss)/2;
            st[si] = Math.min(constructSTUtil(arr, ss, mid, si * 2 + 1),
                    constructSTUtil(arr, mid + 1, se, si * 2 + 2));
            return st[si];
        }

        // Driver program to test above functions
        public static void main(String args[])
        {
            int arr[] = {8,2,5,1,4,5,3,9,6,10};
            int n = arr.length;
            Segment tree = new Segment();

            // Build segment tree from given array
            tree.constructSTUtil(arr,0, n-1,0);

            System.out.println(tree.RMQUtil(0,n-1,3,8,0));
        }

// This code is contributed by Ankur Narain Verma

}
