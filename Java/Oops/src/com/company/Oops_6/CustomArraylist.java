package com.company.Oops_6;

import java.util.Arrays;

public class CustomArraylist {
    private int[] data;
    private static  int DEFAULT_SIZE=10;
    private int size=0;

    public CustomArraylist() {
        this.data =new int[DEFAULT_SIZE];
    }
    public void add(int num){
        if(isfull()){
            resize();
        }
        data[size++]=num;
    }

    private void resize() {
        int[] temp=new int[data.length*2];
        for (int i = 0; i < data.length; i++) {
            temp[i]=data[i];
        }
        data=temp;
    }

    public int remove(){
        int removed=data[--size];
        return removed;
    }

    public int get(int index){
        return data[index];
    }

    public int size(){
        return size;
    }
    public void set(int index,int value){
        data[index]=value;
    }

    private boolean isfull() {
        return size== data.length;
    }

    @Override
    public String  toString() {
        return "CustomArraylist{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        CustomArraylist list=new CustomArraylist();
//        list.add(5);
//        list.add(2);
//        list.add(3);
        for (int i = 0; i < 24; i++) {
            list.add(i);
        }
        System.out.println(list);

    }
}
