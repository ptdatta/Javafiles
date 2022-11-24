package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class HowSum {
    static ArrayList<Integer> howSum(int val,int[] arr){
        if(val==0) return new ArrayList<>();
        if(val<0) return null;
        for(int i=0;i< arr.length;i++){
            int reminder=val-arr[i];
            ArrayList<Integer> list=howSum(reminder,arr);
            if(list!=null){
                list.add(arr[i]);
                return list;
            }
        }
        return null;
    }
    static ArrayList<Integer> howSumDP(int val, int[] arr, HashMap<Integer,ArrayList<Integer>> memo){
        if(val==0) return new ArrayList<>();
        if(val<0) return null;
        if(memo.containsKey(val)) return memo.get(val);
        for(int i=0;i< arr.length;i++){
            int reminder=val-arr[i];
            ArrayList<Integer> list=howSumDP(reminder,arr,memo);
            if(list!=null){
                list.add(arr[i]);
                memo.put(val,list);
                return memo.get(val);
            }
        }
        memo.put(val,null);
        return memo.get(val);
    }

    public static void main(String[] args) {
        HashMap<Integer,ArrayList<Integer>> memo=new HashMap<>();
        int[] arr={1,2,5,25};
        System.out.println(howSumDP(100,arr,memo));
        System.out.println(howSum(100,arr));
    }
}
