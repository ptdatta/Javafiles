package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Adjacency_matrix {
    public static void main(String[] args) {
        int adj[][]=new int[4][4];
        adj[1][2]=1;
        adj[2][1]=1;

        adj[2][3]=1;
        adj[3][2]=1;

        adj[1][3]=1;
        adj[3][1]=1;

        for(int i=0;i<4;i++){
            System.out.println(Arrays.toString(adj[i]));
        }
    }
}
