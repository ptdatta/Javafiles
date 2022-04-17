package com.company;

public class QueueMain {
    public static void main(String[] args) throws Exception {
//        CustomQueue queue=new CustomQueue(5);
        CircularQueue queue=new CircularQueue(5);
        queue.insert(3);
        queue.insert(4);
        queue.insert(78);
        queue.insert(91);
        queue.insert(14);
        queue.display();
        System.out.println(queue.remove());
        queue.insert(133);
        queue.display();
    }
}
