package com.jasonz.dataStructures.queue;

import com.jasonz.dataStructures.collection.ProductComparable;

import java.util.PriorityQueue;

/**
 * @author Jason Zhuang
 * @created 2023.11.17 16:12
 * @project JasonJavaLibrary
 * @description:
 */
public class PriorityQueueExample {

    // priority Queue is an ASC default, but can be changed by the comparable interface
    public void testingPriorityQueue() {

        PriorityQueue<ProductComparable> priorityQueue = initProductsQueue();

        //see the sequence of priority queue
        System.out.println("Present 队列：" + priorityQueue);

        // using peek() to get the head element,but not remove the element
        // Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
        System.out.println("peek() to get the head of queue:" + priorityQueue.peek());
        System.out.println("Present 队列：" + priorityQueue);

        //using element() to get the head element,but not remove the element
        //Retrieves, but does not remove, the head of this queue.
        // This method differs from peek only in that it throws an exception if this queue is empty.
        System.out.println("element() to get the head of queue:" + priorityQueue.element());
        System.out.println("Present 队列：" + priorityQueue);

        //see the first element which is the smallest one
        // poll()
        // Retrieves and removes the head of this queue, or returns null if this queue is empty.
        System.out.println("第一个队列元素出队：" + priorityQueue.poll());
        System.out.println("第二个队列元素出队：" + priorityQueue.poll());
        System.out.println("第三个队列元素出队：" + priorityQueue.poll());
        System.out.println("第四个队列元素出队：" + priorityQueue.poll());

    }

    private static PriorityQueue<ProductComparable> initProductsQueue() {

        PriorityQueue<ProductComparable> priorityQueue = new PriorityQueue<>();

        // construct Custom Objects, product, queue
        // so the product much implement Comparable interface
        int i= 0;
        for ( i = 0; i < 10; i++) {
            ProductComparable product = new ProductComparable();
            product.setId(i);
            product.setName("name:" + i);
            // using offer method to add element
            priorityQueue.offer(product);
        }
        // using add method to add element
        ProductComparable product = new ProductComparable();
        product.setId(i);
        product.setName("name:" + i);
        priorityQueue.add(product);
        return priorityQueue;
    }
}
