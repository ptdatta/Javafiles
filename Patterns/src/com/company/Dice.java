package com.company;

public class Dice {
    public static void main(String[] args) {
        diceface("",4,3);
    }
    static void dice(String p,int target){
        if(target==0){
            System.out.println(p);
            return;
        }
        for (int i = 1; i <=6 && i<=target; i++) {
            dice(p+i,target-i);
        }
    }

    static void diceface(String p,int target,int face){
        if(target==0){
            System.out.println(p);
            return;
        }
        for (int i = 1; i <=face && i<=target; i++) {
            diceface(p+i,target-i,face);
        }
    }
}
