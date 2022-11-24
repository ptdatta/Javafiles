package com.company;

import java.util.*;

public class LRUCache {
    int size;
    LinkedHashMap<Integer,Integer> memo;
    Deque<Integer> deque;
    public LRUCache(int capacity) {
        size=capacity;
        memo=new LinkedHashMap<>();
        deque=new ArrayDeque<>();
    }

    public int get(int key) {
//        System.out.println(memo);
        if(!memo.containsKey(key)){
            return -1;
        }
        int val=memo.get(key);
        memo.remove(key);
        memo.put(key,val);
        return memo.get(key);
    }

    public void put(int key, int value) {
        // System.out.println(memo);
        if(memo.containsKey(key)) {
            memo.remove(key);
//            deque.remove(key);
        }
        if(memo.size()==size) memo.remove(memo.keySet().iterator().next());
//        deque.add(key);
        memo.put(key,value);

    }

    public static void main(String[] args) {
        LRUCache lru=new LRUCache(2);
        lru.put(2,1);
        lru.put(1,1);
        lru.put(2,3);
        lru.put(4,1);
        System.out.println(lru.get(1));

        System.out.println(lru.get(2));


    }
}
