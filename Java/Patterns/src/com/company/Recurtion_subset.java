package com.company;

import java.util.ArrayList;
import java.util.List;

public class Recurtion_subset {
    public static void main(String[] args) {
     // subseq("","abc");
       // System.out.println(subseq2("","abcde"));
        subseqascii("","abc");
    }
    static  void subseq(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        subseq(p,up.substring(1));
        subseq(p+ch,up.substring(1));
    }

    static ArrayList<String> subseq2(String p, String up){
        if(up.isEmpty()){
           ArrayList<String> list=new ArrayList<>();
           list.add(p);
           return list;
        }
        char ch=up.charAt(0);
        ArrayList<String> left=subseq2(p,up.substring(1));
        ArrayList<String> right=subseq2(p+ch,up.substring(1));
        left.addAll(right);
        return left;
    }

    static  void subseqascii(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        subseqascii(p,up.substring(1));
        subseqascii(p+ch,up.substring(1));
        subseqascii(p+(ch+0),up.substring(1));
    }


}
