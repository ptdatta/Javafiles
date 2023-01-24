package com.company;

public class Powerof2 {
    public static void main(String[] args) {
        int n=0;
        boolean ans=(n & (n-1))==0;
        if(n==0){
            ans=false;
        }
        System.out.println(ans);

    }
}
