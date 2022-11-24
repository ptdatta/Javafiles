package com.company;

import java.util.ArrayList;

public class DFS {

    static void dfs(int node,boolean[] vis,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> storeDfs){
        storeDfs.add(node);
        vis[node]=true;
        for(Integer it : adj.get(node)){
            if(vis[it]==false){
                dfs(it,vis,adj,storeDfs);
            }
        }
    }

    static ArrayList<Integer> dfsDiaplay(int v,ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> storeDfs=new ArrayList<>();
        boolean vis[]=new boolean[v+1];
        for(int i=1;i<=v;i++){
            if(vis[i]==false){
                dfs(i,vis,adj,storeDfs);
            }
        }
        return storeDfs;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<=7;i++){
            adj.add(new ArrayList<Integer>());
        }

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(2).add(7);
        adj.get(7).add(2);

        adj.get(5).add(3);
        adj.get(3).add(5);
        adj.get(5).add(7);
        adj.get(7).add(5);

        adj.get(4).add(6);
        adj.get(6).add(4);

        System.out.println(dfsDiaplay(7,adj));
    }
}
