package com.jasonz.dataStructures.tree;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jason Zhuang
 * @created 2024.01.25 13:59
 * @project JasonJavaLibrary
 * @description:
 * Binary Search Tree (BST): Lesson6Distinct binary search tree is a specific type of binary tree in which
 * the left child of a node contains only values less than the node,
 * and the right child contains only values greater than the node.
 * This property ensures an efficient search and retrieval mechanism.
 */
@Getter
@Setter
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    // root node
    private TreeNode<Key, Value> root;

    // the count of nodes in the tree
    private int count;

    // 构造函数, 默认构造一棵空二分搜索树
    public BinarySearchTree() {
        root = null;
        count = 0;
    }

    // 返回以node为根的二分搜索树的最小键值所在的节点
    public TreeNode<Key, Value> minimum(TreeNode<Key, Value> node) {
        if (node.getLeft() == null)
            return node;
        return minimum(node.getLeft());
    }

    // 返回以node为根的二分搜索树的最大键值所在的节点
    private TreeNode<Key, Value> maximum(TreeNode<Key, Value> node) {
        if (node.getRight() == null)
            return node;
        return maximum(node.getRight());
    }

    public void insert(Key key, Value value) {
        TreeNode<Key, Value> node = new TreeNode<>(key, value);
        // 1. If the tree is empty, create the root
        if (this.root == null) {
            this.root = node;
            return;
        }

        // 2) Otherwise, create a node with the key
        //    and traverse down the tree to find where
        //    to insert the new node
        TreeNode<Key, Value> currentNode = this.root;
        TreeNode<Key, Value> newNode = new TreeNode<Key, Value>(key, value);

        while (true) {
            if (key.compareTo(currentNode.getKey()) < 0) {
                if (currentNode.getLeft() == null) {
                    currentNode.setLeft(newNode);
                    newNode.setParent(currentNode);
                    break;
                } else {
                    currentNode = currentNode.getLeft();
                }
            } else {
                if (currentNode.getRight() == null) {
                    currentNode.setRight(newNode);
                    newNode.setParent(currentNode);
                    break;
                } else {
                    currentNode = currentNode.getRight();
                }
            }
        }
    }

    // insert a node under the arg node
    private TreeNode<Key, Value> insertNode(TreeNode<Key, Value> argNode, TreeNode<Key, Value> newNode) {

        // Return a new node if the tree is empty
        if (argNode == null) {
            count++;
            return new TreeNode<>(newNode.getKey(), newNode.getValue(), newNode.getParent());
        }

        // the given key is the same as node key, then update the value
        if (newNode.getKey().compareTo(argNode.getKey()) == 0) {
            argNode.setValue(newNode.getValue());
        }
        // if the key is smaller than note key, then should be inserted into left
        else if (newNode.getKey().compareTo(argNode.getKey()) < 0) {
            argNode.setLeft(insertNode(argNode.getLeft(), newNode));
        } else {// key > node->key
            argNode.setRight(insertNode(argNode.getRight(), newNode));
        }

        newNode.setParent(argNode);

        return argNode;
    }


    // 删除掉以node为根的二分搜索树中的最小节点, 返回删除节点后新的二分搜索树的根
    private TreeNode<Key, Value> removeMin(TreeNode<Key, Value> node) {
        // if there is no a left leaf of current node
        if (node.getLeft() == null) {
            TreeNode<Key, Value> rightNode = node.getRight();
            node.setRight(null);
            count--;
            return rightNode;
        }
        node.setLeft(removeMin(node.getLeft()));
        return node;
    }

    // 删除掉以node为根的二分搜索树中的最大节点, 返回删除节点后新的二分搜索树的根
    private TreeNode<Key, Value> removeMax(TreeNode<Key, Value> node) {
        if (node.getRight() == null) {
            TreeNode<Key, Value> leftNode = node.getLeft();
            node.setLeft(null);
            count--;
            return leftNode;
        }
        node.setRight(removeMax(node.getRight()));
        return node;
    }

    // 删除掉以node为根的二分搜索树中键值为key的节点, 递归算法
    // 返回删除节点后新的二分搜索树的根
    TreeNode<Key, Value> remove(TreeNode<Key, Value> node, Key key) {

        if (node == null)
            return null;

        if (key.compareTo(node.getKey()) < 0) {
            node.setLeft(remove(node.getLeft(), key));
            return node;
        } else if (key.compareTo(node.getKey()) > 0) {
            node.setRight(remove(node.getRight(), key));
            return node;
        } else {   // key == node->key

            // 待删除节点左子树为空的情况
            if (node.getLeft() == null) {
                TreeNode<Key, Value> rightNode = node.getRight();
                node.setRight(null);
                count--;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if (node.getRight() == null) {
                TreeNode<Key, Value> leftNode = node.getLeft();
                node.setLeft(null);
                count--;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况
            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            //First create a new node that is the same as the minimum right node
            TreeNode<Key, Value> successor = new TreeNode<Key, Value>(minimum(node.getRight()));
            count++;

            // Second, remove the minimum right node, and give the return node to the new node right child
            successor.setRight(removeMin(node.getRight()));
            count--;

            // Third, keep original left to the new node left
            successor.setLeft(node.getLeft());

            // Forth, set deleted node left and right are null
            node.setLeft(null);
            node.setRight(null);

            return successor;
        }
    }


    // 查看以node为根的二分搜索树中是否包含键值为key的节点, 使用递归算法
    boolean contain(TreeNode<Key, Value> node, Key key) {

        if (node == null)
            return false;

        if (key.compareTo(node.getKey()) == 0)
            return true;
        else if (key.compareTo(node.getKey()) < 0)
            return contain(node.getLeft(), key);
        else
            return contain(node.getRight(), key);
    }

    // 在以node为根的二分搜索树中查找key所对应的value, 递归算法
    // 若value不存在, 则返回NULL
    public Value searchRecursionNaive(TreeNode<Key, Value> node, Key key) {

        if (node == null)
            return null;

        if (key.compareTo(node.getKey()) == 0)
            return node.getValue();
        else if (key.compareTo(node.getKey()) < 0)
            return searchRecursionNaive(node.getLeft(), key);
        else
            return searchRecursionNaive(node.getRight(), key);

    }

    public TreeNode<Key, Value> search(TreeNode<Key, Value> argRoot, Key key) {
        if (argRoot == null) {
            return null;
        }
        if (key.compareTo(argRoot.getKey()) == 0) {
            return argRoot;
        } else if (key.compareTo(argRoot.getKey()) < 0) {
            return search(argRoot.getLeft(), key);
        } else {
            return search(argRoot.getRight(), key);
        }

    }
}
