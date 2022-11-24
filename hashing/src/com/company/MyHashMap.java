package com.company;

import java.util.LinkedList;

public class MyHashMap {
    LinkedList<Entry>[] map;
    public  static int SIZE=769;
    public MyHashMap(){
        map=new LinkedList[SIZE];
    }
    public void put(int key,int value){
        int bucket=key%SIZE;
        if(map[bucket]==null){
            map[bucket]=new LinkedList<Entry>();
            map[bucket].add(new Entry(key,value));
        }else {
            for(Entry entry : map[bucket]){
                if(entry.key==key){
                    entry.val=value;
                    return;
                }
            }
            map[bucket].add(new Entry(key,value));
        }
    }

    public int get(int key){
        int bucket=key%SIZE;
        LinkedList<Entry> entries=map[bucket];
        if(entries==null) return -1;
        for(Entry entry : entries){
            if(entry.key==key) return entry.val;
        }
        return -1;
    }

    public void remove(int key){
        int bucket=key%SIZE;
        Entry toRemove=null;
        if(map[bucket]==null) return;
        else{
            for(Entry entry: map[bucket]){
                if(entry.key==key){
                    toRemove=entry;
                }
            }
            if(toRemove==null) return;
            map[bucket].remove(toRemove);
        }
    }

    public static void main(String[] args) {
        MyHashMap map=new MyHashMap();
        map.put(2,4);
        map.put(5,6);
        map.put(5,9);
        System.out.println(map.get(5));
        map.remove(5);
        System.out.println(map.get(5));
    }
}
class Entry{
    public int key;
    public  int val;
    public Entry(int key,int val){
        this.key=key;
        this.val=val;
    }
}
