package com.jasonz.oop.collection.list.linkedList;

import java.util.LinkedList;

/**
 * @author : Jason Zhuang
 * @date : 21/4/2022
 * @description :
 * Linked List is a linear data structure where the elements are not stored in contiguous locations,
 * and every element is a separate object with a data part and address part.
 * The elements are linked using pointers and addresses.
 * Each element is known as a node.
 * Due to the dynamicity and ease of insertions and deletions, they are preferred over the arrays.
 * It also has a few disadvantages like the nodes cannot be accessed directly,
 * instead we need to start from the head and follow through the link to reach a node we wish to access.
 */
public class MainTestLinkedList {

    public static void main(String args[])
    {
        // Creating object of the
        // class linked list
        LinkedList<String> ll = new LinkedList<String>();

        // Adding elements to the linked list
        ll.add("A");
        ll.add("B");
        ll.addLast("C");
        ll.addFirst("D");
        ll.add(2, "E");

        System.out.println(ll);
        ll.set(1, "For");
        String var = ll.get(1);
        ll.getFirst();
        ll.getLast();
        System.out.println(ll);

        ll.remove("B");
        ll.remove(3);
        ll.removeFirst();
        ll.removeLast();

        System.out.println(ll);
    }
}
