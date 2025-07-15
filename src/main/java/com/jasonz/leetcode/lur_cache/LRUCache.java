package com.jasonz.leetcode.lur_cache;

import java.util.*;

public class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, V> cacheMap;
    private final LinkedList<K> orderList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>(capacity);
        this.orderList = new LinkedList<>();
    }

    public V get(K key) {
        if (cacheMap.containsKey(key)) {
            // Move accessed key to front (most recently used)
            orderList.remove(key);
            orderList.addFirst(key);
            return cacheMap.get(key);
        }
        return null;
    }

    public void put(K key, V value) {
        if (cacheMap.containsKey(key)) {
            // Update existing key and move to front
            cacheMap.put(key, value);
            orderList.remove(key);
            orderList.addFirst(key);
        } else {
            // Add new key-value pair
            cacheMap.put(key, value);
            orderList.addFirst(key);
            // Evict least recently used if over capacity
            if (cacheMap.size() > capacity) {
                K lruKey = orderList.removeLast();
                cacheMap.remove(lruKey);
            }
        }
    }

    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache<>(3);
        cache.put("1", "One");
        cache.put("2", "Two");
        cache.put("3", "Three");
        System.out.println("Get 1: " + cache.get("1")); // Moves 1 to front
        cache.put("4", "Four"); // Evicts 2 (least recently used)
        System.out.println("Get 2: " + cache.get("2")); // Returns null
        System.out.println("Get 3: " + cache.get("3")); // Moves 3 to front
    }
}