package com.jasonz.algorithms.search;

import com.jasonz.dataStructures.tree.BinarySearchTree;
import com.jasonz.dataStructures.tree.TreeNode;
import com.jasonz.dto.IntegerData;
import com.jasonz.dto.Vertex;
import com.jasonz.utilities.GenerateExampleData;

import java.util.LinkedList;
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
 * , which means it is directly proportional to the size of the graph.
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
        myQueue.add(root);
        System.out.println("=== traverseBinaryTree ===");
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
