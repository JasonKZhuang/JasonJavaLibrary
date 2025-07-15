package com.jasonz.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jason Zhuang
 * @created 2025.07.15 20:05
 * @project JasonJavaLibrary
 * @description:
 */
public class LC146_LRUCache {
    private final int capacity;
    private final Map<Integer, Node> cacheMap;
    private final Node head;
    private final Node tail;

    public LC146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        boolean containsKey = cacheMap.containsKey(key);
        if (!containsKey) {
            return -1;
        }

        Node node = cacheMap.get(key);
        this.remove(node);
        this.addToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        boolean containsKey = cacheMap.containsKey(key);
        if (containsKey) {
            Node node = cacheMap.get(key);
            node.value = value;
            this.remove(node);
            this.addToHead(node);
            return;
        }

        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;

        if (cacheMap.size() == capacity) {
            Node prev = this.tail.prev;
            this.remove(prev);
            cacheMap.remove(prev.key);
        }

        this.addToHead(newNode);
        cacheMap.put(key, newNode);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private static class Node {
        int key;
        int value;
        Node next;
        Node prev;
    }
}
