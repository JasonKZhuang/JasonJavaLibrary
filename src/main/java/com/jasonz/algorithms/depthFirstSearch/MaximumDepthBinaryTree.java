package com.jasonz.algorithms.depthFirstSearch;

import com.jasonz.dataStructures.tree.TreeNode;

import java.util.ArrayDeque;

/**
 * @author Jason Zhuang
 * @created 2024.02.02 09:06
 * @project JasonJavaLibrary
 * @description: 104. Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 * <p>
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * <p>
 * Example 2:
 * Input: root = [1,null,2]
 * Output: 2
 */
public class MaximumDepthBinaryTree {

    public static void main(String[] args) {
        TreeNode<Integer,Integer> root = new TreeNode<Integer,Integer>(3, 3,
                new TreeNode<Integer,Integer>(9, 9, null, null),
                new TreeNode<Integer,Integer>(20, 20,
                        new TreeNode<Integer,Integer>(15, 15, null, null),
                        new TreeNode<Integer,Integer>(7, 7, null, null))
        );

        System.out.println(solutionByRecursive(root));
        System.out.println(solutionByStack(root));
    }

    private static int solutionByRecursive(TreeNode<Integer,Integer> node) {

        if (node == null) {
            return 0;
        }

        int max = 0;
        max = Math.max(max, 1 + Math.max(
                solutionByRecursive(node.getLeft()),
                solutionByRecursive(node.getRight())
        ));
        return max;
    }

    private static int solutionByStack(TreeNode<Integer,Integer> root) {

        if (root == null) {
            return 0;
        }

        ArrayDeque<TreeNode<Integer,Integer>> stack = new ArrayDeque<>();
        stack.push(root);
        int level = 0;

        while (!stack.isEmpty()) {
            int n = stack.size();
            for (int i = 0; i < n; i++) {
                TreeNode<Integer,Integer> tmp = stack.pop();
                // System.out.println(tmp.getKey());
                if (tmp.getLeft() != null) {
                    stack.push(tmp.getLeft());
                }
                if (tmp.getRight() != null) {
                    stack.push(tmp.getRight());
                }
            }
            level = level + 1;
        }
        return level;
    }
}
