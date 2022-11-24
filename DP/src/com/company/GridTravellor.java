package com.company;

import java.util.HashMap;

public class GridTravellor {
    static long travel(int r,int c){
        if(r==1 || c==1) return 1;
        return travel(r-1,c)+travel(r,c-1);
    }

    static long ttravel(int r,int c){
        long[][] arr=new long[r+1][c+1];
        arr[1][1]=1;
        for(int i=0;i< arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(j+1<arr[0].length) arr[i][j+1]+=arr[i][j];
                if(i+1<arr.length) arr[i+1][j]+=arr[i][j];
            }
        }
        return arr[r][c];
    }
    static long travelDP(int r, int c, HashMap<String, Long> memo){
        if(r==1 || c==1) return 1;
        if(memo.containsKey(r+","+c)) return memo.get(r+","+c);
        long val=travelDP(r-1,c,memo)+travelDP(r,c-1,memo);
        memo.put(r+","+c,val);
        return memo.get(r+","+c);
    }
    public static void main(String[] args) {
        HashMap<String,Long> memo=new HashMap<>();
        System.out.println(travelDP(18,18,memo));
        System.out.println(travel(18,18));
        System.out.println(ttravel(18,18));
    }
}
