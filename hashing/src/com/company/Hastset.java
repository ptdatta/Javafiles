package com.company;

import java.util.HashSet;
import java.util.Set;

public class Hastset {
    public static void main(String[] args) {
        HashSet<Integer> h=new HashSet<>(1);
//        Set<Integer> h=new HashSet<>(1);    both can be used
        h.add(5);
        h.add(10);
        h.add(15);
        if(h.contains(10)){
            System.out.println("Present");
        }else{
            System.out.println("Not Present");
        }
        System.out.println(h);
        h.remove(10);
        System.out.println(h);
        System.out.println(h.isEmpty());
        System.out.println(h.size());
        h.clear();
        System.out.println(h);

    }
}
