package com.company;

public class Meeting_rooms {
    static  int rooms(int[][] interval){
        int[] arr=new int[100];
        for(int i=0;i< interval.length;i++){
            arr[interval[i][0]]++;
            arr[interval[i][1]]--;
        }
        int curr=0,max=0;
        for(int i=0;i< arr.length;i++){
            curr+=arr[i];
            if(curr>max){
                max=curr;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[][] interval={{5,10},{0,30},{15,20}};
        System.out.println(rooms(interval));
    }
}
