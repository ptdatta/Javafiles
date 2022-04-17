package com.company.oops_2;

public class Singletoan {
    private Singletoan(){

    }
    private static Singletoan instance;
    public static Singletoan getInstance(){
        if(instance==null){
            instance=new Singletoan();
        }
        return instance;
    }
}
