package com.company;


//Q: Given N bulbs, either on(1) or off(0).
//   Turning on ith bulb causes all remaining bulbs on the right to flip.
//   Find the min number of switches to turn all the bulbs on
public class buld {

    static  int cost(int[] arr){
        int cost=0;
        for(int i=0;i< arr.length;i++){
            if(cost%2!=0){
                arr[i]=1-arr[i];
            }
            if(arr[i]%2==1){
                continue;
            }else{
                cost++;
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        int arr[]={0,1,0,1,1,0,1,1};
        System.out.println(cost(arr));
    }
}
