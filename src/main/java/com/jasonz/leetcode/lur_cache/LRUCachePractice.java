package com.jasonz.leetcode.lur_cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Jason Zhuang
 * @created 2025.07.15 10:02
 * @project JasonJavaLibrary
 * @description:
 */
public class LRUCachePractice <K,V>{
    private final int capacity;
    // add method is // Added to the end
    LinkedList<V> orderList = new LinkedList<>();
    Map<K,V> cacheMap = null;

    public LRUCachePractice(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<K,V>(capacity);
    }

    public void put(K key, V value) {
        if (orderList.size() < capacity){
            cacheMap.put(key,value);
            orderList.add(value);
            return;
        }
        if (cacheMap.containsKey(key)) {
            cacheMap.put(key, value);
            orderList.remove(value);
            // add the end of the list
            orderList.add(value);
        }else{
            cacheMap.put(key, value);
            V first = orderList.getFirst();
            orderList.removeFirst();
            orderList.add(value);
        }
    }

    public V get(K key) {
        if (cacheMap.containsKey(key)) {
            V value = cacheMap.get(key);
            orderList.remove(value);
            orderList.add(value); // Move accessed value to the end
            return value;
        }
        return null; // Key not found
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        System.out.println("Get 1: " + cache.get(1)); // Moves 1 to front
        cache.put(4, "Four"); // Evicts 2 (least recently used)
        System.out.println("Get 2: " + cache.get(2)); // Returns null
        System.out.println("Get 3: " + cache.get(3)); // Moves 3 to front
    }

}
