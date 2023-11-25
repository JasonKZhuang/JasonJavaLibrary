package com.jasonz.dataStructures.list.linkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jason Zhuang
 * @created 2023.11.25 19:22
 * @project JasonJavaLibrary
 * @description:
 */
public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> myLinkedList = new LinkedList<>();
        ArrayList<String> myArrayList= new ArrayList<>();

        // No need to specify the size in advance, can grow dynamically.
        LinkedList<String> dynamicList = new LinkedList<>();
        dynamicList.add("Java");
        dynamicList.add("Python");
        dynamicList.add("C++");

        // Insert Ruby at index 1, shifting other elements.
        dynamicList.add(1, "Ruby");
        // Remove element at index 2.
        dynamicList.remove(2);

        // Efficient queue operations using addLast and removeFirst.
        dynamicList.addLast("Go");
        String currentTask = dynamicList.removeFirst();

        // Efficient stack operations using push, peek, pop, offer, element etc.,
        dynamicList.push("JavaScript");
        String firstElement = dynamicList.peek();
        String topElement = dynamicList.pop();
    }
}
