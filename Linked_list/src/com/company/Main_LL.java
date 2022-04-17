package com.company;

public class Main_LL {
    public static void main(String[] args) {
    CustomLinkedList list=new CustomLinkedList();
    list.insertfirst(3);
    list.insertfirst(45);
    list.insertfirst(12);
    list.insertfirst(25);
    list.insertlast(99);
    list.insert(40,2);
    list.insertRec(30,3);

    list.display();
//    System.out.println(list.deletefirst());
//    System.out.println(list.deletelast());
//    System.out.println(list.delete(2));
//    list.display();
//        System.out.println(list.find(40));


//        Doubly_LL list = new Doubly_LL();
//        list.insertfirst(3);
//        list.insertfirst(45);
//        list.insertfirst(12);
//        list.insertfirst(25);
//        list.insertlast(99);
//        list.insert(12,58);
//        list.display();

//        Circular_LL list=new Circular_LL();
//        list.insert(3);
//        list.insert(45);
//        list.insert(12);
//        list.insert(25);
//        list.insert(99);
//        list.insert(12);
//        list.delete(25);
//        list.display();
    }
}
