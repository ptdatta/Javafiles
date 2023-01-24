package com.company.I_P_E_A;

public class Box {
    private double l;   //'l' can get via a method
    double h;
    double w;
    double weight; //To access this weight in child class use super.weight

    Box(){
        this.h=-1;
        this.l=-1;
        this.w=-1;
    }
    //Cube
    Box(double side){
        super();
        this.w=side;
        this.l=side;
        this.h=side;
    }

     Box(double l, double h, double w) {
        this.l = l;
        this.h = h;
        this.w = w;
     }
     Box(Box old){
        this.h=old.h;
        this.l=old.l;
        this.w=old.w;
     }

     public void information(){
         System.out.println("Running the Box");
     }
}
