package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

//Q: Given a list of intervals: [start,end]
//   Find the length of the maximal set of mutually disjoint intervals
public class Disjoint_intervals {
    static int intervals(int[][] matrix){
        Arrays.sort(matrix,(int[] num1,int[] num2)->Integer.compare(num1[1],num2[1]));
        int count=1;
        int prev_s=matrix[0][0],prev_e=matrix[0][1];
        for(int i=1;i< matrix.length;i++){
            if(matrix[i][0]>prev_e){
                prev_s=matrix[i][0];
                prev_e=matrix[i][1];
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int matrix[][]={{1,2},{2,10},{4,6}};
        System.out.println(intervals(matrix));

    }
}
