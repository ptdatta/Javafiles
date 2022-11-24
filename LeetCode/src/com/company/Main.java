package com.company;

import java.math.BigInteger;
import java.util.*;
import java.math.*;

public class Main {

   static int match(String a,String b){
       if(a.equals(b)){
           return 0;
       }
       int sum=0;
       for (int i = 0; i < a.length(); i++) {
           sum+=dis(b,a.charAt(i));
       }
       return sum;
   }
   static int dis(String a,char c){
       int min=28;
       for (int i = 0; i < a.length(); i++) {
           min=Math.min(min,Math.abs(c-a.charAt(i)));
       }
       return min;
   }

   static int[] cyclic(int [] arr){
       int i=0;
       while (i< arr.length){
           if(arr[i]!=arr[arr[i]-1]){
               int curr=arr[i]-1;
               int temp=arr[i];
               arr[i]=arr[curr];
               arr[curr]=temp;
           }else {
               i++;
           }
       }
       return arr;
   }

    static int repeatedStringMatch(String a, String b) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }
        if(sb.toString().contains(b) )return count;
        if(sb.append(a).toString().contains(b)) return ++count;
        return -1;
    }

    public static void main(String[] args) {
//       Scanner input=new Scanner(System.in);
//       int n=input.nextInt();
//        for (int i = 0; i < n; i++) {
//            String a=input.next();
//            String b=input.next();
//            System.out.println(match(a,b));
//        }
//        int[] arr={9,5,7,6,7,4,5,2,1};
//        System.out.println(Arrays.toString(cyclic(arr)));

        System.out.println(repeatedStringMatch("abcd","cdabcdab"));
    }
}
