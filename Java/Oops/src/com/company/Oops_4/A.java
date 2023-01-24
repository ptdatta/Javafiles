package com.company.Oops_4;

public class A {
    int num;
    String name;
    int[] arr;

    public A(int num, String name) {
        this.num = num;
        this.name = name;
        this.arr = new int[34];
    }
    public int getNum(){
        return num;
    }
    public void setNum(int num){
        this.num=num;
    }
}
