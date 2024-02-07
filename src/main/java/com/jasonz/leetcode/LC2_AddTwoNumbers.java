package com.jasonz.leetcode;

import com.jasonz.dataStructures.list.linkedList.ListNode;
import com.jasonz.utilities.GenerateExampleData;

import java.util.Stack;


/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
public class LC2_AddTwoNumbers {
    public static void main(String[] args) {
        int[] l1 = new int[] {2,4,3}, l2 = new int[] {5,6,4};
        ListNode ln1 = GenerateExampleData.generateNodeList(l1);
        ListNode ln2 = GenerateExampleData.generateNodeList(l2);
        solution1(ln1,ln2);
        solution2(ln1,ln2);

    }

    public static ListNode solution1(ListNode l1, ListNode l2) {

        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        while (l1 != null) {
            st1.push(l1.getVal());
            l1 = l1.getNext();
        }
        while (l2 != null) {
            st2.push(l2.getVal());
            l2 = l2.getNext();
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while (!st1.isEmpty()) {
            sb1.append(st1.pop());
        }
        while (!st2.isEmpty()) {
            sb2.append(st2.pop());
        }

        int v = Integer.valueOf(sb1.toString()) + Integer.valueOf(sb2.toString());

        char[] chars = String.valueOf(v).toCharArray();
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        for (int i = (chars.length - 1); i >= 0; i--) {
            ListNode lnTemp = new ListNode(Integer.parseInt(String.valueOf(chars[i])));
            prev.setNext(lnTemp);
            prev = lnTemp;
        }
        return head.getNext();
    }


    private static int[] solution2(ListNode l1, ListNode l2) {

        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        while (l1 != null) {
            st1.push(l1.getVal());
            l1 = l1.getNext();
        }
        while (l2 != null) {
            st2.push(l2.getVal());
            l2 = l2.getNext();
        }

        int first = 0;
        int second = 0;
        int n = st1.size();
        for (int i = 0; i < n; i++) {
            int times = 1;
            for (int j = 0; j < st1.size() - 1; j++) {
                times = times * 10;
            }

            int v1 = st1.pop();
            int v2 = st2.pop();

            v1 = v1 * times;
            v2 = v2 * times;

            first = first + v1;
            second = second + v2;
        }

        int newValue = first + second;
        StringBuilder newStrSB = new StringBuilder(String.valueOf(newValue)).reverse();
        int[] retValue = new int[newStrSB.length()];
        char[] arrChars = newStrSB.toString().toCharArray();
        for (int i = 0; i < arrChars.length; i++) {
            retValue[i] = Integer.parseInt(String.valueOf(arrChars[i]));
        }
        return retValue;
    }
}
