package com.jasonz.algorithms.breadthFirstSearch;

import com.jasonz.dataStructures.tree.BinarySearchTree;
import com.jasonz.dataStructures.tree.TreeNode;
import com.jasonz.dto.IntegerData;
import com.jasonz.dto.Vertex;
import com.jasonz.utilities.GenerateExampleData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jason Zhuang
 * @created 2024.01.23 21:32
 * @project JasonJavaLibrary
 * @description: References:
 * https://www.youtube.com/watch?v=9Oev6UgLhiI
 * <p>
 * <p>
 * The time complexity of the breadth-first search (BFS) algorithm is O(V + E)
 * ,which means it is directly proportional to the size of the graph.
 * This makes BFS a very efficient algorithm for large-scale graph traversal problems.
 */
public class BreadthFirstSearch<T> {
    private Vertex<T> startVertex;

    private TreeNode<Integer, Integer> root;

    public BreadthFirstSearch(Vertex<T> startVertex) {
        this.startVertex = startVertex;
    }

    public BreadthFirstSearch(IntegerData[] dataObjects) {
        BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<>();
        for (IntegerData e : dataObjects) {
            binarySearchTree.insert(e.getKey(), e.getValue());
        }
        this.root = binarySearchTree.getRoot();
    }

    public static void main(String[] args) {

        // first example for graph
        Vertex<Integer> v = GenerateExampleData.generateVertexGraph();
        BreadthFirstSearch<Integer> bfs = new BreadthFirstSearch<>(v);
        bfs.traverseGraph();

        // second example for binary search tree
        IntegerData[] dataObjects = new IntegerData[10];
        GenerateExampleData.generateIntegerKeyValueArray(dataObjects);
        BreadthFirstSearch<Integer> bfsBinaryTree = new BreadthFirstSearch<>(dataObjects);
        bfsBinaryTree.traverseBinarySearchTree();

        // third LeetCode example for 102. Binary Tree Level Order Traversal
        TreeNode<Integer, Integer> root = new TreeNode<>(3, 3,
                new TreeNode<Integer, Integer>(9, 9),
                new TreeNode<Integer, Integer>(20, 20,
                        new TreeNode<Integer, Integer>(15, 15),
                        new TreeNode<Integer, Integer>(7, 7)
                )
        );
        List<List<Integer>> objects = binaryTreeLevelOrderTraversal(root);
        for (List<Integer> o : objects) {
            System.out.println(o.toString());
        }

        // Fourth LeetCode example for:  199. Binary Tree Right Side View
        TreeNode<Integer, Integer> root4 = new TreeNode<>(1, 1,
                new TreeNode<Integer, Integer>(2, 2, null, new TreeNode<Integer, Integer>(5, 5)),
                new TreeNode<Integer, Integer>(3, 3, null, new TreeNode<Integer, Integer>(4, 4))
        );
        List<Integer> objects4 = binaryTreeRightSideView(root4);
        for (Integer o : objects4) {
            System.out.println(o.toString());
        }


    }


    /**
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
    private static List<Integer> binaryTreeRightSideView(TreeNode<Integer, Integer> root) {
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

    /**
     * 102. Binary Tree Level Order Traversal
     * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
     * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
     * Time complexity O(n)
     * Space complexity O(n)
     */
    private static List<List<Integer>> binaryTreeLevelOrderTraversal(TreeNode<Integer, Integer> root) {

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

                tmpArray.add(tempNode.getKey());

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

    /**
     * Reference: <a href="https://www.geeksforgeeks.org/level-order-tree-traversal/">BFS of Binary Tree</a>
     * Level Order Traversal technique is defined as a method to traverse a Tree
     * such that all nodes present in the same level are traversed completely
     * before traversing the next level. This can be done by using a queue
     * work perfect
     */
    private void traverseBinarySearchTree() {
        // 我们使用LinkedList来作为我们的队列
        LinkedList<TreeNode<Integer, Integer>> myQueue = new LinkedList<>();

        // add root node to queue
        myQueue.add(root);

        while (!myQueue.isEmpty()) {
            // remove the head node
            TreeNode<Integer, Integer> node = myQueue.remove();
            System.out.println("[key=" + node.getKey() + ", value=" + node.getValue() + "]");

            // if there is left node, add the left to the queue
            if (node.getLeft() != null)
                myQueue.add(node.getLeft());

            // if there is right node, add the right to the queue
            if (node.getRight() != null)
                myQueue.add(node.getRight());
        }

    }

    /**
     * this implementation will not work on cyclic graphs
     * since there is not breaking for a cycle graph
     * so, we add if (!current.visited) condition
     * <a href="https://www.youtube.com/watch?v=9Oev6UgLhiI">Reference</a>
     */
    private void traverseGraph() {
        // first we need a queue
        Queue<Vertex<T>> queue = new LinkedList<>();

        // add the first vertex into queue
        queue.offer(startVertex);

        // while queue is not empty
        while (!queue.isEmpty()) {

            // poll the head element
            Vertex<T> current = queue.poll();

            if (!current.isVisited()) {
                current.setVisited(true);
                System.out.println(current);
                queue.addAll(current.getNeighbors());
            }
        }

    }
}
