package com.company;

public class Recurtion_pattern {
    public static void main(String[] args) {
    P_2(4,0);
    }
    static void P_1(int r,int c){
       if(r==0){
           return;
       }
       if(c<r){
           System.out.print("* ");
           P_1(r,c+1);
       }else{
           System.out.println();
           P_1(r-1,0);
       }
    }

    static void P_2(int r,int c){
       if(r==0){
           return;
       }
       if(c<r){
           P_2(r,c+1);
           System.out.print("* ");
       }else{
           P_2(r-1,0);
           System.out.println();
       }
    }
}
