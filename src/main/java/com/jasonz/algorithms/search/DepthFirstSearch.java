package com.jasonz.algorithms.search;

import com.jasonz.dataStructures.tree.BinaryTree;
import com.jasonz.dataStructures.tree.TreeNode;

/**
 * @author Jason Zhuang
 * @created 2024.01.23 21:33
 * @project JasonJavaLibrary
 * @description:
 */
public class DepthFirstSearch {

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        TreeNode<Integer, Integer> root = tree.getRoot();

        DepthFirstSearch DFS = new DepthFirstSearch();
        System.out.println("=== preOrderTraversal ===");
        DFS.preOrderTraversal(root);
        System.out.println("=== inorderTraversal ===");
        DFS.inorderTraversal(root);
        System.out.println("=== postOrderTraversal ===");
        DFS.postOrderTraversal(root);


    }

    // Given a binary tree, print its nodes in preorder
    void preOrderTraversal(TreeNode<Integer, Integer> node)
    {
        if (node == null)
            return;

        // First print data of node
        System.out.print("[key:" + node.getKey() + ", value:" + node.getValue() + "]" + " -> ");

        // Then recur on left subtree
        preOrderTraversal(node.getLeft());

        // Now recur on right subtree
        preOrderTraversal(node.getRight());
    }


    /**
     * Inorder Traversal
     * @param node
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    void inorderTraversal(TreeNode<Integer, Integer> node) {
        if (node != null) {
            // First recur on left child
            inorderTraversal(node.getLeft());

            // Then print the data of node
            System.out.print("[key:" + node.getKey() + ", value:" + node.getValue() + "]" + " -> ");

            // Now recur on right child
            inorderTraversal(node.getRight());
        }
    }

    // Given a binary tree, print its nodes according to the
    // "bottom-up" postorder traversal.
    void postOrderTraversal(TreeNode<Integer, Integer> node)
    {
        if (node == null)
            return;

        // First recur on left subtree
        postOrderTraversal(node.getLeft());

        // Then recur on right subtree
        postOrderTraversal(node.getRight());

        // Now deal with the node
        System.out.print("[key:" + node.getKey() + ", value:" + node.getValue() + "]" + " -> ");
    }
}
