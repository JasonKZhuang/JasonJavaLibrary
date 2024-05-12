package com.jasonz.dataStructures.list.linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : Jason Zhuang
 * @date : 21/4/2022
 * @description :
 * Linked List is a linear data structure where the elements are not stored in contiguous locations,
 * and every element is a separate object with a data part and address part.
 * <p>
 * The elements are linked using pointers and addresses.
 * Each element is known as a node.
 * Due to the dynamite and ease of insertions and deletions, they are preferred over the arrays.
 * <p>
 * It also has a few disadvantages like the nodes cannot be accessed directly,
 * we need to start from the head and follow through the link to reach a node we wish to access.
 * <p>
 * LinkedList should be used where modifications to a collection are frequent like addition/deletion operations.
 * LinkedList is much faster as compare to ArrayList in such cases.
 * In case of read-only collections or collections which are rarely modified, ArrayList is suitable.
 */
public class MainTestLinkedList {

    public static void main(String[] args) {

        MainTestLinkedList myInstance = new MainTestLinkedList();

        // Creating object of the class linked list
        LinkedList<String> myLinkedList = new LinkedList<>();
        myInstance.initLinkedList(myLinkedList);

        //
        List<String> myList = myInstance.convertToArrayList(myLinkedList);
        for (String a : myList) {
            System.out.println("===========" + a);
        }
        //
        LinkedList<String> linkedList = myInstance.convertToLinkedList(myList);
        for (String s : linkedList) {
            System.out.println(s + " == ");
        }

        myInstance.operations();
    }

    private void initLinkedList(LinkedList<String> argList) {
        // Adding elements to the linked list
        // add(Object): This method is used to add an element at the end of the LinkedList.
        argList.add("Lesson6Distinct");
        argList.add("B");

        argList.addLast("C");
        argList.addFirst("D");

        // add(int index, Object): This method is used to add an element at a specific index in the LinkedList.
        argList.add(2, "E");

        // using the set() method to change the element
        argList.set(1, "Z");
    }

    private List<String> convertToArrayList(LinkedList<String> argList) {
        return new ArrayList<String>(argList);
    }

    private LinkedList<String> convertToLinkedList(List<String> argList) {
        List<String> arrList = Arrays.asList("John", "Jacob", "Kevin", "Katie", "Nathan");
        return new LinkedList<>(arrList);
    }


    private void operations() {

        // No need to specify the size in advance, can grow dynamically.
        LinkedList<String> dynamicList = new LinkedList<>();
        String element = "";

        // Efficient queue operations using addFirst addLast and removeFirst removeLast.
        // Efficient stack operations using push, peek, pop, offer, element etc.,

        // operation on the tail or the last, index=size-1
        // adding
        dynamicList.add("Java");
        dynamicList.add("Python");
        dynamicList.add("C++");
        dynamicList.addLast("Ruby");
        // Insert Ruby at index 1, shifting other elements.
        dynamicList.add(1, "TypeScript");
        // retrieving only
        element = dynamicList.getLast();
        element = dynamicList.peekLast();
        // retrieving and removing
        element = dynamicList.pollLast();
        element = dynamicList.removeLast();

        // operation on the head or the first index = 0
        // adding
        dynamicList.push("Jason");
        dynamicList.addFirst("Peter");
        // retrieving only
        element = dynamicList.getFirst();
        element = dynamicList.peekFirst();
        // retrieving and removing
        element = dynamicList.pollFirst();
        element = dynamicList.removeFirst();
        element = dynamicList.poll();
        element = dynamicList.pop();


        // Remove element at index 2.
        element = dynamicList.remove(2);

    }
}
