package com.company;

import java.util.HashMap;

public class CountConstruct {
    static int countConstruct(String s,String[] arr){
        if(s.isEmpty()) return 1;
        int count=0;
        for(int i=0;i< arr.length;i++){
            if(s.indexOf(arr[i])==0){
                count+= countConstruct(s.substring(arr[i].length()),arr);
            }
        }
        return count;
    }
    static int countConstructDP(String s,String[] arr,HashMap<String,Integer> memo){
        if(s.isEmpty()) return 1;
        if(memo.containsKey(s)) return memo.get(s);
        int count=0;
        for(int i=0;i< arr.length;i++){
            if(s.indexOf(arr[i])==0){
                count+= countConstructDP(s.substring(arr[i].length()),arr,memo);
            }
        }
        memo.put(s,count);
        return memo.get(s);
    }
    public static void main(String[] args) {
        HashMap<String,Integer> memo=new HashMap<>();
        String s="eeeeeeeeeeeeeeeeeeeeeeeeeeeef";
        String[] arr={"e","ee","eee","eeee","eeeee"};
        System.out.println(countConstructDP(s,arr,memo));
        System.out.println(countConstruct(s,arr));
    }
}
