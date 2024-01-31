package com.jasonz.dataStructures.list.linkedList;

import lombok.Data;

/**
 * @author Jason Zhuang
 * @created 2024.01.31 12:53
 * @project JasonJavaLibrary
 * @description:
 */
@Data
public class ListNode {
    private int val;
    private ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
