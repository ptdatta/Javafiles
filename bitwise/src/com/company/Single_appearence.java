package com.company;

public class Single_appearence {

    static int one(int[] arr){
        int one=0;
        for (int i : arr){
            one^=i;
        }
        return one;
    }
    public static void main(String[] args) {
    int[] arr={2,2,1,1,4,4,4,8,8};
        System.out.println(one(arr));
    }
}
