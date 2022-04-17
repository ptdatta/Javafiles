package com.company.Oops_6.Cloneing;

public class Human implements Cloneable{
    int age;
    String name;
    int[] arr;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
        this.arr=new int[]{4,5,8,9};
    }

    public Human(Human other) {
        this.age = other.age;
        this.name=other.name;
    }

//    @Override       //shallowcopy
//    public Object clone() throws CloneNotSupportedException{
//         return super.clone();
//    }
//
    @Override       //deepcopy
    public Object clone() throws CloneNotSupportedException{
         Human twin=(Human) super.clone();
         twin.arr=new int[twin.arr.length];
        for (int i = 0; i < twin.arr.length; i++) {
            twin.arr[i]=this.arr[i];
        }
        return twin;
    }


}
