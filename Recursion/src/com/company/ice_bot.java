package com.company;

import java.util.Arrays;
import java.util.Stack;

public class ice_bot {
    static int count=0;

    public static void main(String[] args) {
//        int[][] arr={
//                {0,0,0,0,9,0},
//                {0,0,0,0,0,0},
//                {0,0,0,0,0,0}
//        };
//        boolean[][] arr2={
//                {true,true,true,true,true,true},
//                {true,true,true,true,true,true},
//                {true,true,true,true,true,true}
//        };
//        allpath(arr2,2,0,arr,1);
        System.out.println(count-1);
//        int[][] grid={
//                {3, 4, 7, 8, 9, 10},
//                {2, 5, 6, 15, 14, 11},
//                {1, 18, 17, 16, 13, 12}
//        };
////        System.out.println(isTrue(grid));
        int[] arr={100,80,60,70,70,75,85};
        System.out.println(Arrays.toString(stockspan(arr)));
    }

    static void allpath(boolean[][] maze,int r,int c,int[][] path,int step){
        if(r== 2 && c==1 && step==18 && path[0][1]==4 && path[0][4]==9 && path[2][4]==13){
//            if(r== 2 && c==1 && path[0][1]==4 && path[0][4]==9 && path[2][4]==13 && isTrue(path)){
            path[r][c]=step;
            if(isTrue(path)){
                count+=1;
                for(int[] arr : path){
                    System.out.println(Arrays.toString(arr));
                }

                System.out.println();
                return;
            }

        }
        if(!maze[r][c]){
            return;
        }
        maze[r][c]=false;
        path[r][c]=step;
        if(r< maze.length-1){
            allpath(maze,r+1,c,path,step+1);
        }
        if(c< maze[0].length-1){
            allpath(maze,r,c+1,path,step+1);
        }
        if(r>0){
            allpath(maze,r-1,c,path,step+1);
        }
        if(c>0){
            allpath(maze,r,c-1,path,step+1);
        }
        maze[r][c]=true;
    }

    static boolean isTrue(int[][] matrix){
        int[] arr=new int[19];
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j< matrix[0].length;j++){
                arr[matrix[i][j]]++;
            }
        }
//        System.out.println(Arrays.toString(arr));
        for(int i=1;i< arr.length;i++){
            if(arr[i]!=1){
                return false;
            }
        }
        return true;
    }

    static int[] stockspan(int[] arr){
        int[] ans=new int[arr.length];
        Stack<Integer> stack=new Stack<>();
        ans[0]=1;
        stack.push(0);
        for(int i=1;i< arr.length;i++){
            while(!stack.empty() && arr[stack.peek()]<=arr[i]){
                stack.pop();
            }
            if(stack.empty()){
                ans[i]=i+1;
            }else {
                ans[i]=i-stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }





//
//    [3, 4, 7, 8, 9, 10]
//            [2, 5, 6, 15, 14, 11]
//            [1, 18, 17, 16, 13, 12]
}
