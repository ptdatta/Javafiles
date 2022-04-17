package com.company;

import java.util.Arrays;

public class Maze {
    public static void main(String[] args) {
     boolean[][] board={
             {true,true,true},
             {true,true,true},
             {true,true,true}
     };
//     maze("",board,0,0);

//        mazeallpath("",board,0,0);

        int[][] path=new int[board.length][board[0].length];
        printpath("",board,0,0,path,1);
    }

    static  void maze(String p,boolean[][] maze,int r,int c){
        if(r== maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        if(r<maze.length-1){
            maze(p+'D',maze,r+1,c);
        }
        if(c<maze[0].length-1){
            maze(p+'R',maze,r,c+1);
        }
    }

    static  void mazeallpath(String p,boolean[][] maze,int r,int c){
        if(r== maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        maze[r][c]=false;
        if(r<maze.length-1){
            mazeallpath(p+'D',maze,r+1,c);
        }
        if(c<maze[0].length-1){
            mazeallpath(p+'R',maze,r,c+1);
        }
        if(r>0){
            mazeallpath(p+'U',maze,r-1,c);
        }
        if(c>0){
            mazeallpath(p+'L',maze,r,c-1);
        }
        maze[r][c]=true;
    }

    static  void printpath(String p,boolean[][] maze,int r,int c,int[][] path,int step){
        if(r== maze.length-1 && c==maze[0].length-1){
            path[r][c]=step;
            System.out.println(p);
            for(int[] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println();
            return;
        }
        if(!maze[r][c]){
            return;
        }
        maze[r][c]=false;
        path[r][c]=step;
        if(r<maze.length-1){
            printpath(p+'D',maze,r+1,c,path,step+1);
        }
        if(c<maze[0].length-1){
            printpath(p+'R',maze,r,c+1,path,step+1);
        }
        if(r>0){
            printpath(p+'U',maze,r-1,c,path,step+1);
        }
        if(c>0){
            printpath(p+'L',maze,r,c-1,path,step+1);
        }
        maze[r][c]=true;
        path[r][c]=0;
    }
}
