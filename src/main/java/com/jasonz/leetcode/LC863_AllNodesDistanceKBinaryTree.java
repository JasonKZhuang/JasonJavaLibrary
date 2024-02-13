package com.jasonz.leetcode;

import com.jasonz.dataStructures.tree.BinaryTree;
import com.jasonz.dataStructures.tree.TreeNode;
import com.jasonz.utilities.GenerateExampleData;

import java.util.*;

/**
 * @author Jason Zhuang
 * @created 2024.02.10 16:53
 * @project JasonJavaLibrary
 * @description: 863. All Nodes Distance K in Binary Tree
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
 * Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
 * <p>
 * You can return the answer in any order.
 * <p>
 * Example 1:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
 * Output: [7,4,1]
 * Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
 *
 * Example 2:
 * Input: root = [1], target = 1, k = 3
 * Output: []
 */
public class LC863_AllNodesDistanceKBinaryTree {
    public static void main(String[] args) {
        int k = 2;
        int target = 5;
        Integer[] array = new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
//        Integer[] array = new Integer[]{1};
        TreeNode<Integer, Integer> root = GenerateExampleData.generateBinaryTree(array);
        TreeNode<Integer, Integer> targetNode = BinaryTree.findNodeByBFS(root, target);
        List<Integer> result = distanceK(root, targetNode, k);
        System.out.println(result);

    }


    public static List<Integer> distanceK(TreeNode<Integer, Integer> root, TreeNode<Integer, Integer> target, int k) {
        // this is return variable
        List<Integer> retValue = new ArrayList<>();

        // LinkedList as the queue
        LinkedList<TreeNode<Integer, Integer>> queue = new LinkedList<>();
        // initialize queue target node
        queue.add(target);

        // if node has been visited, need to skip
        Map<Integer,TreeNode<Integer, Integer>>  visited  = new HashMap<>();

        // this distance is actually meaning level
        int distance = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                // pop queue 出队
                TreeNode<Integer, Integer> n = queue.removeFirst();
                // every time a node has been polled, then add to visited map
                visited.put(n.getKey(),n);
                // if the node is at the distance level, then add to return value
                if (distance == k){
                    retValue.add(n.getKey());
                }

                // get parent node
                TreeNode<Integer, Integer> p = n.getParent();
                // there is a parent, and the parent hasn't been visited
                if (p!=null && visited.get(p.getKey()) == null){
                    queue.add(p);
                }
                // there is a left, and the left hasn't been visited
                TreeNode<Integer, Integer> l = n.getLeft();
                if (l!=null && visited.get(l.getKey()) == null){
                    queue.add(l);
                }
                //there is a right, and the right hasn't been visited
                TreeNode<Integer, Integer> r = n.getRight();
                if (r!=null && visited.get(r.getKey()) == null){
                    queue.add(r);
                }
            }

            distance = distance + 1;
            // exceed the distance or we say here level, break
            if (distance>k){
                break;
            }

        }

        return retValue;

    }




}
