package com.company;

public class factorial {

    static long fac(long n,long[] arr){
        if(n<2) return 1;
        if(arr[(int) n]!=0){
            return arr[(int) n];
        }
        arr[(int)n]=n*fac(n-1,arr);
        return arr[(int)n];
    }

    public static void main(String[] args) {
        long[] arr=new long[1000000];
        System.out.println(fac(49,arr));
    }
}
