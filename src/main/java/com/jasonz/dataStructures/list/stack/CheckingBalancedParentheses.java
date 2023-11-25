package com.jasonz.dataStructures.list.stack;

import java.util.Stack;

/**
 * @author Jason Zhuang
 * @created 2023.11.25 20:10
 * @project JasonJavaLibrary
 * @description:
 */

public class CheckingBalancedParentheses {
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false; // Unmatched closing parenthesis
            }
        }

        return stack.isEmpty(); // True if all parentheses are balanced
    }

    public static void main(String[] args) {
        String expression1 = "{[()]()}";
        String expression2 = "([)]";

        System.out.println("Expression 1 is balanced: " + isBalanced(expression1));
        System.out.println("Expression 2 is balanced: " + isBalanced(expression2));
    }
}
