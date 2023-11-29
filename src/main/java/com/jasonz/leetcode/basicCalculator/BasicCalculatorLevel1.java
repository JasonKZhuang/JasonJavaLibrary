package com.jasonz.leetcode.basicCalculator;

import com.jasonz.oop.inheritance.test.B;

import java.util.Stack;

/**
 * @author Jason Zhuang
 * @created 2023.11.27 17:14
 * @project JasonJavaLibrary
 * @description: https://leetcode.com/problems/basic-calculator/
 *
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 *
 * Example 1:
 * Input: s = "1 + 1"
 * Output: 2
 *
 * Example 2:
 * Input: s = " 2-1 + 2 "
 * Output: 3
 *
 * Example 3:
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 105
 * s consists of digits, '+', '-', '(', ')', and ' '.
 * s represents a valid expression.
 * '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
 * '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
 * There will be no two consecutive operators in the input.
 * Every number and running calculation will fit in a signed 32-bit integer.
 *
 * Solution:
 * Iterative Java solution with stack
 */
public class BasicCalculatorLevel1 {
    public static void main(String[] args) {
        BasicCalculatorLevel1 myInstance = new BasicCalculatorLevel1();
        String s = "(567-(4+5+2)-3)+(6+8)";
        System.out.println(myInstance.iterativeWithStack(s));
    }
    public int iterativeWithStack(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0; // the result of calculation
        int number = 0;
        int sign = 1;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = 10 * number + convertCharToInt(c);
            }else if(c == '+'){
                result += sign * number;
                number = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * number;
                number = 0;
                sign = -1;
            }else if(c == '('){
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;
                result = 0;
            }else if(c == ')'){
                result += sign * number;
                number = 0;
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis
            }
        }
        if(number != 0) result += sign * number;
        return result;
    }

    private int convertCharToInt(char argChar){
            int myInt = argChar;
            System.out.println("char value: " + argChar);
            System.out.println("ASCII value: " + myInt);
            int num = myInt - 48; // ASCII value of '0' is 48
            System.out.println("int value: " + num); // 5
        return num;
    }
    private int convertCharToInt2(char argChar){
        System.out.println("char value: " + argChar);
        int num = Character.getNumericValue(argChar);
        System.out.println("int value: " + num);
        return num;
    }

    private int convertCharToInt3(char argChar){
       return Integer.parseInt(String.valueOf(argChar));
    }
}
