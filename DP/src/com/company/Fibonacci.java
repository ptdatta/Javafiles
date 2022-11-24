package com.company;

public class Fibonacci {
    static long fibonacci(int n,long[] memo){
        if(n<2) return 1;
        if(memo[n]!=0){
            return memo[n];
        }
        memo[n]=fibonacci(n-1,memo)+fibonacci(n-2,memo);
        return memo[n];
    }

    static long fib(int n){
        if(n<2) return 1;
        return fib(n-1)+fib(n-2);
    }
    static long tfib(int n){
        long[] arr=new long[n+2];
        arr[1]=1;
        for(int i=2;i< arr.length;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n+1];
    }

    public static void main(String[] args) {
        long[] memo=new long[1000000];
        System.out.println(fibonacci(47,memo));
        System.out.println(fib(47));
        System.out.println(tfib(47));
    }
}
