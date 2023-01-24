package com.company;
import java.util.HashMap;
import java.util.Map;

public class Hashmap {
    public static void main(String[] args) {
       HashMap<String,Integer> map=new HashMap<>();
       map.put("Parthib",1);
       map.put("GFG",2);
       map.put("Anuj",3);
       map.put("Rishav",45);
       map.put("Rohan",25);
       map.replace("Anuj",56);
        System.out.println(map);
        System.out.println(map.get("Parthib"));
        System.out.println(map.get("djjf"));
       map.remove("GFG");
        System.out.println(map.size());
        System.out.println(map);
        for (Map.Entry<String,Integer> set : map.entrySet()) {
            // Printing all elements of a Map
            System.out.println(set.getKey() + " = "
                    + set.getValue());
        }
        System.out.println(map.containsKey("Anuj"));
        System.out.println(map.containsValue(45));
        System.out.println(map.remove("Rohan"));
    }
}
