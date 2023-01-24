package com.company;

public class Single_appearence {

    static int one(int[] arr){
        int one=0;
        for (int i : arr){
            one^=i;
        }
        return one;
    }

    static int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        for(int element : nums){
            // if element is repeated only once ones will contain that element
            ones = (ones ^ element) & ~(twos);
            twos = (twos ^ element) & ~(ones);
        }
        return ones;
    }
    public static void main(String[] args) {
    int[] arr={2,2,2,2,2,1,1,1,1,1,4,4,4,4,4,8};
        System.out.println(singleNumber(arr));
    }
}
