package com.jasonz.dataStructures.queue;

/**
 * @author : Jason Zhuang
 * @date : 21/4/2022
 * @description :
 * Lesson6Distinct PriorityQueue is used when the objects are supposed to be processed based on the priority.
 * It is known that a Queue follows the First-In-First-Out algorithm,
 * but sometimes the elements of the queue are needed to be processed according to the priority,
 * that’s when the PriorityQueue comes into play.
 * The PriorityQueue is based on the priority heap.
 * The elements of the priority queue are ordered according to the natural ordering,
 * or by a Comparator provided at queue construction time, depending on which constructor is used.
 */
public class QueuesMainTest {

    public static void main(String[] args) {

        ArrayQueueExample arrayQueueExample = new ArrayQueueExample();
        arrayQueueExample.testingArrayQueue();

        LinkedListQueueExample linkedListQueueExample = new LinkedListQueueExample();
        linkedListQueueExample.testingLinkedList();

        PriorityQueueExample priorityQueueExample = new PriorityQueueExample();
        priorityQueueExample.testingPriorityQueue();

    }

}
