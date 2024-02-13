package com.jasonz.leetcode;

import com.jasonz.dataStructures.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jason Zhuang
 * @created 2024.02.10 13:59
 * @project JasonJavaLibrary
 * leetcode: 199. Binary Tree Right Side View
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * <p>
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * Example 1:
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * <p>
 * Example 2:
 * Input: root = [1,null,3]
 * Output: [1,3]
 * <p>
 * Example 3:
 * Input: root = []
 * Output: []
 */
public class LC199_BinaryTreeRightSideView {

    public static void main(String[] args) {
        TreeNode<Integer, Integer> root4 = new TreeNode<>(1, 1,
                new TreeNode<Integer, Integer>(2, 2, null, new TreeNode<Integer, Integer>(5, 5)),
                new TreeNode<Integer, Integer>(3, 3, null, new TreeNode<Integer, Integer>(4, 4))
        );
        List<Integer> objects4 = binaryTreeRightSideView(root4);
        for (Integer o : objects4) {
            System.out.println(o.toString());
        }
    }

    public static List<Integer> binaryTreeRightSideView(TreeNode<Integer, Integer> root) {

        // the root is a binary tree
        // we want to get all the nodes at right most in each level
        // we can use BFS to get the last node from queue
        // when using queue, we can use linkedlist in java
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ret = new ArrayList<>();

        LinkedList<TreeNode<Integer, Integer>> lkList = new LinkedList<>();
        lkList.addFirst(root);
        while (!lkList.isEmpty()) {
            TreeNode<Integer, Integer> node = null;
            int size = lkList.size();
            for (int i = 0; i < size; i++) {
                node = lkList.removeLast();
                if (node.getLeft() != null) {
                    lkList.addFirst(node.getLeft());
                }

                if (node.getRight() != null) {
                    lkList.addFirst(node.getRight());
                }
            }
            ret.add(node.getKey());
        }
        return ret;
    }
}
