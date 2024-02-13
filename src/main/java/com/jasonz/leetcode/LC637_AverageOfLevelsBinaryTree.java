package com.jasonz.leetcode;

import com.jasonz.dataStructures.tree.TreeNode;
import com.jasonz.utilities.GenerateExampleData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jason Zhuang
 * @created 2024.02.10 10:52
 * @project JasonJavaLibrary
 * @description: 637. Average of Levels in Binary Tree
 * <p>
 * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
 * Answers within 10-5 of the actual answer will be accepted.
 * <p>
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7] // 2^(n+1) - 1
 * Output: [3.00000,14.50000,11.00000]
 * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
 * Hence return [3, 14.5, 11].
 * <p>
 * Example 2:
 * Input: root = [3,9,20,15,7]
 * Output: [3.00000,14.50000,11.00000]
 */
public class LC637_AverageOfLevelsBinaryTree {
    public static void main(String[] args) {
        //Integer[] array = new Integer[]{3, 9, 20, null, null, 15, 7};
        Integer[] array = new Integer[]{3, 9, 20, 15, 7};
        System.out.println(solutionBFS(array));
    }

    public static List<Double> solutionBFS(Integer[] array) {

        List<Double> retValue = new ArrayList<>();

        TreeNode<Integer, Integer> root = GenerateExampleData.generateBinaryTree(array);

        LinkedList<TreeNode<Integer, Integer>> myQueue = new LinkedList<>();
        myQueue.add(root);

        while (!myQueue.isEmpty()) {

            // the key thing is the size of queue for each level
            double sumOnLevel = 0d;
            int queueSize = myQueue.size();
            for (int i = 0; i < queueSize; i++) {
                //
                TreeNode<Integer, Integer> tempNode = myQueue.removeLast();
                if (tempNode.getKey() == null) {
                    System.out.println(queueSize);
                }
                int v = tempNode.getKey();
                sumOnLevel = sumOnLevel + v;

                //
                if (tempNode.getLeft() != null) {
                    myQueue.addFirst(tempNode.getLeft());
                }
                //
                if (tempNode.getRight() != null) {
                    myQueue.addFirst(tempNode.getRight());
                }
            }
            retValue.add(sumOnLevel / queueSize);

        }

        return retValue;

    }

}
