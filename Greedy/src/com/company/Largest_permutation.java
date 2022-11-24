package com.company;


import java.util.Arrays;

//Q:Given an array of random permutation of numbers from 1 to N.Given B,the number of swaps in A that we can make
//  Find the largest permutation posible
public class Largest_permutation {
    static int[] larper(int arr[],int B){
        int max= arr.length;

        int i=0;
        while(B>0 && i< arr.length){

            int d=pos(arr,max);
            if(i!=d){
                B-=1;
                int temp=arr[i];
                arr[i]=arr[d];
                arr[d]=temp;

            }
            i++;
            max--;
        }
        return arr;
    }

    static int pos(int arr[],int val){
        for(int i=0;i< arr.length;i++){
            if(arr[i]==val){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[]={1,3,2};
        System.out.println(Arrays.toString(larper(arr,3)));
    }
}
