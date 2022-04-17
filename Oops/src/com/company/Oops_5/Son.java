package com.company.Oops_5;

public class Son extends Parent{

    public Son(int age){
        super(age);

    }

    @Override
    void career() {
        System.out.println("I am going to be a softwere developer");
    }

    @Override
    void partner() {
        System.out.println("I love Thor");
    }
}
