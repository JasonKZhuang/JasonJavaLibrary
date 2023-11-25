package com.jasonz.leetcode.arrayAndString;

import java.util.Stack;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers ins = new AddTwoNumbers();

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        while (l1 != null) {
            st1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            st2.push(l2.val);
            l2 = l2.next;
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
        for (int i = (chars.length - 1); i >= 0; i--) {
            ListNode lnTemp = new ListNode(Integer.parseInt(String.valueOf(chars[i])));
            prev.next = lnTemp;
            prev = lnTemp;
        }
        return head.next;
    }


}
