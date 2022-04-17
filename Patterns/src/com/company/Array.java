package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] arr=new int[5];
        ArrayList<Integer> list=new ArrayList<>(10);     //c++ (vector)
        list.add(67);
        list.add(56);
        list.add(5);
        list.add(678);
        list.add(45);
        list.remove(2);
        System.out.println(list.contains(56));
        list.set(0,99);
        System.out.println(list);
        System.out.println(list.get(3));



    }
}
