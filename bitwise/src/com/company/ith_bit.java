package com.company;

public class ith_bit {

    static int getbit(int n,int i){
      return ((n&(1<<i))==0) ? 0 : 1;
    }
    static int setbit(int n,int i){
        return ((n|(1<<i)));
    }
    static int resetbit(int n,int i){
        return ((n&(~(1<<i))));
    }

    public static void main(String[] args) {
        int n=9;
        System.out.println(getbit(8,3));
        n=setbit(n,2);
        System.out.println(n);
        n=resetbit(n,3);
        n=resetbit(n,0);
        System.out.println(n);

    }
}
