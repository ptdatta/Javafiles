package com.company;

import java.util.*;

class Solution {
    static boolean checkIfPangram(String sentence) {
        if(sentence.length()<26){
            return false;
        }
        char ar[]=sentence.toCharArray();
        int counter[]=new int[26];
        for(int i=0;i<26;i++){
            counter[(int)ar[i]-97]++;
        }
        for(int i=0;i<26;i++){
            if(counter[i]<1){
                return false;
            }
        }
        return true;
    }
//    int[] arr=new int[26];
//    char ar[]=sentence.toCharArray();
//        for(int i=0;i<ar.length;i++){
//        arr[(int)ar[i]-97]++;
//    }
//        for(int i=0;i<26;i++){
//        if(arr[i]==0){
//            return false;
//        }
//
//    }
//        return true;
    static  int removeDuplicates(int[] nums) {
        int c=0;

        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                c++;
                nums[c]=nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return c;
    }
    static int count(int[] arr,int k){
        int min=Integer.MAX_VALUE,sum=0,j=0;
        for(int i=0;i< arr.length;){
            sum+=arr[i];
            i++;
            while(j<i && sum>=k){
                sum-=arr[j];
                j++;
                min=Math.min(min,i-j+1);
            }

        }
        return min;
    }

    static int findMaxValueOfEquation(int[][] points, int k) {
        int ans=Integer.MIN_VALUE;
        int i=0;
        int f=1;
        while(i < points.length) {
            if(f<i+1)
                f=i+1;
            for (int j = f; j <= points.length-1; j++) {
                if(points[j][0]>(points[i][0]+k))
                    break;
                if((points[i][1]+points[j][1]+points[j][0]-points[i][0])>ans){
                    ans=points[i][1]+points[j][1]+points[j][0]-points[i][0];
                    f=j-1;
                }
            }
            i++;
        }
        return ans;
    }



    static String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int first = 0, second = 0, carry = 0, sum = 0;
        int[] result = new int[n1 + n2];

        for(int i = n1 - 1; i>= 0; i--){
            second = 0;
            carry = 0;
            int no1 = num1.charAt(i) - '0';

            for(int j = n2 - 1; j >= 0; j--){
                int no2 = num2.charAt(j) - '0';

                sum = no1 * no2 + result[first + second] + carry;
                carry = sum / 10;
                result[first + second] = sum % 10;
                second++;
            }

            if(carry > 0){
                result[first + second] += carry;
            }
            first++;
        }

        int i=n1+n2-1;
        while(i>0&&result[i]==0)
            i--;

        String str = "";
        while(i >= 0){
            str+=result[i];
            i--;
        }
        return str;

    }

    static void find(int[][] grid,int r,int c){
        if(c<0){
            return;
        }
        if(r>7){
            return;
        }
      if(grid[r][c]==0){
          if(r>0 && grid[r-1][c]==2 || c<7 && grid[r][c+1]==2){
              grid[r][c]=2;
          }
      }
      find(grid,r,c-1);
      find(grid,r+1,c);
      find(grid,r+1,c-1);
      return;
    }
    public static void main(String[] args) {
//        String a="456";
//        String b="123";
//        System.out.println(multiply(a,b));
        int[][] grid={
                {0,0,0,0,0,0,0,0},
                {0,1,1,1,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,1,1},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0}
        };
        grid[0][7]=2;
        find(grid,0,7);
        for(int[] i : grid){
            System.out.println(Arrays.toString(i));
        }
    }
}