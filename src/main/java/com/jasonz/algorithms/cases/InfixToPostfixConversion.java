package com.jasonz.algorithms.cases;

/*
    Java implementation to convert infix expression to postfix
    Note that here we use Stack class for Stack operations
*/

import java.util.Stack;

public class InfixToPostfixConversion {

    // Driver method
    public static void main(String[] args) {
        // String exp = "a+b*(c^d-e)^(f+g*h)-i";
        String exp = "11+10*7/(3+4)";
        System.out.println(infixToPostfix(exp));
    }

    // The main method that converts
    // given infix expression
    // to postfix expression.
    public static String infixToPostfix(String infixExp) {
        // initializing empty String for postfixExp
        StringBuilder postfixExp = new StringBuilder("");

        // initializing empty stack
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infixExp.length(); ++i) {
            char c = infixExp.charAt(i);

            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c)) {
                // postfixExp += c;
                postfixExp.append(c);
            }
            // If the scanned character is an '(',
            // push it to the stack.
            else if (c == '(')
                stack.push(c);
                // If the scanned character is an ')',
                // pop and output from the stack
                // until an '(' is encountered.
            else if (c == ')') {
                while (!stack.isEmpty() &&
                        stack.peek() != '(') {
                    // postfixExp += stack.pop();
                    postfixExp.append(stack.pop());
                }
                stack.pop();
            } else // an operator is encountered
            {
                while (!stack.isEmpty() && Precedence(c) <= Precedence(stack.peek())) {
                    // postfixExp += stack.pop();
                    postfixExp.append(stack.pop());
                }
                stack.push(c);
            }

        }

        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression";
            }
            // postfixExp += stack.pop();
            postfixExp.append(stack.pop());
        }
        return postfixExp.toString();
    }


    // A utility function to return
    // precedence of a given operator
    // Higher returned value means
    // higher precedence
    public static int Precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}
