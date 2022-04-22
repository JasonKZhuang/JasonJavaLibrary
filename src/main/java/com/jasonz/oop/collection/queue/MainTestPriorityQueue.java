package com.jasonz.oop.collection.queue;

import com.jasonz.oop.collection.Product;
import com.jasonz.oop.collection.ProductComparable;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author : Jason Zhuang
 * @date : 21/4/2022
 * @description :
 * A PriorityQueue is used when the objects are supposed to be processed based on the priority.
 * It is known that a Queue follows the First-In-First-Out algorithm,
 * but sometimes the elements of the queue are needed to be processed according to the priority,
 * that’s when the PriorityQueue comes into play.
 * The PriorityQueue is based on the priority heap.
 * The elements of the priority queue are ordered according to the natural ordering,
 * or by a Comparator provided at queue construction time, depending on which constructor is used.
 */
public class MainTestPriorityQueue {
    public static void main(String[] args) {
        MainTestPriorityQueue instance = new MainTestPriorityQueue();
        // instance.testingPriorityQueue();
        // instance.testingArrayQueue();
        instance.testingLinkedList();
    }

    // priority Queue is a ASC default, but can be changed by the comparable interface
    private void testingPriorityQueue() {
        PriorityQueue priorityQueue = new PriorityQueue();
        // construct Custom Objects, product, queue
        // so the product much implement Comparable interface
        for (int i = 0; i < 10; i++) {
            ProductComparable product = new ProductComparable();
            product.setId(i);
            product.setName("name:" + i);
            priorityQueue.offer(product);
        }
        // construct int value queue
        // priorityQueue.offer(5);
        // priorityQueue.offer(-1);
        // priorityQueue.offer(3);
        // priorityQueue.offer(7);

        //see the sequence of priority queue
        System.out.println("队列输出：" + priorityQueue);

        //using peek() to get the head element,but not remove the element
        System.out.println("peek() to get the head of queue:" + priorityQueue.peek());

        //see the first element which is the smallest one
        System.out.println("第一个队列元素出队：" + priorityQueue.poll());
        System.out.println("第二个队列元素出队：" + priorityQueue.poll());
        System.out.println("第三个队列元素出队：" + priorityQueue.poll());
        System.out.println("第四个队列元素出队：" + priorityQueue.poll());
        System.out.println("null队列：" + priorityQueue.poll());
    }

    /**
     * ArrayDeque底层实现类似于ArrayList，都是通过动态、可分配的Object[]数组来实现元素存储，
     * 当集合元素超过数组容量，会重新分配一个新的数组来存储集合元素。
     * 继承了所有 Deque 的特性和方法:
     *  offer, offerFirst, offerLast,
     *  poll, pollFirst, pollLast,
     *  peek, peekFirst, peekLast,
     *  element, push, pop,
     */
    private void testingArrayQueue() {
        ArrayDeque<Product> arrayQueue = new ArrayDeque<Product>();
        arrayQueue.offerFirst(Product.builder().id(1).name("First").build());
        arrayQueue.offerFirst(Product.builder().id(2).name("Second").build());

        arrayQueue.offerLast(Product.builder().id(3).name("Three").build());
        arrayQueue.offerLast(Product.builder().id(4).name("Four").build());

        arrayQueue.push(Product.builder().id(5).name("Five").build());
        arrayQueue.push(Product.builder().id(6).name("Six").build());

        System.out.println("队列输出：\n" + arrayQueue);
        System.out.println("获取头部元素，但不删除该元素 peek head: " + arrayQueue.peekFirst().getName());
        System.out.println("获取尾部元素，但不删除该元素 peek tail: " + arrayQueue.peekLast().getName());
        System.out.println("获取头部元素，且删除该元素 poll head1 : " + arrayQueue.pollFirst().getName());
        System.out.println("获取头部元素，且删除该元素 poll head2: " + arrayQueue.pollFirst().getName());
        System.out.println("获取尾部元素，且删除该元素 poll tail1: " + arrayQueue.pollLast().getName());
        System.out.println("获取尾部元素，且删除该元素 poll tail2: " + arrayQueue.pollLast().getName());
        try {
            System.out.println("出栈操作 pop : " + arrayQueue.pop().getName());
            System.out.println("出栈操作 pop : " + arrayQueue.pop().getName());
            System.out.println("出栈操作 pop : " + arrayQueue.pop().getName());
            System.out.println("出栈操作 pop : " + arrayQueue.pop().getName());
        } catch (Exception exp) {
            System.out.println("出栈操作异常");
        }
    }

    /**
     * LinkedList实现List，同时也实现了Deque，可以当做双端队列来使用，可以当做“栈”或“队列”使用
     * 继承了所有 Deque 的特性和方法
     *  offer, offerFirst, offerLast,
     *  poll, pollFirst, pollLast,
     *  peek, peekFirst, peekLast,
     *  element, push, pop,
     * LinkedList与ArrayList、ArrayDeque不同之处在于底层实现，
     * LinkedList底层是通过链表的形式存储元素，随机访问性能比较差，
     * 但是在插入、删除的时候性能比较好（只需要改变指针所指的地址就行）
     */
    private void testingLinkedList() {
        //add()和remove()方法在失败的时候会抛出异常(不推荐)
        LinkedList<Product> products = new LinkedList<Product>();
        //添加元素
        products.offer(Product.builder().id(1).name("First").build());
        products.offer(Product.builder().id(2).name("Second").build());
        products.offer(Product.builder().id(3).name("Third").build());
        for (Product p : products) {
            System.out.println(p);
        }
        System.out.println("=============================================");

        //返回第一个元素，保留该元素在队列中
        System.out.println("返回第一个元素，保留该元素在队列中  element method =" + products.element());
        for (Product p : products) {
            System.out.println(p);
        }
        System.out.println("=============================================");

        //返回第一个元素，保留该元素在队列中
        System.out.println("返回第一个元素，保留该元素在队列中  peek method =" + products.peek());
        for (Product p : products) {
            System.out.println(p);
        }
        System.out.println("=============================================");

        //返回第一个元素，并在队列中删除
        System.out.println("返回第一个元素，并在队列中删除 poll = " + products.poll());
        for (Product p : products) {
            System.out.println(p);
        }
        System.out.println("=============================================");
    }
}
