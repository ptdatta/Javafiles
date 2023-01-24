package com.company;

import java.util.ArrayList;

public class Adjacency_list {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<=3;i++){
            adj.add(new ArrayList<Integer>());
        }

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(1).add(3);
        adj.get(3).add(1);

        System.out.println(adj);
    }

}
