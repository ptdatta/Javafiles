package com.company;

public class Oops_1 {
    public static void main(String[] args) {
        //stores 5 roll no
        int[] numbers = new int[5];

        //store 5 names
        String[] names = new String[5];

        //data of students:(roll no,name,marks)
        Students[] students = new Students[5];
        //declaration
        Students kunal = new Students(6,"Kunal Kushwaha",99.6f);
        Students parthib = new Students();
//        kunal.rno=45;
//        kunal.name="Kunal Kushwaha";
//        kunal.marks=89.2f;
//        kunal.changename("tech lover");
//        kunal.greeting();
        System.out.println(kunal.rno);
        System.out.println(kunal.name);
        System.out.println(kunal.marks);

        Students random = new Students(kunal);
        System.out.println(random.name);

        Students random2=new Students();
        System.out.println(random2.name);

        Students one =new Students();
        Students two=one;
        one.name="something something";
        System.out.println(two.name);

//        final int bonus=2;     Not work
//        bonus=3;

        final A parhtb=new A("Parthib Datta");
        parthib.name="other name";
//        kunal=new com.company.A ("new object")  not possible

        A obj;
        for (int i = 0; i < 10000000; i++) {  //for greater objects it will destroied
            obj=new A("random name");
        }
    }
}
//creat a class
class Students{
    int rno;
    String name;
    float marks=90;

    void greeting(){
        System.out.println("hello,my name is " + this.name);
        System.out.println("hello,my name is " + name);
    }

    void changename(String name){
        this.name=name;
    }

//    void changename(String newname){
//        name=newname;
//    }

    Students(Students other){
        this.name= other.name;
        this.rno= other.rno;
        this.marks= other.marks;
    }

    Students(){
        this.rno=45;
        this.name="Kunal Kushwaha";
        this.marks=89.2f;
    }

//    com.company.Students(){
//        this(13,"default person",100.0f);
//    }

    Students(int rno,String name,float marks){
        this.rno=rno;
        this.name=name;
        this.marks=marks;
    }


//    com.company.Students(int rno,String name,float marks){
//        rno=rno;
//        name=name;                       will not work
//        marks=marks;
//    }
//
//    com.company.Students(int roll,String naam,float mark){
//        rno=roll;
//        name=naam;                      // will work
//        marks=mark;
//    }
}
class A{
    final int num=10;
    String name;

    public A(String name){

        this.name=name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object is destroied");
    }
}
