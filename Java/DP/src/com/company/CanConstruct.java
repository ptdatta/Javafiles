package com.company;

import java.util.HashMap;

public class CanConstruct {

    static boolean canConstruct(String s,String[] arr){
        if(s.isEmpty()) return true;
        for(int i=0;i< arr.length;i++){
            if(s.indexOf(arr[i])==0){
                if(canConstruct(s.substring(arr[i].length()),arr)){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean canConstructDP(String s, String[] arr, HashMap<String,Boolean> memo){
        if(s.isEmpty()) return true;
        if(memo.containsKey(s)) return memo.get(s);
        for(int i=0;i< arr.length;i++){
            if(s.indexOf(arr[i])==0){
                if(canConstructDP(s.substring(arr[i].length()),arr,memo)){
                    memo.put(s,true);
                    return memo.get(s);
                }
            }
        }
        memo.put(s,false);
        return memo.get(s);
    }
    public static void main(String[] args) {
        HashMap<String,Boolean> memo=new HashMap<>();
        String s="eeeeeeeeeeeeeeeeeeeeeeeeeeeef";
        String[] arr={"e","ee","eee","eeee","eeeee"};
        System.out.println(canConstructDP(s,arr,memo));
        System.out.println(canConstruct(s,arr));
    }
}
