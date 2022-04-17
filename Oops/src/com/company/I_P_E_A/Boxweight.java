package com.company.I_P_E_A;

public class Boxweight extends Box{
    double weight;

    public  Boxweight(){
        this.weight=-1;
    }

    Boxweight(Boxweight other){
        super(other);
        weight=other.weight;
    }

    public Boxweight(double side, double weight) {
        super(side);
        this.weight = weight;
    }

    public Boxweight(double l, double h, double w, double weight) {
        super(l, h, w);
        System.out.println(super.w);
        this.weight = weight;
    }
}
