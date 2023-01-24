package com.company;

public class Resurtion_lvl1 {
    public static void main(String[] args) {
      //  funrev(16);
        //System.out.println(fac(5));
        //System.out.println(sumofdigits(123456789));
       // System.out.println(reverse(4521));
        System.out.println(count0(102100));
    }
    static  void fun(int n){
        if(n==0){
            return;
        }
        fun(n-1);
        System.out.println(n);
    }
    static  void funrev(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        funrev(n-1);
    }
    static int fac(int n){
        if(n==0){
            return 1;
        }
        return n*fac(n-1);
    }
    static int sumofdigits(int n){
        if(n<1){
            return 0;
        }
        return (n%10)+sumofdigits(n/10);
    }
    static int reverse(int n){
       int digits=(int) (Math.log10(n))+1;
       return  helper(n,digits);
    }
    private static int helper(int n, int digits) {
        if(n%10==0){
            return n;
        }
        int rem=n%10;
        return rem*(int)(Math.pow(10,digits-1))+helper(n/10,digits-1);
    }
    static  int count0(int n){
        return helper2(n,0);
    }
    private static int helper2(int n, int c) {
        if(n==0){
            return c;
        }
        int rem =n%10;
        if(rem==0){
            return helper2(n/10,c+1);
        }
        return helper2(n/10,c);
    }
}
