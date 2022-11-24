package com.company;

public class countfromthree {
    static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for(int num : nums)
                count += (num&(1<<i)) >> i;
            result |= (count%3) << i;
        }
        return result;
    }
    public static void main(String[] args) {
     int[] arr={2,2,3,2};
        System.out.println(singleNumber(arr));
    }
}
