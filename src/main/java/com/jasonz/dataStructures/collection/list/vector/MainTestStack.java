package com.jasonz.dataStructures.collection.list.vector;

import java.util.Stack;

/**
 * @author : Jason Zhuang
 * @date : 17/5/2022
 * @description :
 */
public class MainTestStack {

    public static void main(String[] args) {
        MainTestStack myInstance = new MainTestStack();
        myInstance.example();
        myInstance.reverse1("abcdefg");
        myInstance.reverse2("abcdefg");
        myInstance.reverse3("abcdefg");
    }

    private void example() {
        // construct with non-primative elements only!
        Stack<String> stack = new Stack<String>();

        // to add a value to the top of the stack:
        stack.push("Hello");
        stack.push("World");

        // to return a value without removing it:
        String peek = stack.peek();

        // to return and remove a value from the top:
        String top = stack.pop();

    }

    private void reverse1(String arg) {
        StringBuilder sb = new StringBuilder();
        for (int i = arg.length() - 1; i >= 0; i--) {
            sb.append(arg.charAt(i));
        }
        System.out.println(sb.toString());

    }

    private void reverse2(String arg) {
        StringBuilder sb = new StringBuilder();
        sb.append(arg);
        System.out.println(sb.reverse());
    }

    private void reverse3(String arg) {
        char[] reverseString = new char[arg.length()];

        // Declare a stack of type Character
        Stack<Character> stack = new Stack<Character>();

        // Traverse the String and push the character one by one into the Stack
        for (int i = 0; i < arg.length(); i++) {
            // push the character into the Stack
            stack.push(arg.charAt(i));
        }

        // Now Pop the Characters from the stack until it becomes empty

        int i = 0;
        while (!stack.isEmpty()) { // popping element until stack become empty
            // get the character from the top of the stack
            reverseString[i++] = stack.pop();
        }
        // return string object
        System.out.println(reverseString);
    }

    private void calculateExpressions(String arg) {
        // https://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/
        // http://faculty.cs.niu.edu/~hutchins/csci241/eval.htm
    }

}
