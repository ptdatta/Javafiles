package com.company.Oops_6;

import java.util.Arrays;
import java.util.List;

public class CustomGenArraylist<T> {   //<T extends Number> for use only numbers
    private Object[] data;              //this is called wildcard
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustomGenArraylist() {
        this.data = new Object[DEFAULT_SIZE];
    }

    public void getlist(List<? extends Number> list){
        //do something
    }

    public void add(T num) {
        if (isfull()) {
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        Object[] temp = new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public T remove() {
        T removed = (T) (data[--size]);
        return removed;
    }

    public T get(int index) {
        return (T) (data[index]);
    }

    public int size() {
        return size;
    }

    public void set(int index, T value) {
        data[index] = value;
    }

    private boolean isfull() {
        return size == data.length;
    }

    @Override
    public String toString() {
        return "CustomArraylist{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
       CustomGenArraylist<Integer> list =new CustomGenArraylist<>();
        for (int i = 0; i < 14; i++) {
            list.add(3*i);
        }
        System.out.println(list);

    }
}
