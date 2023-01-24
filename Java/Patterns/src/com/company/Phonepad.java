package com.company;

import java.util.ArrayList;

public class Phonepad {
    public static void main(String[] args) {
        System.out.println(padlist("",""));
    }
    static  void pad(String p,String up){
        if(up.isEmpty()){
                System.out.println(p);
                return;
            }
        int digit=up.charAt(0)-'0';   //this will convert string to integer
        for (int i = (digit-1)*3; i < digit*3; i++) {
            char ch=(char)('a'+i);
            pad(p+ch,up.substring(1));
        }
    }

    static ArrayList<String> padlist(String p, String up){
        if(up.isEmpty()){
                ArrayList<String> list=new ArrayList<>();
                list.add(p);
                return list;
            }
        int digit=up.charAt(0)-'0';   //this will convert string to integer
        ArrayList<String> list=new ArrayList<>();
        for (int i = (digit-1)*3; i < digit*3; i++) {
            char ch=(char)('a'+i);
            list.addAll(padlist(p+ch,up.substring(1)));
        }
        return list;
    }

}
