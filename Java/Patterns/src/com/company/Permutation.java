package com.company;

import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
   // permutations("","abc");
        System.out.println(permutations_r("","abc"));
        System.out.println(permutations_count("","abc"));
    }
    static  void permutations(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        for(int i =0;i<=p.length();i++){
            String f=p.substring(0,i);
            String s=p.substring(i,p.length());
            permutations(f+ch+s,up.substring(1));
        }
    }

    static ArrayList<String> permutations_r(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch=up.charAt(0);
        ArrayList<String> ans=new ArrayList<>();
        for(int i =0;i<=p.length();i++){
            String f=p.substring(0,i);
            String s=p.substring(i,p.length());
            ans.addAll(permutations_r(f+ch+s,up.substring(1)));
        }
        return  ans;
    }

    static  int permutations_count(String p,String up){
        if(up.isEmpty()){

            return 1;
        }
        char ch=up.charAt(0);
        int count=0;
        for(int i =0;i<=p.length();i++){
            String f=p.substring(0,i);
            String s=p.substring(i,p.length());
            count+=permutations_count(f+ch+s,up.substring(1));
        }
        return count;
    }

}
