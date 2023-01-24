package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    static int solve(int[] a,int b){
        if(b==a.length){
            int sum=0;
            for(int i=0;i<a.length;i++){
                sum+=a[i];
            }
            return sum;
        }
        int max=Integer.MIN_VALUE;
        int s=a.length-b;
        for(int i=0;i<=b;i++){
            int j=s;
            int c=0,sum=0;
            while(c<b){
                if(j>=a.length){
                    sum+=a[Math.abs(j-a.length)];
                }else {
                    sum+=a[j];
                }
                j++;
                c++;
            }
            if(sum>max){
                max=sum;
            }
            s++;
        }
        return max;
    }

    static int[] wave(int[] A) {
        Arrays.sort(A);
        int c=A.length;
        if(A.length%2==1){
            c--;
        }
        for(int i=0;i<c;i+=2){
            int temp=A[i];
            A[i]=A[i+1];
            A[i+1]=temp;
        }
        return A;
    }

    public static class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
 }

    ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ans= new ArrayList<Interval>();
        for(int i=0;i<intervals.size();i++){
            if(newInterval.start>intervals.get(i).end){
                ans.add(intervals.get(i));
            } else if (newInterval.end>intervals.get(i).start) {
                ans.add(intervals.get(i));
            } else if (newInterval.start>=intervals.get(i).start && newInterval.end<=intervals.get(i).end) {
                ans.add(intervals.get(i));
            } else if (newInterval.start>=intervals.get(i).start && newInterval.end>intervals.get(i).end) {
                ans.add(new Interval(intervals.get(i).start,newInterval.end));
            } else if (newInterval.start<intervals.get(i).start && newInterval.end<=intervals.get(i).end) {
                ans.add(new Interval(newInterval.start, intervals.get(i).end));
            }
        }
        return ans;
    }

    static int solve(String A) {
        Stack<String> st=new Stack<>();
       int e=0;
       for(int i=0;i<A.length();i++){
           if(A.charAt(i)=='('){
               st.push("(");
           }else{
               if(st.isEmpty()){
                   e++;
               }else {
                   st.pop();
               }
           }
       }
       return e+st.size();
    }

    static int minimize(final int[] A, final int[] B, final int[] C) {
        int i=0,j=0,k=0;
        int min=Integer.MAX_VALUE;
        while(i<A.length && j<B.length && k<C.length){
            int diff=Math.max(Math.max(A[i],B[j]),C[k])-Math.min(Math.min(A[i],B[j]),C[k]);
            if(diff<min){
                min=diff;
            }
            if(A[i]<=B[j] && A[i]<=C[k]){
                i++;
            }else if(B[j]<=A[i] && B[j]<=C[k]){
                j++;
            }else{
                k++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr={5,7,8,15,20,25};

    }

    
}