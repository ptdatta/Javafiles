package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    static ArrayList<Integer> bfsdisplay(int v,ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs=new ArrayList<>();
        boolean vis[]=new boolean[v+1];
        for(int i=1;i<=v;i++){
            if(vis[i]==false){
                Queue<Integer> q =new LinkedList<>();
                q.add(i);
                vis[i]=true;
                while (!q.isEmpty()){
                    Integer node=q.poll();
                    bfs.add(node);

                    for(Integer it : adj.get(node)){
                        if(vis[it]==false){
                            vis[it]=true;
                            q.add(it);
                        }
                    }
                }
            }
        }
        return bfs;
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

        System.out.println(bfsdisplay(7,adj));
    }
}
