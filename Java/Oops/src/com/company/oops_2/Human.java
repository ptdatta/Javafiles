package com.company.oops_2;

public class Human {
    int age;
    String name;
    int salary;
    boolean married;
    static long population;

    static  void message(){
        System.out.println("hello world");
    }

    public Human(int age, String name, int salary, boolean married) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;
        Human.population+=1;
    }
}
