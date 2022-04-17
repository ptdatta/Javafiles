package com.company;

import java.math.BigInteger;
import java.util.*;

public class Main {
   static   int minimumLength(String str) {
       int s=0;
       int e=str.length()-1;
       while(s<e){
           if(str.charAt(s)!=str.charAt(e)){
               break;
           }
           if(str.charAt(s+1)==str.charAt(e))s++;
           else if(str.charAt(e-1)==str.charAt(s))e--;
           else{
               e--;
               s++;
           }
       }
       if(e-s==0){
           return 0;
       }else{
           return e-s+1;
       }
   }
    public static void main(String[] args) {
      String s="011000111";
      String[] arr=s.split("0");
      int c=0;
      for(int i=0;i< arr.length;i++){
          int n=arr[i].trim().length();
          c+=n*(n+1)/2;
      }
        System.out.println(c);
        System.out.println(Arrays.toString(arr));
        System.out.println(arr[1].trim().length());
    }


}
