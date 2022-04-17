package com.company;

public class Recurtion {
    public static void main(String[] args) {
          // massage();
        print(1);
        System.out.println(fib(45));
        int[] arr={5,6,9,14,25,85,100,126,145};
        System.out.println(b_search(arr,14,0, arr.length-1));
    }
     static  void massage(){
         System.out.println("hello world");
         massage1();
     }
     static  void massage1(){
         System.out.println("hello world");
         massage2();
     }
     static  void massage2(){
         System.out.println("hello world");
         massage3();
     }
     static  void massage3(){
         System.out.println("hello world");
     }
     static void print(int n){
        if(n==5){
            System.out.println(5);
            return;
        }
         System.out.println(n);
         print(n+1);
     }
     static int fib(int n){
       if(n<2){
           return n;
       }
        return fib(n-1)+fib(n-2);
     }
     static  int b_search(int[] arr,int target,int s,int e){
        if(s>e){
            return -1;
        }
        int m=s+(e-s)/2;
        if(target==arr[m]){
            return m;
        }
        if(target<arr[m]){
            return b_search(arr,target,s,m-1);
        }
        return b_search(arr,target,m+1,e);
     }
}
