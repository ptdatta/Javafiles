package com.company;

import java.util.Arrays;

public class next_permutation {

    static  int factorial(int n){
        if(n<2){
            return 1;
        }
        return n*factorial(n-1);
    }

    static void allPermutatiion(int n,int [] arr){
        int a=factorial(5);
        Arrays.sort(arr);
        for(int i=0;i<a;i++){
            System.out.println(Arrays.toString(arr));
            nextPermutation(arr);
        }
    }
    static void nextPermutation(int[] nums) {
        if(nums==null || nums.length<=1) return;
        int i=nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1])i--;
        if(i>=0){
            int j=nums.length-1;
            while(nums[j]<=nums[i])j--;
            swap(nums,i,j);
        }
        reverse(nums,i+1,nums.length-1);
    }
    static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    static void reverse(int[] nums,int i,int j){
        while(i<j) swap(nums,i++,j--);
    }
    public static void main(String[] args) {
        int[] nums={4,5,3,8,2};
        allPermutatiion(5,nums);
    }

}
