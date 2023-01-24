package com.company.Oops_5;

public class Main2 {
    public static void main(String[] args) {
        Car car=new Car();
//        car.a;   not accessable
        car.acc();
        car.brake();
        car.stop();
        car.start();

        Media carmedia=new Car();
        carmedia.start();
    }
}
