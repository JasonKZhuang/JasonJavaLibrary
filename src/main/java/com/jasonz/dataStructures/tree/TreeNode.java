package com.jasonz.dataStructures.tree;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jason Zhuang
 * @created 2024.01.26 09:17
 * @project JasonJavaLibrary
 * @description:
 */
@Getter
@Setter
public class TreeNode<Key extends Comparable<Key>, Value> {

    private final Key key;
    private Value value;
    private TreeNode<Key, Value> left;
    private TreeNode<Key, Value> right;
    private TreeNode<Key, Value> parent;

    public TreeNode(Key key) {
        this.key = key;
        this.value = null;
        left = null;
        right = null;
        parent = null;
    }

    public TreeNode(Key key, Value value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public TreeNode(Key key, Value value,TreeNode<Key,Value> left, TreeNode<Key,Value> right ) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
        this.parent = null;
    }

    public TreeNode(Key key, Value value, TreeNode<Key, Value> parent) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = parent;
    }

    public TreeNode(TreeNode<Key, Value> argNode) {
        this.key = argNode.getKey();
        this.value = argNode.getValue();
        this.left = argNode.getLeft();
        this.right = argNode.getRight();
        this.parent = argNode.getParent();
    }

}
