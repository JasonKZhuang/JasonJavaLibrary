package com.jasonz.dataStructures.list.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * @author Jason Zhuang
 * @created 2024.01.25 12:01
 * @project JasonJavaLibrary
 * @description: The Stack class in Java is a legacy class and inherits from Vector in Java.
 * It is a thread-safe class and hence involves overhead when we do not need thread safety.
 * <p>
 * It is recommended to use ArrayDeque for stack implementation as it is more efficient in a single-threaded environment.
 * One more reason to use Deque over Stack is that
 * Deque has the ability to use streams convert to list with keeping LIFO concept applied while Stack does not.
 */
public class ArrayDequeExample {

    public static void main(String[] args) {
        stackPractice();
        dequeuePractice();
    }
    // please, refer to
    // com.jasonz.dataStructures.queue.ArrayQueueExample
    public static void compareStackAndDequeue() {
        stackPractice();
        dequeuePractice();
    }

    private static void stackPractice(){
        int v =0;
        // ==============================================================================//
        Stack<Integer> stack = new Stack<>();

        // Pushes an item onto the top of this stack.
        // This has exactly the same effect as: addElement(item)
        stack.push(1);//1 is the top,  but index =0
        stack.push(2);//2 is the top,  but index =1
        stack.push(3);//3 is the top,  but index =2

        //Removes the object at the top of this stack and
        // returns that object as the value of this function
        v = stack.pop(); // pop 3
        System.out.println(v);

        //Looks at the object at the top of this stack without removing it from the stack
        v= stack.peek(); // value = 2, since 3 have been popped and removed
        System.out.println(v);

        // Tests if this stack is empty
        stack.empty();

        //Returns the 1-based position where an object is on this stack
        v= stack.search(2); // return 1;
        System.out.println(v);

        List<Integer> list1 = stack.stream().toList();//[1,2]
        System.out.println("Using Stack -");
        for (Integer integer : list1) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    private static void dequeuePractice(){
        // ============================================================================== //
        Deque<Integer> deque = new ArrayDeque<>();
        //Pushes an element onto the stack represented by this deque
        // (in other words, at the head of this deque)
        // if it is possible to do so immediately without violating capacity restrictions,
        // throwing an IllegalStateException if no space is currently available.
        // This method is equivalent to addFirst, add to head.
        // remember left is head and right is tail
        deque.push(1);// head -> 1 -> tail
        deque.push(2);// head -> 2 -> 1 -> tail

        // add method is equivalent to addLast, add to tail
        deque.add(3); // head -> 2 -> 1 -> 3 -> tail
        deque.add(4); // head -> 2 -> 1 -> 3 -> 4 -> tail
        deque.add(5); // head -> 2 -> 1 -> 3 -> 4 -> 5 -> tail

        // peek from head, return 2, keep element
        // head -> 2 -> 1 -> 3 -> 4 -> 5 -> tail
        System.out.println(deque.peek());

        // pop  from head, return 2, remove element
        // head -> 2 -> 1 -> 3 -> 4 -> 5 -> tail
        // head -> 1 -> 3 -> 4 -> 5 -> tail
        System.out.println(deque.pop());

        // remove from head
        // head -> 1 -> 3 -> 4 -> 5 -> tail
        // head -> 3 -> 4 -> 5 -> tail
        System.out.println(deque.removeFirst());

        // remove from tail
        // head -> 3 -> 4 -> 5 -> tail
        // head -> 3 -> 4 -> tail
        System.out.println(deque.removeLast());

        List<Integer> list2 = deque.stream().toList();//[2,1]
        System.out.println("Using Deque -");
        for (Integer integer : list2) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}
