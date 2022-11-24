package com.company;

public class MapFromArray {
    public int[] hash;
    public  MapFromArray(){
        hash=new int[100001];
    }
    public  void put(int key,int value){
        hash[key]=value-1;
    }
    public int get(int key){
        return hash[key]+1;
    }
    public void remove(int key){
        hash[key]=0;
    }
    public static void main(String[] args) {
       MapFromArray map=new MapFromArray();
       map.put(2,4);
       map.put(5,6);
        System.out.println(map.get(5));
        map.remove(5);
        System.out.println(map.get(5));
    }
}
