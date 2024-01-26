package com.jasonz.dataStructures.tree;

import lombok.Data;
import lombok.Getter;

/**
 * @author Jason Zhuang
 * @created 2024.01.26 10:48
 * @project JasonJavaLibrary
 * @description: Binary Tree: A binary tree is a hierarchical data structure in which each node has at most two children,
 * referred to as the left child and the right child.
 */
@Data
@Getter
public class BinaryTree {

    // Root of Binary Tree
    private TreeNode<Integer, Integer> root;

    public BinaryTree() {

        TreeNode<Integer, Integer> node ;
        //
        this.root =  new TreeNode<>(1);
        //
        node = this.root;
        node.setLeft(new TreeNode<>(2));
        node.setRight(new TreeNode<>(3));

        node = this.root.getLeft();
        node.setLeft(new TreeNode<>(4));
        node.setRight(new TreeNode<>(5));

        node = this.root.getRight();
        node.setLeft(new TreeNode<>(6));
        node.setRight(new TreeNode<>(7));


    }

}
