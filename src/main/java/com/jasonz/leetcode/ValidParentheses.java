package com.jasonz.leetcode;

import java.util.Map;
import java.util.Stack;

/**
 * @author Jason Zhuang
 * @created 2024.01.19 18:29
 * @project JasonJavaLibrary
 * @description:
 */
public class ValidParentheses {

    public static void main(String[] args) {
        String input = "[({{}})[]]";
        ValidParentheses ins = new ValidParentheses();
        System.out.println(ins.isValid(input));
    }

    public boolean isValid(String s) {
        // need a map to store the left side with corresponding right value
        Map<Character, Character> myMap = Map.of('(', ')',
                '[', ']',
                '{', '}'
        );

        // create a new stack for storing left parentheses
        Stack<Character> myStack = new Stack<>();
        // iterate character of the given string
        for (char c : s.toCharArray()) {
            // if it is left character, then push to stack

            if (myMap.containsKey(c)) {
                myStack.push(c);
            } else { // otherwise
                // if stack is empty, which mean there is no matching with this right parentheses
                if (myStack.isEmpty()) {
                    return false;
                }
                // pop up the top value, which is left parentheses
                Character pp = myStack.pop();
                // if its map value is a not matching with variable c, return false
                // if matched, then go next loop character
                if (myMap.get(pp) != c) {
                    return false;
                }

            }
        }

        return myStack.isEmpty();
    }

}
