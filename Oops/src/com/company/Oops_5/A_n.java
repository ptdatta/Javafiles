package com.company.Oops_5;

public class A_n {
    //nested interface
    public  interface Nestedinterface{
        boolean isODD(int num);
    }
}
class  B_n implements  A_n.Nestedinterface{

    @Override
    public boolean isODD(int num) {
        return (num & 1)==1;
    }
}
