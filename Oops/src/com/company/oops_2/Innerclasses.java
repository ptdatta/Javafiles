package com.company.oops_2;


public class Innerclasses {
       static class test{
           String name;


           public test(String name){
           this.name=name;
           }

           @Override
           public String toString() {
               return name;
           }
       }

    public static void main(String[] args) {
        test a=new test("kunal");
        test b=new test("parthib");

        System.out.println(a);
        System.out.println(a.name);
        System.out.println(b.name);
    }
}
