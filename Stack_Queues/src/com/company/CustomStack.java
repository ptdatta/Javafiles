package com.company;

public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE=10;

    int ptr=-1;

    public CustomStack(){
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        this.data=new int[size];
    }

    public boolean push(int item){
        if (isfull()) {
            System.out.println("Stack is full");
            return false;
        }
        ptr++;
        data[ptr]=item;
        return true;
    }

    public int pop() throws StackException{
        if(isEmpty()){
            throw new StackException("Connot pop from an empty stack");
        }
        int removed=data[ptr];
        ptr--;
        return removed;
//        return data[ptr--]                Inshort
    }

    public boolean isfull() {
        return ptr== data.length-1;
    }

    public int peek() throws  StackException{
        if(isEmpty()){
            throw new StackException("Connot peek from an empty stack");
        }
        return data[ptr];
    }

    public boolean isEmpty() {
        return ptr==-1;
    }


}
