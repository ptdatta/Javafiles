package com.company;

public class Magic_num  {
    public static void main(String[] args) {
        int n=6;
        int ans=0;
        int base=5;
        while(n>0){
            int l=n&1;
            n=n>>1;
            ans+=l*base;
            base*=5;
        }
        System.out.println(ans);
    }
}
