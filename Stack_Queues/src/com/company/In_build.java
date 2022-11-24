package com.company;

import java.util.*;

public class In_build {

    public static void main(String[] args) {

//        In Build Stack-->
        Stack<Integer> stack=new Stack<>();
        stack.push(34);
        stack.push(38);
        stack.push(41);
        stack.push(78);
        stack.push(21);
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.empty());
        System.out.println(stack.pop());
        System.out.println(stack.firstElement());
         System.out.println(stack.pop());
         System.out.println(stack.pop());
         System.out.println(stack.pop());
         System.out.println(stack.pop());
        System.out.println(stack.empty());


//        In Build Queue-->
//        Queue<Integer> queue=new LinkedList<>();
//        queue.add(3);
//        queue.add(4);
//        queue.add(78);
//        queue.add(91);
//        queue.add(14);
//        System.out.println(queue.peek());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue);


//        In Build Deque-->
//        Deque<Integer> deque=new ArrayDeque<>();
//        deque.add(41);
//        deque.addFirst(14);
//        deque.add(147);
//        deque.addLast(4);
////        System.out.println(deque.removeFirst());
////        System.out.println(deque.remove());
////        System.out.println(deque.removeLast());
//        deque.offer(56);
//        System.out.println(deque);
//        System.out.println(deque.peek());


    }
}
