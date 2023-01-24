package com.company.I_P_E_A;

public class Circle extends Shapes{
    @Override                    //Static methods cannot be overrided but they can be inherited
    void area(){
        System.out.println("Area is pie * r* r");
    }
}
