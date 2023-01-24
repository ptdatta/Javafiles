package com.company;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class SB {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        StringBuilder builder =new StringBuilder();
        for (int i = 0; i < 26; i++) {

            char ch=(char)('a'+i);
            builder.append(ch);
        }
        System.out.println(builder.toString());
        System.out.println(builder.reverse());

        String name="Parthib Datta";
        System.out.println(name.indexOf('a'));
        System.out.println("  datta ".strip());
        System.out.println(Arrays.toString(name.split(" ")));
        String str="hello";
        System.out.println(ispalindrone(str));
    }
    static  boolean ispalindrone(String str){
        if(  str ==null ||str.length()==0 ){
            return true;
        }
        str=str.toLowerCase();
        for (int i = 0; i <= str.length()/2; i++) {
            char start=str.charAt(i);
            char end=str.charAt(str.length()-1-i);
            if(start!=end){
                return false;
            }
        }
        return true;
    }
}
