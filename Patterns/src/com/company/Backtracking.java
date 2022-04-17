package com.company;

import java.util.ArrayList;

public class Backtracking {
    public static void main(String[] args) {
        System.out.println(count(3,3));
//        path("",4,4);
        System.out.println(path_r("",3,3));
        System.out.println(pathdiagonal("",3,3));
    }
    static  int count(int r,int c){
        if(r==1 || c==1){
            return 1;
        }
        int left=count(r-1,c);
        int right=count(r,c-1);
        return left + right;
    }

    static  void path(String p,int r,int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }
        if(r>1){
            path(p+'D',r-1,c);
        }
        if(c>1){
            path(p+'R',r,c-1);
        }
    }

    static ArrayList<String> path_r(String p, int r, int c){
        if(r==1 && c==1){
           ArrayList<String> list=new ArrayList<>();
           list.add(p);
           return list;
        }
        ArrayList<String> list=new ArrayList<>();
        if(r>1){
            list.addAll(path_r(p+'D',r-1,c));
        }
        if(c>1){
            list.addAll(path_r(p+'R',r,c-1));
        }
        return  list;
    }

    static ArrayList<String> pathdiagonal(String p, int r, int c){
        if(r==1 && c==1){
           ArrayList<String> list=new ArrayList<>();
           list.add(p);
           return list;
        }
        ArrayList<String> list=new ArrayList<>();
        if(r>1 && c>1){
            list.addAll(pathdiagonal(p+'D',r-1,c-1));
        }
        if(r>1){
            list.addAll(pathdiagonal(p+'V',r-1,c));
        }
        if(c>1){
            list.addAll(pathdiagonal(p+'H',r,c-1));
        }
        return  list;
    }
}
