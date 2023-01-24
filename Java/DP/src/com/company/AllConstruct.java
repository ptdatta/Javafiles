package com.company;

import java.util.ArrayList;

public class AllConstruct {
    static ArrayList<ArrayList<String>> allConstruct(String s,String[] arr){
        if(s.isEmpty()) return new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        for(int i=0;i< arr.length;i++){
            if(s.indexOf(arr[i])==0){
                ArrayList<ArrayList<String>> list= allConstruct(s.substring(arr[i].length()),arr);
//                ArrayList<String> add=list.get(0).add(arr[i]);

            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s="purple";
        String[] arr={"purp","p","ur","le","purpl"};
    }
}
