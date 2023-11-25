package com.jasonz.dataStructures.queue;

import com.jasonz.dataStructures.dto.Product;

import java.util.ArrayDeque;

/**
 * @author Jason Zhuang
 * @created 2023.11.17 16:13
 * @project JasonJavaLibrary
 * @description:
 */
public class ArrayQueueExample {


    /**
     * ArrayDeque底层实现类似于ArrayList，都是通过动态、可分配的Object[]数组来实现元素存储，
     * 当集合元素超过数组容量，会重新分配一个新的数组来存储集合元素。
     * 继承了所有 Deque 的特性和方法:
     *  offer, offerFirst, offerLast,
     *  poll, pollFirst, pollLast,
     *  peek, peekFirst, peekLast,
     *  element, push, pop,
     */
    public void testingArrayQueue() {
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

}
