package com.jasonz.leetcode;

import com.jasonz.dataStructures.tree.TreeNode;
import com.jasonz.utilities.GenerateExampleData;

import java.util.LinkedList;

/**
 * @author Jason Zhuang
 * @created 2024.02.10 15:05
 * @project JasonJavaLibrary
 * @description: 111. Minimum Depth of Binary Tree
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 */
public class LC111_MinimumDepthBinaryTree {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{3,9,20,null,null,15,7};
        TreeNode<Integer, Integer> root = GenerateExampleData.generateBinaryTree(array);

    }

    public static int solutionBFS (TreeNode<Integer, Integer> root){
        if (root== null){
            return 0;
        }
        //queue
        LinkedList<TreeNode> queue = new LinkedList<>();
//        queue.add();
        return 0;
    }

}
