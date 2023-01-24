package com.company.Oops_5;

public class Doughter extends Parent{

    public Doughter(int age){
        super(age);

    }

    @Override
    void career() {
        System.out.println("I want to be doctor");
    }

    @Override
    void partner() {
        System.out.println("I love Iron man");
    }
}
