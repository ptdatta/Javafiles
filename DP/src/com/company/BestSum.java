package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSum {
    static ArrayList<Integer> bestSum(int val, int[] arr){
        if(val==0) return new ArrayList<>();
        if(val<0) return null;
        ArrayList<Integer> shortest=null;
        for(int i=0;i< arr.length;i++){
            int reminder=val-arr[i];
            ArrayList<Integer> list=bestSum(reminder,arr);
            if(list!=null){
                list.add(arr[i]);
                if(shortest==null || shortest.size()>list.size()){
                    shortest=list;
                }
            }
        }
        return shortest;
    }
    static ArrayList<Integer> bestSumDP(int val, int[] arr,  HashMap<Integer,ArrayList<Integer>> memo){
        if(val==0) return new ArrayList<>();
        if(val<0) return null;
        if(memo.containsKey(val)) return memo.get(val);
        ArrayList<Integer> shortest=null;
        for(int i=0;i< arr.length;i++){
            int reminder=val-arr[i];
            ArrayList<Integer> list=bestSumDP(reminder,arr,memo);
            if(list!=null){
                ArrayList<Integer> ilist=new ArrayList<>();
                ilist.add(arr[i]);
                ilist.addAll(list);
                if(shortest==null || shortest.size()>list.size()){
                    shortest=ilist;
                }
            }
        }
        memo.put(val,shortest);
        return shortest;
    }

    public static void main(String[] args) {
        HashMap<Integer,ArrayList<Integer>> memo=new HashMap<>();
       int arr[]={1,2,5,25};
        System.out.println(bestSumDP(100,arr,memo));
        System.out.println(bestSum(100,arr));

    }
}
