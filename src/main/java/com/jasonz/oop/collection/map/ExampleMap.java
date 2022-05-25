package com.jasonz.oop.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author : Jason Zhuang
 * @date : 17/5/2022
 * @description :
 */
public class ExampleMap {
    public static void main(String[] args) {
        ExampleMap instance = new ExampleMap();
        instance.testingHashMap();
    }

    private void testingHashMap() {
        // Set 集合存和取的顺序不一致。
        Map<String, String> myMap = new HashMap<>();
        try {
            myMap.put("hello", "hello");
            myMap.put("Jason", "Jason");
            myMap.put("hello", "hello");
            Iterator<String> it = myMap.keySet().iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        System.out.println("=================================================================");
    }
}
