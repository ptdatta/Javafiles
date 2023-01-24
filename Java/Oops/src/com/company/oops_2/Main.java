package com.company.oops_2;

public class Main {
    public static void main(String[] args) {
//        Human parthib=new Human(19,"Parthib Datta",200000,false);
//        Human kunal=new Human(22,"Kunal Kushwaha",400000,false);
//        Human harry=new Human(22,"Kunal Kushwaha",400000,false);
//
//        System.out.println(Human.population);
//        System.out.println(Human.population);

//        greeting();  //cannot access a non static func in static class
        Main obj=new Main();
        obj.greeting();
    }
    static  void func(){
//        greeting();        Not possible
        Main obj=new Main();     //possible as it is running by an object
        obj.greeting();
    }
    void fun2(){
        greeting();
    }
    void greeting(){
        func();   // static under non static possible
        System.out.println("Hello world");
    }
}
