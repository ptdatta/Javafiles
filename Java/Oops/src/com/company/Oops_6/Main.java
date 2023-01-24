package com.company.Oops_6;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Student kunal=new Student(12,86.78f);
        Student parthib=new Student(6,99.5f);
        Student aniket=new Student(7,97.5f);
        Student berochan=new Student(2,89.5f);

        Student[] list={kunal,parthib,aniket,berochan};
        System.out.println(Arrays.toString(list));
//        Arrays.sort(list, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return -(int)(o1.marks- o2.marks);      //decending order
//            }
//        });

        Arrays.sort(list, (o1, o2) -> {       //lamda function
            return -(int)(o1.marks- o2.marks);      //decending order
        });
        System.out.println(Arrays.toString(list));

//        if(kunal.compareTo(parthib)<0 ){
//            System.out.println("Kunal has less merks than parthib");
//        }
    }
}
