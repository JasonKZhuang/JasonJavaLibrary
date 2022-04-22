package com.jasonz.oop.map;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @creator Jason Zhuang
 * @create-time 2021-7-17
 * copywrite zhuangkaizhi.com
 * @Description: Hashmap vs Hashtable
 * <p>
 * HashMap is non-synchronized. It is not thread-safe,
 * and it can’t be shared between many threads without proper synchronization code,
 * but,
 * Hashtable is synchronized. It is thread-safe and can be shared with many threads.
 * <p/>
 * <p>
 * HashMap allows one null key and multiple null values
 * but,
 * Hashtable does not allow any null key or value.
 * <p/>
 * <p>
 * HashMap is generally preferred over HashTable if thread synchronization is not needed.
 * <p/>
 * <p>
 * TreeMap is a map implementation that keeps its entries sorted based on the natural ordering of its keys
 * or,
 * better still using a comparator if provided by the user at construction time.
 * By default, TreeMap sorts all its entries according to their natural ordering.
 * -- For an integer, this would mean ascending order
 * -- For strings, alphabetical order.
 * </p>
 */
public class MainTestMap {

    public static void main(String[] args) {
        MainTestMap instance = new MainTestMap();
        // instance.testingHashTable();
        // instance.testingHashMap();
        instance.testingTreeMap();
    }

    // Hashtable is synchronized. It is thread-safe and can be shared with many threads.
    private void testingHashTable() {
        //----------hashtable -------------------------
        Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
        ht.put(101, "Vijay");
        ht.put(102, "Ravi");
        ht.put(103, "Rahul");
        ht.put(100, "Marc");
        ht.put(101, "Jason");
        System.out.println("-------------Hash table--------------");
        for (Map.Entry m : ht.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        // No need to mention the Generic type twice
        Hashtable<Integer, String> ht1 = new Hashtable<>(5);
        // Inserting the Elements using put() method
        for (int i = 0; i < 15; i++) {
            ht1.put(i, "value of index " + i);
        }

        ht1.remove(1);

        System.out.println("-------------Hash table--------------");
        for (Map.Entry m : ht1.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }

    // HashMap is non-synchronized.
    // It is not thread-safe and can’t be shared between many threads without proper synchronization code,
    private void testingHashMap() {
        //----------------hashmap--------------------------------
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        hm.put(100, "Amit");
        hm.put(104, "Amit");
        hm.put(101, "Vijay");
        hm.put(102, "Rahul");
        hm.put(100, "Tom");
        System.out.println("-----------Hash map-----------");
        for (Map.Entry m : hm.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

    }

    //https://medium.com/art-of-coding/hash-table-vs-concurrent-hashmap-and-its-internal-working-b28fc2725bdb
    private void testingConcurrentHashMap() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    }

    // TreeMap is a map implementation that keeps its entries sorted,
    // according to the natural ordering of its keys
    // or
    // better still using a comparator if provided by the user at construction time.
    // By default, TreeMap sorts all its entries according to their natural ordering.
    // For an integer, this would mean ascending order
    // For strings, alphabetical order.
    private void testingTreeMap() {
        TreeMap<Integer, String> treeMap1 = new TreeMap<>();
        treeMap1.put(3, "val3");
        treeMap1.put(2, "val2");
        treeMap1.put(1, "val1");
        treeMap1.put(5, "val5");
        treeMap1.put(4, "val4");
        System.out.println("-----------Tree map 1 -----------");
        for (Map.Entry v : treeMap1.entrySet()) {
            System.out.println("Key:" + v.getKey() + ", value:" + v.getValue());
        }

        TreeMap<String, String> treeMap2 = new TreeMap<>();
        treeMap2.put("c", "val");
        treeMap2.put("b", "val");
        treeMap2.put("a", "val");
        treeMap2.put("e", "val");
        treeMap2.put("d", "val");
        System.out.println("-----------Tree map 2 -----------");
        for (Map.Entry v : treeMap2.entrySet()) {
            System.out.println("Key:" + v.getKey() + ", value:" + v.getValue());
        }

        TreeMap<Integer, String> treeMap3 = new TreeMap<>(Comparator.reverseOrder());
        treeMap3.put(3, "val");
        treeMap3.put(2, "val");
        treeMap3.put(1, "val");
        treeMap3.put(5, "val");
        treeMap3.put(4, "val");
        System.out.println("-----------Tree map 3 -----------");
        for (Map.Entry v : treeMap3.entrySet()) {
            System.out.println("Key:" + v.getKey() + ", value:" + v.getValue());
        }

        TreeMap<Integer, String> treeMap4 = new TreeMap<>();
        treeMap4.put(3, "val");
        treeMap4.put(2, "val");
        treeMap4.put(1, "val");
        treeMap4.put(5, "val");
        treeMap4.put(4, "val");

        Integer lowestKey = treeMap4.firstKey();
        Integer highestKey = treeMap4.lastKey();

        Set<Integer> keysLessThan3 = treeMap4.headMap(3).keySet();
        Set<Integer> keysGreaterThanEqTo3 = treeMap4.tailMap(3).keySet();

    }

}

