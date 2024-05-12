package com.jasonz.dataStructures.tree;

import lombok.Data;
import lombok.Getter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jason Zhuang
 * @created 2024.01.26 10:48
 * @project JasonJavaLibrary
 * @description: Binary Tree: Lesson6Distinct binary tree is a hierarchical data structure in which each node has at most two children,
 * referred to as the left child and the right child.
 */
@Data
@Getter
public class BinaryTree {

    public static TreeNode<Integer, Integer> constructDefaultBinaryTree() {

        // Root of Binary Tree
        TreeNode<Integer, Integer> root = new TreeNode<>(1);

        TreeNode<Integer, Integer> node = root;
        //
        node.setLeft(new TreeNode<>(2));
        node.setRight(new TreeNode<>(3));

        node = root.getLeft();
        node.setLeft(new TreeNode<>(4));
        node.setRight(new TreeNode<>(5));

        node = root.getRight();
        node.setLeft(new TreeNode<>(6));
        node.setRight(new TreeNode<>(7));

        return root;

    }

    public static TreeNode<Integer, Integer> constructACompleteBinaryTree(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        TreeNode<Integer, Integer> myRoot = new TreeNode<>(array[0]);
        Queue<TreeNode<Integer, Integer>> myQueue = new LinkedList<>();
        myQueue.add(myRoot);
        int i = 1;
        while (i < array.length) {

            TreeNode<Integer, Integer> curr = myQueue.remove();

            // here i =1;
            if (i < array.length) {
                if (array[i] == null) {
                    curr.setLeft(null);
                    myQueue.add(new TreeNode<>(array[i]));
                } else {
                    curr.setLeft(new TreeNode<>(array[i]));
                    curr.getLeft().setParent(curr);
                    myQueue.add(curr.getLeft());
                }
                i = i + 1;
            }
            // here i = 2;
            if (i < array.length) {
                if (array[i] == null) {
                    curr.setRight(null);
                    myQueue.add(new TreeNode<>(array[i]));
                } else {
                    curr.setRight(new TreeNode<>(array[i]));
                    curr.getRight().setParent(curr);
                    myQueue.add(curr.getRight());
                }
                i = i + 1;
                // here i = 3; next level
            }

        }
        return myRoot;

    }

    public static TreeNode<Integer, Integer> findNodeByBFS(TreeNode<Integer, Integer> root, int targetKey){

        // use LinkedList as the queue
        LinkedList<TreeNode<Integer, Integer>> myQueue = new LinkedList<>();

        // add root node to queue
        myQueue.add(root);

        while (!myQueue.isEmpty()) {

            // remove the head/first node
            TreeNode<Integer, Integer> node = myQueue.remove();

            // matched with target, then return
            if (node.getKey() == targetKey){
                return node;
            }

            // if there is left node, add the left to the queue
            if (node.getLeft() != null)
                myQueue.add(node.getLeft());

            // if there is right node, add the right to the queue
            if (node.getRight() != null)
                myQueue.add(node.getRight());
        }

        return null;
    }

}
