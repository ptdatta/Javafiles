package com.company;

import java.util.ArrayList;

public class Recurtion_Arr {
    public static void main(String[] args) {
        int[] arr={4,8,5,6,8,10,89,8,12};
//        System.out.println(issorted(arr,0));
//        System.out.println(search(arr,12,0));
//        searchall(arr,8,0);
//        System.out.println(list);

//        ArrayList<Integer> list =new ArrayList<>();
//        ArrayList<Integer> ans=searchall2(arr,8,0,list);
//        System.out.println(ans);
//        System.out.println(list);

      //  System.out.println(searchall3(arr,8,0));

        int[] arr2={5,6,7,8,9,1,2,3};
        System.out.println(rotatedbinary(arr2,4,0, arr2.length-1));
    }
    static  boolean issorted(int[] arr,int index){
        if(index== arr.length-1){
            return true;
        }
        return arr[index]<arr[index+1] && issorted(arr,index+1);
    }
    static int search(int[] arr,int target,int index){
        if(index== arr.length){
            return -1;
        }
        if(arr[index]==target){
            return index;
        }
        return search(arr,target,index+1);
    }
    static ArrayList<Integer> list=new ArrayList<>();
    static void searchall(int[] arr,int target,int index){
        if(index== arr.length){
            return ;
        }
        if(arr[index]==target){
            list.add(index);
        }
        searchall(arr,target,index+1);
    }
    static ArrayList<Integer> searchall2(int[] arr,int target,int index,ArrayList<Integer> list){
        if(index== arr.length){
            return list;
        }
        if(arr[index]==target){
            list.add(index);
        }
        return searchall2(arr,target,index+1,list);
    }
    static ArrayList<Integer> searchall3(int[] arr,int target,int index){
        ArrayList<Integer> list=new ArrayList<>();
        if(index== arr.length){
            return list;
        }
        if(arr[index]==target){
            list.add(index);
        }
        ArrayList<Integer> ansfrombelowcalls=searchall3(arr,target,index+1);
        list.addAll(ansfrombelowcalls);
        return list;
    }
    static int rotatedbinary(int[] arr,int target,int s,int e){
        if(s>e){
            return -1;
        }
        int m=s+ (e-s)/2;
        if(arr[m]==target){
            return m;
        }
        if(arr[s]<=arr[m]){
            if(target>=arr[s] && target<=arr[m]){
               return rotatedbinary(arr,target,s,e-1);
            }else{
                return rotatedbinary(arr,target,m+1,e);
            }
        }
        if(target>=arr[m] && target <=arr[e]){
            return rotatedbinary(arr,target,m+1,e);
        }
        return  rotatedbinary(arr,target,s,m-1);
    }
}
