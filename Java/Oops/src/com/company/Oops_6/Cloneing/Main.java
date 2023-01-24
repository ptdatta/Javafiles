package com.company.Oops_6.Cloneing;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human parthib=new Human(34,"Parthib Datta");
//        Human twin=new Human(parthib);

        Human twin=(Human) parthib.clone();
        System.out.println(twin.name+twin.age);

        System.out.println(Arrays.toString(twin.arr));
        twin.arr[0]=100;
        System.out.println(Arrays.toString(twin.arr));   //deepcopy
        System.out.println(Arrays.toString(parthib.arr));  //Shallowcopy
    }
}
