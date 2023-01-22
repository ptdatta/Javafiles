package com.company;

public class countone {
    public static void main(String[] args) {
        int n=5;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(ones(n));
    }

    private static int ones(int n) {
        int count=0;
//        while(n>0){
//            count++;
//            n-=(n&-n);
//        }
        while (n>0){
            count++;
            n=n&(n-1);
            System.out.println(n);
        }
        return count;
    }


}
