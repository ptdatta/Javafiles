package com.company.Oops_6;

public class Student  {
    int rollno;
    float marks;

    public Student(int rollno, float marks) {
        this.rollno = rollno;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return marks+""+rollno+"";
    }

//    @Override
//    public int compareTo(Student o) {
//        int diff=(int)(this.marks-o.marks);
//        return diff;
//    }
}
