package com.company;

public class StackMain {
    public static void main(String[] args) throws StackException {
//        CustomStack stack=new CustomStack(5);
//        stack.push(34);
//        stack.push(38);
//        stack.push(41);
//        stack.push(78);
//        stack.push(21);
//        stack.push(45);
//
//        System.out.println(stack.pop());
//         System.out.println(stack.pop());
//         System.out.println(stack.pop());
//         System.out.println(stack.pop());
//         System.out.println(stack.pop());

         DynamicStack stack=new DynamicStack();
//         CustomStack stack=new DynamicStack();
        stack.push(34);
        stack.push(38);
        stack.push(41);
        stack.push(78);
        stack.push(21);
        stack.push(45);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
