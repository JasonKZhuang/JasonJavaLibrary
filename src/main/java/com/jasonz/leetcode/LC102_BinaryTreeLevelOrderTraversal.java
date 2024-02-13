package com.jasonz.leetcode;

import com.jasonz.dataStructures.tree.TreeNode;
import com.jasonz.utilities.GenerateExampleData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jason Zhuang
 * @created 2024.02.10 13:36
 * @project JasonJavaLibrary
 * @description: 102. Binary Tree Level Order Traversal
 * <p>
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 * Time complexity O(n)
 * Space complexity O(n)
 * <p>
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * <p>
 * Example 2:
 * Input: root = [1]
 * Output: [[1]]
 * <p>
 * Example 3:
 * Input: root = []
 * Output: []
 */
public class LC102_BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode<Integer, Integer> root = GenerateExampleData.generateBinaryTree(array);
        System.out.println(binaryTreeLevelOrderTraversal(root));
    }

    public static List<List<Integer>> binaryTreeLevelOrderTraversal(TreeNode<Integer, Integer> root) {

        List<List<Integer>> lst = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }

        LinkedList<TreeNode<Integer, Integer>> lkLst = new LinkedList<>();
        lkLst.addFirst(root);
        //[root]
        while (!lkLst.isEmpty()) {

            int size = lkLst.size();

            List<Integer> tmpArray = new ArrayList<>();

            TreeNode<Integer, Integer> tempNode = null;

            for (int i = 0; i < size; i++) {

                // first into head, first out from tail
                tempNode = lkLst.removeLast();

                if (tempNode.getKey() != null) {
                    tmpArray.add(tempNode.getKey());
                }

                if (tempNode.getLeft() != null) {
                    lkLst.addFirst(tempNode.getLeft());
                }

                if (tempNode.getRight() != null) {
                    lkLst.addFirst(tempNode.getRight());
                }
            }

            lst.add(tmpArray);
        }

        return lst;

    }
}
