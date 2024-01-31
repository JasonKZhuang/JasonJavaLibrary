package com.jasonz.algorithms.twoPointers;

import com.jasonz.dataStructures.list.linkedList.ListNode;

import java.util.Arrays;

/**
 * @author Jason Zhuang
 * @created 2024.01.31 12:45
 * @project JasonJavaLibrary
 * @description: https://leetcode.com/problems/merge-two-sorted-lists/description/
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * <p>
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 * <p>
 * Example 3:
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        // list1 = [1,2,4], list2 = [1,3,4]
        ListNode left = new ListNode(1);
        left.setNext(new ListNode(2));
        left.getNext().setNext(new ListNode(4));

        ListNode right = new ListNode(1);
        right.setNext(new ListNode(3));
        right.getNext().setNext(new ListNode(4));

        ListNode result2 = mergeTwoListsRecursive(left,right);
        System.out.println("over");

        // list1 = [1,2,4], list2 = [1,3,4]
        ListNode left1 = new ListNode(1);
        left1.setNext(new ListNode(2));
        left1.getNext().setNext(new ListNode(4));

        ListNode right1 = new ListNode(1);
        right1.setNext(new ListNode(3));
        right1.getNext().setNext(new ListNode(4));

        ListNode result1 = mergeUsingTwoPointers(left1,right1);
        System.out.println("over");

        int[] aLeft = new int[]{1,2,4};
        int[] aRight = new int[]{1,3,4};
        int[] result3 = mergeUsingWhileAndExtraSpace(aLeft,aRight);
        System.out.println(Arrays.toString(result3));

    }

    public static ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.getVal() < l2.getVal()) {
            l1.setNext( mergeTwoListsRecursive(l1.getNext(), l2));
            return l1;
        }
        else {
            l2.setNext(mergeTwoListsRecursive(l1, l2.getNext()));
            return l2;
        }

    }

    /**
     * First, we set up a false "prehead" node that allows us to easily return the
     * head of the merged list later. We also maintain a prev pointer, which
     * points to the current node for which we are considering adjusting its next
     * pointer. Then, we do the following until at least one of l1 and l2 points
     * to null: if the value at l1 is less than or equal to the value at l2,
     * then we connect l1 to the previous node and increment l1. Otherwise, we
     * do the same, but for l2. Then, regardless of which list we connected, we
     * increment prev to keep it one step behind one of our list heads.
     *
     * After the loop terminates, at most one of l1 and l2 is non-null.
     * Therefore (because the input lists were in sorted order), if either list is
     * non-null, it contains only elements greater than all of the
     * previously-merged elements. This means that we can simply connect the
     * non-null list to the merged list and return it.
     * @param left
     * @param right
     * @return
     */
    // these two lists are already sorted asc
    // Time complexity : O(n+m)
    // Space complexity : O(1)
    private static ListNode mergeUsingTwoPointers(ListNode left, ListNode right) {

        ListNode head = new ListNode(-1);
        ListNode prev = head;

        while (left != null && right != null) {
            if (left.getVal() <= right.getVal()) {
                prev.setNext(left);
                left = left.getNext();
            } else {
                prev.setNext(right);
                right = right.getNext();
            }
            prev = prev.getNext();
        }

        if (left != null) {
            prev.setNext(left);
        }

        if (right != null) {
            prev.setNext(right);
        }
        return head;
    }

    /**
     * this is used by typical merge sort algorithm
     * @param left
     * @param right
     * @return
     * Time complexity O(m+n)
     * Space complexity O(m+n)
     */
    private static int[] mergeUsingWhileAndExtraSpace(int[] left, int[] right) {

        // new merged array to return
        int[] result = new int[left.length + right.length];

        int i = 0; //walking on the left array
        int j = 0; //walking on the right array
        int k = 0; //walking on the result array

        while (i < left.length && j < right.length) {
            // compare left to right, pick smaller one to k
            if (left[i] <= right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }

        // if there is remaining left array
        while (i < left.length) {
            result[k] = left[i];
            i++;
            k++;
        }

        // if there is remaining right array
        while (j < right.length) {
            result[k] = right[j];
            j++;
            k++;
        }

        return result;
    }

}
