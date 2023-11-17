package com.jasonz.dataStructures.collection.queue;

import com.jasonz.dataStructures.collection.ProductComparable;

import java.util.PriorityQueue;

/**
 * @author Jason Zhuang
 * @created 2023.11.17 16:12
 * @project JasonJavaLibrary
 * @description:
 */
public class PriorityQueueExample {

    // priority Queue is a ASC default, but can be changed by the comparable interface
    public void testingPriorityQueue() {
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
}
