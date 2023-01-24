package com.company;

import java.util.Arrays;


public class Recurtion_sorting {
    public static void main(String[] args) {
     //int[] arr={4,3,2,1};
//     bubble(arr, arr.length-1,0);
//     System.out.println(Arrays.toString(arr));

//        selection(arr, arr.length,0,0);
//        System.out.println(Arrays.toString(arr));

        int[] arr={5,4,3,2,1};
//        arr=mergesort(arr);
//        System.out.println(Arrays.toString(arr));
//        mergesortinplace(arr,0, arr.length);
//        System.out.println(Arrays.toString(arr));

//        quicksort(arr,0, arr.length-1);
//        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
   static  void bubble(int[] arr,int r,int c ){
        if(r==0){
            return;
        }
        if(c<r){
            if(arr[c]>arr[c+1]){
                int temp=arr[c];
                arr[c]=arr[c+1];
                arr[c+1]=temp;
            }
            bubble(arr,r,c+1);
        }else{
            bubble(arr,r-1,0);
        }
   }
    static void selection(int[] arr,int r,int c,int max) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            if (arr[c] > arr[max]) {
                selection(arr, r, c + 1, c);
            } else {
                selection(arr, r, c + 1, max);
            }
        } else {
            int temp = arr[max];
            arr[max] = arr[r - 1];
            arr[r - 1] = temp;
            selection(arr, r - 1, 0, 0);
        }
    }
    static  int[] mergesort(int [] arr){
        if(arr.length==1){
            return arr;
        }
        int mid= arr.length / 2;
        int[] left=mergesort(Arrays.copyOfRange(arr,0,mid));
        int[] right=mergesort(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(left,right);
    }
    private static int[] merge(int[] first, int[] second) {
        int[] mix=new  int[first.length + second.length];
        int i=0,j=0,k=0;
        while(i< first.length && j< second.length){
            if(first[i]<second[j]){
                mix[k]=first[i];
                i++;
            }else{
                mix[k]=second[j];
                j++;
            }
            k++;
        }
        while(i< first.length){
            mix[k]=first[i];
            i++;
            k++;
        }
        while(j< second.length){
            mix[k]=second[j];
            j++;
            k++;
        }
        return mix;
    }
    static  void mergesortinplace(int[] arr, int s,int e){
        if(e-s==1){
            return;
        }
        int mid= (s+e)/2;
       mergesortinplace(arr,s,mid);
       mergesortinplace(arr,mid,e);
       mergeinplace(arr,s,mid,e);
    }
    private static void mergeinplace(int[] arr, int s, int m, int e) {
        int[] mix=new  int[e-s];
        int i=s,j=m,k=0;
        while(i< m && j< e){
            if(arr[i]<arr[j]){
                mix[k]=arr[i];
                i++;
            }else{
                mix[k]=arr[j];
                j++;
            }
            k++;
        }
        while(i< m){
            mix[k]=arr[i];
            i++;
            k++;
        }
        while(j< e){
            mix[k]=arr[j];
            j++;
            k++;
        }
        for(int l=0;l<mix.length;l++){
            arr[s+l]=mix[l];
        }
    }
    static void quicksort(int[] arr,int low,int high){
        if(low>=high){
            return;
        }
        int s=low;
        int e=high;
        int m=s+(e-s)/2;
        int pivot=arr[m];
        while(s<=e){
            while(arr[s]<pivot){
                s++;
            }
            while (arr[e]>pivot){
                e--;
            }
            if(s<=e){
                int temp=arr[s];
                arr[s]=arr[e];
                arr[e]=temp;
                s++;
                e--;
            }
        }
        quicksort(arr,low,e);
        quicksort(arr,s,high);
    }
}
