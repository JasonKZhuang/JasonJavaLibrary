package com.jasonz.dataStructures.map;

import com.jasonz.utilities.GenerateExampleData;

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
        instance.testingHashMap();
        instance.testingConcurrentHashMap();
        instance.testingLinkedHashMap();
        instance.testingTreeMap();
        instance.testingTreeMapObjectKey();
        instance.testingHashTable();
        instance.testingTreeMapNaturalOrdering();
        instance.testingTreeMapComparator();
        //RemoveItemFromMapWhileIteration.removeItemFromMapWhileIteration(argMap);
    }

    // HashMap is non-synchronized.
    // It is not thread-safe and can’t be shared between many threads without proper synchronization code,
    private void testingHashMap() {
        //----------------hashmap--------------------------------
        HashMap<Integer, String> myMap = new HashMap<>();
        GenerateExampleData.generateMap(myMap, true);

        for (Map.Entry<Integer,String> m : myMap.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        for (Integer key : myMap.keySet()) {
            System.out.println(myMap.get(key));
        }

        for (String value : myMap.values()) {
            System.out.println(value);
        }

        Iterator<Map.Entry<Integer,String>> it = myMap.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Integer,String> e = it.next();
            System.out.println(e.getKey() + "-" + e.getValue());
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
        for (Map.Entry<Integer, String> v : treeMap1.entrySet()) {
            System.out.println("Key:" + v.getKey() + ", value:" + v.getValue());
        }

        TreeMap<String, String> treeMap2 = new TreeMap<>();
        treeMap2.put("c", "val");
        treeMap2.put("b", "val");
        treeMap2.put("a", "val");
        treeMap2.put("e", "val");
        treeMap2.put("d", "val");
        System.out.println("-----------Tree map 2 -----------");
        for (Map.Entry<String, String> v : treeMap2.entrySet()) {
            System.out.println("Key:" + v.getKey() + ", value:" + v.getValue());
        }

        //reverseOrder
        TreeMap<Integer, String> treeMap3 = new TreeMap<>(Comparator.reverseOrder());
        treeMap3.put(3, "val");
        treeMap3.put(2, "val");
        treeMap3.put(1, "val");
        treeMap3.put(5, "val");
        treeMap3.put(4, "val");
        System.out.println("-----------Tree map 3 -----------");
        for (Map.Entry<Integer, String> v : treeMap3.entrySet()) {
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

    /**
     * The important is adding a new ComparatorByCategoryId() as construction parameter when creating TreeMap
     */
    private void testingTreeMapObjectKey() {
        TreeMap<Category, String> categoryMap = new TreeMap<>(new ComparatorByCategoryId());
        Category category1 = new Category(301, "A301");
        Category category2 = new Category(101, "B101");
        Category category3 = new Category(201, "C201");

        categoryMap.put(category1, "Any String");
        categoryMap.put(category2, "Any String");
        categoryMap.put(category3, "Any String");

        for (Map.Entry v : categoryMap.entrySet()) {
            System.out.println("Key:" + v.getKey() + ", value:" + v.getValue());
        }

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

    // Hashtable is synchronized. It is thread-safe and can be shared with many threads.
    // but it is recommended to use CurrentHashMap instead of HashTable
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

}

