package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class FindPaths {

    static int paths(int[][] grid, int r1, int c1, int s, int[] pos) {
        int n= grid.length*grid[0].length;
        if(r1== grid.length-1 && c1==1 && s==18 && grid[pos[0]][pos[1]]==(n/4) && grid[pos[2]][pos[3]]==(n/2) && grid[pos[4]][pos[5]]==((n*3)/4)){
            grid[r1][c1]=s;
            System.out.println();
            for(int[] i : grid){
                System.out.println(Arrays.toString(i));
            }
            grid[r1][c1]=0;
            return 1;
        }
        grid[r1][c1]=s;
        int w=0,x=0,y=0,z=0;
        if(r1>0  && grid[r1-1][c1]==0){
           w=paths(grid,r1-1,c1,s+1, pos);
        }
        if(c1>0  && grid[r1][c1-1]==0){
           x=paths(grid,r1,c1-1,s+1, pos);
        }
        if(r1< grid.length-1  && grid[r1+1][c1]==0){
           y=paths(grid,r1+1,c1,s+1, pos);
        }
        if(c1<grid[0].length-1  && grid[r1][c1+1]==0){
           z=paths(grid,r1,c1+1,s+1, pos);
        }
        grid[r1][c1]=0;
        return w+x+y+z;
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int row=input.nextInt();
        int col=input.nextInt();
        int[][] grid=new int[row][col];
        int[] pos=new int[6];
        for(int i=0;i< pos.length;i++){
            if(i%2==0){
                pos[i]=row-1-input.nextInt();
            }else {
                pos[i]=input.nextInt();
            }
        }
        System.out.println(paths(grid,2,0,1,pos));


    }



}
