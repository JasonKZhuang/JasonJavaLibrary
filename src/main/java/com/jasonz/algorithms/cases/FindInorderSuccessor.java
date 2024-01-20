package com.jasonz.algorithms.cases;

/**
 * @author Jason Zhuang
 * @created 2024.01.18 18:06
 * @project JasonJavaLibrary
 * @description:
 */
public class FindInorderSuccessor {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        TreeNode(int x) {
            val = x;
        }
    }
    private TreeNode previous;
    private TreeNode inorderSuccessorNode;

    public TreeNode inorderSuccessorSolution1(TreeNode root, TreeNode p) {

        // Case 1: We simply need to find the leftmost node in the subtree rooted at p.right.
        if (p.right != null) {
            // initialize the left most with p.right node
            TreeNode leftmost = p.right;
            // while the tempNode has left, find out the most left
            while (leftmost.left != null) {
                leftmost = leftmost.left;
            }
            // return the left most is the p's successor
            this.inorderSuccessorNode = leftmost;
        } else {
            // Case 2: We need to perform the standard in order to traversal and keep track of the previous node.
            this.inorderCase2(root, p);
        }

        return this.inorderSuccessorNode;
    }

    private void inorderCase2(TreeNode node, TreeNode p) {

        if (node == null) {
            return;
        }

        // Recurse on the left side
        this.inorderCase2(node.left, p);

        // Check if previous is the inorder predecessor of node
        if (this.previous == p && this.inorderSuccessorNode == null) {
            this.inorderSuccessorNode = node;
            return;
        }

        // Keeping previous up-to-date for further recursions
        this.previous = node;

        // Recurse on the right side
        this.inorderCase2(node.right, p);
    }


    public TreeNode inorderSuccessorSolution2(TreeNode root, TreeNode p) {

        TreeNode successor = null;

        while (root != null) {

            if (p.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }

        return successor;
    }
}