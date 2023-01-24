package com.company;
public class Odd_Even {
    static boolean ODD(int n){
        return (n&1)==1;
    }
    public static void main(String[] args) {
        System.out.println(ODD(64));
    }
}
