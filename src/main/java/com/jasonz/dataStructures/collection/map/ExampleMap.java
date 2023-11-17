package com.jasonz.dataStructures.collection.map;

import java.util.*;

/**
 * @author : Jason Zhuang
 * @date : 17/5/2022
 * @description :
 */
public class ExampleMap {
    public static void main(String[] args) {
        ExampleMap instance = new ExampleMap();
        instance.testingHashMap();
        instance.testingLinkedHashMap();
        instance.testingTreeMapNaturalOrdering();
        instance.testingTreeMapComparator();
    }

    private void testingHashMap() {

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
        System.out.println(myMap.containsKey("hello"));
        System.out.println(myMap.containsValue("hello"));
        System.out.println(myMap.get("Jason"));
        System.out.println(myMap.isEmpty());
        System.out.println(myMap.keySet());
        System.out.println(myMap.values());
        System.out.println(myMap.remove("hello"));
        System.out.println(myMap.size());
        System.out.println("=================================================================");
    }

    private void testingLinkedHashMap() {
        // Creating an empty LinkedHashMap
        Map<String, Integer> map = new LinkedHashMap<>();

        // Inserting pair entries in above Map using put() method
        map.put("Jason", 10);
        map.put("Mike", 30);
        map.put("Peter", 20);

        // Iterating over Map
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            // Printing key-value pairs
            System.out.println(e.getKey() + " " + e.getValue());
        }
        System.out.println("=================================================================");
    }

    private void testingTreeMapNaturalOrdering() {
        // Creating an empty TreeMap
        Map<String, Integer> map = new TreeMap<>();

        // Inserting custom elements in the Map using put() method
        map.put("Jason", 10);
        map.put("Mike", 30);
        map.put("Peter", 20);

        // Iterating over Map using for each loop
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            // Printing key-value pairs
            System.out.println(e.getKey() + " " + e.getValue());
        }
        System.out.println("=================================================================");
    }

    private void testingTreeMapComparator() {
        // Creating an empty TreeMap
        // Map<Integer, Integer> map = new TreeMap<>();
        //
        // // Inserting custom elements in the Map using put() method
        // map.put(ProductComparable.builder().id(9).name("Car").build(), 10);
        // map.put(ProductComparable.builder().id(8).name("Truck").build(), 30);
        // map.put(ProductComparable.builder().id(7).name("Train").build(), 40);
        //
        // // Iterating over Map using for each loop
        // for (Map.Entry<Product, Integer> e : map.entrySet()) {
        //     // Printing key-value pairs
        //     System.out.println(e.getKey().getName() + " " + e.getValue());
        // }
        System.out.println("=================================================================");
    }

}
