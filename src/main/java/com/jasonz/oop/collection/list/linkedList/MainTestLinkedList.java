package com.jasonz.oop.collection.list.linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Jason Zhuang
 * @date : 21/4/2022
 * @description :
 * Linked List is a linear data structure where the elements are not stored in contiguous locations,
 * and every element is a separate object with a data part and address part.
 * The elements are linked using pointers and addresses.
 * Each element is known as a node.
 * Due to the dynamite and ease of insertions and deletions, they are preferred over the arrays.
 * <p>
 * It also has a few disadvantages like the nodes cannot be accessed directly,
 * instead we need to start from the head and follow through the link to reach a node we wish to access.
 * <p>
 * LinkedList should be used where modifications to a collection are frequent like addition/deletion operations.
 * LinkedList is much faster as compare to ArrayList in such cases.
 * In case of read-only collections or collections which are rarely modified, ArrayList is suitable.
 */
public class MainTestLinkedList {

    public static void main(String args[]) {
        MainTestLinkedList myInstance = new MainTestLinkedList();
        LinkedList myFistLinkedList  = myInstance.example();
        //
        List<String> myList = myInstance.convertToArrayList(myFistLinkedList);
        for (String a : myList){
            System.out.println("==========="+a);
        }
        //
        LinkedList linkedList = myInstance.convertToLinkedList(myList);
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i) + " == ");
        }
    }

    private LinkedList example() {
        // Creating object of the
        // class linked list
        LinkedList<String> ll = new LinkedList<String>();

        // Adding elements to the linked list
        // add(Object): This method is used to add an element at the end of the LinkedList.
        ll.add("A");
        ll.add("B");

        ll.addLast("C");
        ll.addFirst("D");

        // add(int index, Object): This method is used to add an element at a specific index in the LinkedList.
        ll.add(2, "E");

        System.out.println(ll);

        // using the set() method to change the element
        ll.set(1, "Z");

        String var = ll.get(1);

        ll.getFirst();
        ll.getLast();

        System.out.println(ll);

        ll.remove("B");
        ll.remove(3);
        ll.removeFirst();
        ll.removeLast();

        System.out.println(ll);

        // Iterating the LinkedList
        // Using the Get method and the for loop
        for (int i = 0; i < ll.size(); i++) {
            System.out.print(ll.get(i) + " ");
        }

        System.out.println();

        // Using the for each loop
        for (String str : ll) {
            System.out.println(str + " ");
        }
        return ll;
    }

    private List convertToArrayList(LinkedList argList) {
        List<String> arrayList = new ArrayList<String>(argList);
        return arrayList;
    }

    private LinkedList convertToLinkedList(List argList){
        List<String> arrList = Arrays.asList("John", "Jacob", "Kevin", "Katie", "Nathan");
        LinkedList<String> linkList = arrList.stream().collect(Collectors.toCollection(LinkedList::new));
        return linkList;
    }

}
