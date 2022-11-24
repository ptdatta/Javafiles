package com.company;

import java.util.Arrays;

public class Pascle_triangle {

    static int[] triangle(int k){
        if(k==0){
            return new int[]{1};
        }
        int ans[]=new int[k+1];
        ans[0]=1;
        ans[ans.length-1]=1;
        int prev[]=triangle(k-1);
        for(int i=1;i< ans.length-1;i++){
            ans[i]=prev[i-1]+prev[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(triangle(9)));
    }
}
