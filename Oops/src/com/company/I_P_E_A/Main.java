package com.company.I_P_E_A;

public class Main {
    public static void main(String[] args) {
//        Box box1=new Box();
//        Box box2=new Box(box1);
//
//        Boxweight box3=new Boxweight();
//        Boxweight box4=new Boxweight(2,3,5,6);
//        System.out.println(box3.h+" "+box4.weight);

        Box box5=new Boxweight(2,3,5,6);
        System.out.println(box5.w);

//        Boxweight box6=new Box(2,3,5,6);  Will not work

        BoxPrice box=new BoxPrice(5,8,300);
    }
}
