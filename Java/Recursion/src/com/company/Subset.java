package com.company;

import java.util.*;

public class Subset {
    static  List<List<Integer>> sub(int[] arr){
        List<List<Integer>> outer =new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num: arr){
            int n=outer.size();
            for(int i=0;i<n;i++){
                List<Integer> internal=new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return  outer;
    }

    static  List<String> subString(String s){
        List<String> outer =new ArrayList<>();
        outer.add(new String(""));
        for(int j=0;j<s.length();j++){
            int n=outer.size();
            for(int i=0;i<n;i++){
                StringBuilder internal=new StringBuilder(outer.get(i).toString());
                internal.append(s.charAt(j));
                outer.add(internal.toString());
            }
        }
        return  outer;
    }

    //if the array contains duplicates
    static  List<List<Integer>> dupsub(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outer =new ArrayList<>();
        int start=0;
        int end=0;
        outer.add(new ArrayList<>());
        for(int i=0;i< arr.length;i++){
            start=0;
            if(i>0 && arr[i]==arr[i-1]){
                start=end+1;
            }
            end= outer.size()-1;
            int n=outer.size();
            for(int j=start;j<n;j++){
                List<Integer> internal=new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return  outer;
    }
    public static void main(String[] args) {
        int[] arr={1,2,2,4};
        System.out.println(dupsub(arr));
        System.out.println(subString("abcd"));
        List<String> str=subString("abbd");
        Collections.sort(str);
        System.out.println(str);
        }
    }

