package com.jasonz.systemDesign;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jason Zhuang
 * @created 2024.06.11 10:27
 * @project JasonJavaLibrary
 * @description:
 */
public class MemoryStorageAccess {

    // Singleton instance
    // The volatile keyword ensures that any changes made to the instance variable are immediately visible to all threads
    private static volatile MemoryStorageAccess instance;

    // Thread-safe map for storage
    private final Map<Integer,Object> storage;

    // Private constructor to prevent instantiation
    private MemoryStorageAccess(){
        // using ConcurrentHashMap for thread-safe
        // A hash table supporting full concurrency of retrievals and high expected concurrency for updates.
        storage = new ConcurrentHashMap<>();
    }

    // Public method to get the singleton instance
    public static synchronized MemoryStorageAccess getInstance(){
        if (instance == null){
            return new MemoryStorageAccess();
        }
        return instance;
    }

    public Object get(int key){
        return storage.get(key);
    }

    public void put(int key, Object value){
        storage.put(key, value);
    }

    public void remove(int key){
        storage.remove(key);
    }

    // Method to clear all storage
    public void clear() {
        storage.clear();
    }

}
