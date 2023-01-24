package com.company;

import java.util.ArrayList;

public class Rotate {
    static void rotate(ArrayList<ArrayList<Integer>> a) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<a.size();i++){
            ArrayList<Integer> sub=new ArrayList<>();
            for(int j=0;j<a.size();j++){
                sub.add(a.get(a.size()-1-j).get(i));
            }
            ans.add(sub);
        }
        for(int i=0;i<ans.size();i++){
            ArrayList<Integer> sub=new ArrayList<>();
            for(int j=0;j<ans.size();j++){
                sub.add(ans.get(i).get(j));
            }
            a.add(sub);
        }
        for(int i=0;i<ans.size();i++){
            a.remove(0);
        }

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a=new ArrayList<>(2);
        ArrayList<Integer> a1=new ArrayList<>();
        a1.add(1);
        a1.add(2);
        a1.add(3);
        ArrayList<Integer> a2=new ArrayList<>();
        a2.add(4);
        a2.add(5);
        a2.add(6);
        ArrayList<Integer> a3=new ArrayList<>();
        a3.add(7);
        a3.add(8);
        a3.add(9);
        a.add(a1);
        a.add(a2);
        a.add(a3);
        System.out.println(a);
        rotate(a);
        System.out.println(a);
    }
}
