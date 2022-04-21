package com.jasonz.oop.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @creator Jason Zhuang
 * @create-time 2021-7-17
 * copywrite zhuangkaizhi.com
 * @Description: Hashmap vs Hashtable
 * <p>
 * HashMap is non-synchronized. It is not thread-safe and can’t be shared between many threads without proper synchronization code,
 * Hashtable is synchronized. It is thread-safe and can be shared with many threads.
 * <p/>
 * <p>
 * HashMap allows one null key and multiple null values
 * Hashtable doesn’t allow any null key or value.
 * <p/>
 * <p>
 * HashMap is generally preferred over HashTable if thread synchronization is not needed.
 * <p/>
 */
public class MainTestMap {

    public static void main(String[] args) {
        MainTestMap instance = new MainTestMap();
        instance.testingHashTable();
        // instance.testingHashMap();
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

    //HashMap is non-synchronized. It is not thread-safe and can’t be shared between many threads without proper synchronization code,
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

    private void testingConcurrentHashMap(){
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    }


    private void testingTreeMap() {

    }

}

