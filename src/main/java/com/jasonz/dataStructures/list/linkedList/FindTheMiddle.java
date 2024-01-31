package com.jasonz.dataStructures.list.linkedList;

import java.util.ArrayList;

/**
 * @author Jason Zhuang
 * @created 2023.11.25 18:28
 * @project JasonJavaLibrary
 * @description:
 * Auxiliary Given a singly linked list, find the middle of the linked list.
 * For example, if the given linked list is 1->2->3->4->5 then the output should be 3.
 * If there are even nodes, then there would be two middle nodes, we need to print the second middle element.
 * For example, if the given linked list is 1->2->3->4->5->6 then the output should be 4.
 */
class Node {
    public int data;
    public Node next;
}

//Driver code
public class FindTheMiddle {

    public static void main(String[] args) {
        FindTheMiddle instance = new FindTheMiddle();

        Node[] myLinkedList = new Node[1];
        for (int i = 5; i > 0; i--) {
            instance.pushNode(myLinkedList, i);
        }

        ArrayList<Integer> myArrayList = new ArrayList<>();
        Node curr = myLinkedList[0];
        while (curr != null) {
            myArrayList.add(curr.data);
            curr = curr.next;
        }
        System.out.print("Middle Value Of Linked List is : ");
        System.out.println(myArrayList.get(myArrayList.size() / 2));
    }


    // Function to add a new node at the head
    public void pushNode(Node[] headRef, int dataVal) {
        // Allocate node
        Node newNode = new Node();
        // Put in the data
        newNode.data = dataVal;
        // Link the old list of the new node
        newNode.next = headRef[0];
        // move the head to point to the new node
        headRef[0] = newNode;
    }
}
