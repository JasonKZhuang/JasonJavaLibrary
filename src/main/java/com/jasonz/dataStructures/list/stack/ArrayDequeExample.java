package com.jasonz.dataStructures.list.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author Jason Zhuang
 * @created 2024.01.25 12:01
 * @project JasonJavaLibrary
 * @description:
 * The Stack class in Java is a legacy class and inherits from Vector in Java.
 * It is a thread-safe class and hence involves overhead when we do not need thread safety.
 *
 * It is recommended to use ArrayDeque for stack implementation as it is more efficient in a single-threaded environment.
 * One more reason to use Deque over Stack is that
 * Deque has the ability to use streams convert to list with keeping LIFO concept applied while Stack does not.
 *
 */
public class ArrayDequeExample {

    // please, refer to
    // com.jasonz.dataStructures.queue.ArrayQueueExample


    public static void compareStackAndDequeue(){

        Stack<Integer> stack = new Stack<>();
        Deque<Integer> deque = new ArrayDeque<>();

        stack.push(1);//1 is the top
        stack.push(2);//2 is the top

        deque.push(1);//1 is the top
        deque.push(2);//2 is the top

        List<Integer> list1 = stack.stream().toList();//[1,2]
        System.out.println("Using Stack -");
        for (Integer integer : list1) {
            System.out.print(integer + " ");
        }
        System.out.println();

        List<Integer> list2 = deque.stream().toList();//[2,1]
        System.out.println("Using Deque -");
        for (Integer integer : list2) {
            System.out.print(integer + " ");
        }
        System.out.println();

    }

}
