package com.jasonz.leetcode.lur_cache;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jason Zhuang
 * @created 2025.07.15 10:26
 * @project JasonJavaLibrary
 * @description:
 */
public class LRUCacheThreadSafe<K, V> {
    private final int capacity;
    private final ConcurrentHashMap<K, V> cacheMap;
    // add method is // Added to the end
    private final LinkedList<V> orderList;
    private final ReentrantLock lock;


    public LRUCacheThreadSafe(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new ConcurrentHashMap<K, V>(capacity);
        this.orderList = new LinkedList<>();
        this.lock = new ReentrantLock();
    }


    public V get(K key) {
        V value = cacheMap.get(key);
        if (value != null) {
            lock.lock();
            try {
                orderList.remove(value);
                orderList.add(value); // Move accessed value to the end
            } finally {
                lock.unlock();
            }
        }
        return value;
    }

    public void put(K key, V value) {
        lock.lock();
        try {
            if (orderList.size() < capacity) {
                cacheMap.put(key, value);
                orderList.add(value);
                return;
            }
            if (cacheMap.containsKey(key)) {
                cacheMap.put(key, value);
                orderList.remove(value);
                // add the end of the list
                orderList.add(value);
            } else {
                cacheMap.put(key, value);
                orderList.removeFirst();
                orderList.add(value);
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LRUCacheThreadSafe<Integer, String> cache = new LRUCacheThreadSafe<>(3);

        // Simulate concurrent access with multiple threads
        Runnable task1 = () -> {
            cache.put(1, "One");
            System.out.println("Task 1: Get 1 = " + cache.get(1));
            cache.put(2, "Two");
        };

        Runnable task2 = () -> {
            cache.put(3, "Three");
            System.out.println("Task 2: Get 3 = " + cache.get(3));
            cache.put(4, "Four");
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final cache state: " + cache.cacheMap);
    }

}
