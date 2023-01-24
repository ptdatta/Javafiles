package com.company;

public class Strings {
    public static void main(String[] args) {
        String a="Parthib Datta";
        String b="Parthib Datta";
        System.out.println(a==b);
        String c=new String("HELLO");
        String d=new String("HELLO");
        System.out.println(c==d);
        System.out.println(c.equals(d));
    }
}
