package com.company;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int [] arr={4,3,2,7,8,2,3,1};
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubble(int[] arr){
        for(int i=0;i< arr.length;i++){
            for(int j=1;j< arr.length-i;j++){
                if(arr[j-1]>arr[j]){
                    swap(arr,j,j-1);
                }
            }
        }
    }


    static void insertion(int[] arr){
        for(int i=0;i< arr.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }else{
                    break;
                }
            }
        }
    }

    static void selection(int[] arr){
        for(int i=0;i< arr.length;i++) {
            int last = arr.length - 1 - i;
            int maxindex=getmaxindex(arr,0,last);
            swap(arr,maxindex,last);
        }
    }

    private static int getmaxindex(int[] arr, int first, int last) {
        int max=first;
        for(int i=first;i<=last;i++){
            if(arr[max]<arr[i]){
                max=i;
            }
        }
        return max;
    }

    static void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
    //for range 1 to N

     static void cyclic(int[] arr){
        int i=0;
        while(i< arr.length){
            int curr=arr[i]-1;
            if(arr[i]!=arr[curr]){
                swap(arr,i,curr);
            }else{
                i++;
            }
        }
     }
//   static int missingNumber(int[] nums) {
//        int n=nums.length;
//       cyclic(nums);
//        int ans=n;
//        for(int i=0;i<n;i++){
//            if(i!=nums[i]){
//                n=i;
//            }
//        }
//        return ans;
//    }
}
