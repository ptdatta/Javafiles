package com.company;

import java.util.HashMap;

public class CanSum {
    static boolean canSum(int val,int[] arr){
        if(val==0) return true;
        if (val<0) return false;
        for(int i=0;i< arr.length;i++){
            if(canSum(val-arr[i],arr)){
                return true;
            }
        }
        return false;
    }

    static boolean canSumDP(int val, int[] arr, HashMap<Integer,Boolean> memo){
        if(val==0) return true;
        if (val<0) return false;
        if(memo.containsKey(val)) return memo.get(val);
        for(int i=0;i< arr.length;i++){
            if(canSumDP(val-arr[i],arr,memo)){
                memo.put(val,true);
                return memo.get(val);
            }
        }
        memo.put(val,false);
        return memo.get(val);
    }

    static boolean tcansum(int val,int[] arr){
        boolean[] nums=new boolean[val+1];
        nums[0]=true;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==true){
                for(int j=0;j< arr.length;j++){
                    if(i+arr[j]<nums.length) nums[i+arr[j]]=true;
                }
            }
        }
        return nums[val];
    }

    public static void main(String[] args) {
        int arr[]={7,14};
        HashMap<Integer,Boolean> memo=new HashMap<>();
        System.out.println(canSumDP(300,arr,memo));
        System.out.println(canSum(300,arr));
        System.out.println(tcansum(300,arr));

    }
}
