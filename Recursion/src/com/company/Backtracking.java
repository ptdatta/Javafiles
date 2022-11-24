package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking {
    static int count(int r,int c){
        if(r==1 || c==1){
            System.out.println("("+r+","+c+")");
            return 1;
        }
        System.out.println("("+r+","+c+")");
        int l=count(r-1,c);
        int ri=count(r,c-1);
        return l+ri;
    }

    static void path(String p,int r ,int c){
        if(r==1 && c==1){
            System.out.println(p);
            return ;
        }
        if(r>1){
            path(p+'D',r-1,c);
        }
        if(c>1){
            path(p+'R',r,c-1);
        }
    }

    static void pathDia(String p,int r ,int c){
        if(r==1 && c==1){
            System.out.println(p);
            return ;
        }
        if(r>1 && c>1){
            pathDia(p+'d',r-1,c-1);
        }
        if(r>1){
            pathDia(p+'D',r-1,c);
        }
        if(c>1){
            pathDia(p+'R',r,c-1);
        }
    }

    static void allpath(String p,boolean[][] maze,int r,int c,int[][] path,int step){
        if(r== maze.length-1 && c== maze[0].length-1){
            System.out.println(p);
            path[r][c]=step;
            for(int[] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            return;
        }
        if(!maze[r][c]){
            return;
        }
        maze[r][c]=false;
        path[r][c]=step;
        if(r< maze.length-1){
            allpath(p+'D',maze,r+1,c,path,step+1);
        }
        if(c< maze[0].length-1){
            allpath(p+'R',maze,r,c+1,path,step+1);
        }
        if(r>0){
            allpath(p+'U',maze,r-1,c,path,step+1);
        }
        if(c>0){
            allpath(p+'L',maze,r,c-1,path,step+1);
        }
        maze[r][c]=true;
    }


    public static void main(String[] args) {
        boolean[][] arr={
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        int[][] path=new int[arr.length][arr[0].length];
        allpath("",arr,0,0,path,1);
//        System.out.println(count(3,3));
//        path("",3,3);
    }

}
