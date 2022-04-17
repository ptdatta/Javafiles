package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        for (int i = 0; i < 50; i++) {
//            System.out.println(fibo(i));
//        }
        System.out.println(fibo(50));
    }
    static  int fibo(int n){
        return (int)((Math.pow((1+Math.sqrt(5))/2,n)) / Math.sqrt(5));
    }
}
