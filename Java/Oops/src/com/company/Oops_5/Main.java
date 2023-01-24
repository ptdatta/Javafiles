package com.company.Oops_5;

public class Main {
    public static void main(String[] args) {
        Son son=new Son(30);
        son.career();

        Doughter doughter=new Doughter(25);
        doughter.career();

//        Parent mom=new Parent(45);
        Parent daughter=new Doughter(56);
        daughter.career();

        Parent.hello();
    }
}
