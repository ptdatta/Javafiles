package com.company.Oops_5;
public abstract class Parent {

    int age;
    final int VALUE;

    public Parent(int age) {
        this.age = age;
        VALUE = 569895;
    }
    static void hello(){
        System.out.println("hey");
    }

    void normal(){
        System.out.println("sdjhdhjhd dhjh ");
    }

    abstract void career();
    abstract void partner();
}
