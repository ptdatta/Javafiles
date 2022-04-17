package com.company.Oops_7.Collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        List<Integer> list2=new LinkedList<>();
        List<Integer> vector=new Vector<>();

        list2.add(56);
        list2.add(21);
        list2.add(45);
        list2.add(47);
        System.out.println(list2);

        vector.add(74);
        vector.add(7);
        vector.add(14);
        vector.add(21);
        System.out.println(vector);
    }
}
