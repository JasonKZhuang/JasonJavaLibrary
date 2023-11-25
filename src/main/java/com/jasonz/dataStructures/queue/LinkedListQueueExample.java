package com.jasonz.dataStructures.queue;

import com.jasonz.dataStructures.dto.Product;

import java.util.LinkedList;

/**
 * @author Jason Zhuang
 * @created 2023.11.17 16:13
 * @project JasonJavaLibrary
 * @description:
 */
public class LinkedListQueueExample {


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
    public void testingLinkedList() {
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
