package com.company.Oops_5;

public interface A {
    static void greeting(){
        System.out.println("I am in static method");
    }
    default void fun(){
        System.out.println("I am in A");
    }
}
