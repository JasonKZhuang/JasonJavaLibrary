package com.jasonz.advancedFeatures.concurrency.blockingQueue;

import java.util.concurrent.*;

/**
 * @author : Jason Zhuang
 * @date : 23/4/2022
 * @description :
 * BlockingQueue 接口代表阻塞队列
 *  阻塞队列：线程安全
 *  按 FIFO（先进先出）排序元素。
 *  队列的头部 是在队列中时间最长的元素。
 *  队列的尾部 是在队列中时间最短的元素。
 *  新元素插入到队列的尾部，并且队列检索操作会获得位于队列头部的元素。
 *  链接队列的吞吐量通常要高于基于数组的队列，但是在大多数并发应用程序中，其可预知的性能要低。
 * 注意：
 * consumer:
 *   1、consumer 必须要使用take()方法在获取的时候达成阻塞结果
 *   2、使用poll()方法将产生非阻塞效果, 如果队列中无元素，那么返回null
 * producer:
 *   1、producer must use put(e) method, 必须要使用 pull(e) 方法在加入的时候达成阻塞结果
 *   2、使用offer(e) 方法将产生非阻塞效果, 如果队列中元素已满，那么返回false
 */
public class MainTestSimpleBlockingQueue {

    //阻塞队列，FIFO
    // define an BlockingQueue interface variable.
    private static BlockingQueue<String> blockingQueue ;

    private final int QUEUE_CAPACITY = 3;

    public static void main(String[] args) {
        MainTestSimpleBlockingQueue instance = new MainTestSimpleBlockingQueue();
        instance.testArrayBlockQueue();
    }

    /**
     * ArrayBlockingQueue 是基于数组的阻塞队列实现，
     * 在ArrayBlockingQueue内部，维护了一个定长数组，以便缓存队列中的数据对象，这是一个常用的阻塞队列，
     * 除了一个定长数组外，ArrayBlockingQueue内部还保存着两个整形变量，分别标识着队列的头部和尾部在数组中的位置
     * ArrayBlockingQueue在生产者放入数据和消费者获取数据，都是共用同一个锁对象，
     * 由此也意味着两者无法真正并行运行，这点尤其不同于LinkedBlockingQueue；
     * 按照实现原理来分析，ArrayBlockingQueue完全可以采用分离锁，从而实现生产者和消费者操作的完全并行运行。
     * Doug Lea之所以没这样去做，也许是因为ArrayBlockingQueue的数据写入和获取操作已经足够轻巧，
     * 以至于引入独立的锁机制，除了给代码带来额外的复杂性外，其在性能上完全占不到任何便宜。
     * ArrayBlockingQueue和LinkedBlockingQueue间还有一个明显的不同之处在于，
     * 前者在插入或删除元素时不会产生或销毁任何额外的对象实例，而后者则会生成一个额外的Node对象。
     * 这在长时间内需要高效并发地处理大批量数据的系统中，其对于GC的影响还是存在一定的区别。
     * 而在创建ArrayBlockingQueue时，我们还可以控制对象的内部锁是否采用公平锁，默认采用非公平锁。
     */
    private void testArrayBlockQueue(){

        //create an ArrayBlockingQueue with the given (fixed) capacity.
        blockingQueue = new ArrayBlockingQueue<String>(QUEUE_CAPACITY);

        try {
            //put method 当阻塞队列满时，如果生产者向队列中插入元素，则队列会一直阻塞当前线程，直到队列可用或响应中断退出。
            blockingQueue.put("Product 1");
            blockingQueue.put("Product 2");
            blockingQueue.put("Product 3");

            // if this line is uncomment, the process will be blocked due to the capacity of queue,
            // then the below code lines will not be executed.
            //blockingQueue.put("Product 4");

            //take method 当阻塞队列空时，如果消费者线程向阻塞队列中获取数据，则队列会一直阻塞当前线程，直到队列空闲或响应中断退出。
            String element1 = blockingQueue.take();
            String element2 = blockingQueue.take();
            String element3 = blockingQueue.take();

            // if this line is uncomment, the process will be blocked due to the capacity of queue,
            // then the below code lines will not be executed.
            // String element4 = blockingQueue.take();

            System.out.println(element1);
            System.out.println(element2);
            System.out.println(element3);
            // System.out.println(element4);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * LinkedBlockingQueue 是基于链表的阻塞队列，同ArrayListBlockingQueue类似，其内部也维持着一个数据缓冲队列（该队列由一个链表构成），
     * 当生产者往队列中放入一个数据时，队列会从生产者手中获取数据，并缓存在队列内部，而生产者立即返回；
     * 只有当队列缓冲区达到最大值缓存容量时（LinkedBlockingQueue可以通过构造函数指定该值），才会阻塞生产者队列，
     * 直到消费者从队列中消费掉一份数据，生产者线程会被唤醒，反之对于消费者这端的处理也基于同样的原理。
     * 而LinkedBlockingQueue之所以能够高效的处理并发数据，还因为其对于生产者端和消费者端分别采用了独立的锁来控制数据同步，
     * 这也意味着在高并发的情况下生产者和消费者可以并行地操作队列中的数据，以此来提高整个队列的并发性能。
     * 作为开发者，我们需要注意的是，如果构造一个LinkedBlockingQueue对象，而没有指定其容量大小，
     * LinkedBlockingQueue会默认一个类似无限大小的容量（Integer.MAX_VALUE），
     * 这样的话，如果生产者的速度一旦大于消费者的速度，也许还没有等到队列满阻塞产生，系统内存就有可能已被消耗殆尽了。
     */
    private void testLinkedBlockingQueue(){

    }

}
