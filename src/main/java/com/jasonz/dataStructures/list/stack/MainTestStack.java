package com.jasonz.dataStructures.list.stack;

import java.util.Stack;

/**
 * @author Jason Zhuang
 * @created 2024.01.25 11:51
 * @project JasonJavaLibrary
 * @description:
 */
public class MainTestStack {

    public static void main (String[] args)
    {
        // basic operations
        Stack<Integer> intStack = new Stack<Integer>();
        IntegerStack.stack_push(intStack);
        IntegerStack.stack_pop(intStack);
        IntegerStack.stack_push(intStack);
        IntegerStack.stack_peek(intStack);
        IntegerStack.stack_search(intStack, 2);
        IntegerStack.stack_search(intStack, 6);

        // compare stack to dqueue
        ArrayDequeExample.compareStackAndDequeue();



    }
}
