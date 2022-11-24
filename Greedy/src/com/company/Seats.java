package com.company;

import java.util.ArrayList;
import java.util.List;

public class Seats {
    static int seats(String A){
        int MOD=10000003;
        List<Integer> list=new ArrayList<>();
        int c=0;
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)=='x'){
                list.add(i-c);
                c++;
            }
        }
        if (list.size()==0) return 0;
        int s=list.get(list.size()/2);
        int total=0;
        for (int i = 0; i < list.size(); i++) {
            total+=Math.abs(list.get(i)-s);
            total%=MOD;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(seats(".x..x..xx."));
    }
}
