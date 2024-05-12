package com.jasonz.leetcode;

import com.jasonz.dataStructures.tree.TreeNode;
import com.jasonz.utilities.GenerateExampleData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jason Zhuang
 * @created 2024.02.14 13:49
 * @project JasonJavaLibrary
 * @description: 257. Binary Tree Paths
 * https://leetcode.com/problems/binary-tree-paths/description/
 * <p>
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * <p>
 * Lesson6Distinct leaf is a node with no children.
 * <p>
 * Example 1:
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 * <p>
 * Example 2:
 * Input: root = [1]
 * Output: ["1"]
 *
 * Analysis:
 *
 * when pointer goes to the end (leaf), what is input for generate the result? what action we need to take
 * that is the current value and past path, and we find out one path which need to be added to result
 * what is previous path?, the previous path is when the pointer goes to the node(with children), the string was accumulated by parent and a "->"
 *
 * so let's implement follow our thoughts
 *
 */
public class LC257_BinaryTreePaths {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3, null, 5};
        TreeNode<Integer, Integer> root = GenerateExampleData.generateBinaryTree(array);


        LC257_BinaryTreePaths ins = new LC257_BinaryTreePaths();

//        List<String> paths1 = new ArrayList<>();
//        ins.constructPathRecursion(root, "", paths1);
//        System.out.println(paths1);

        List<String> paths2 = new ArrayList<>();
        ins.generatePathRecursion(root, "", paths2);
        System.out.println(paths2);
    }

    /**
     * Time complexity: O(N)
     * we visit each node exactly once, thus the time complexity is O(N), where N is the number of nodes.
     *
     * Space complexity: O(N).
     * Here we use the space for a stack call and for a paths list to store the answer.
     * paths contains as many elements as leaves in the tree,
     * hence couldn't be larger than log(N) for the trees containing more than one element.
     * Hence the space complexity is determined by a stack call.
     * In the worst case, when the tree is completely unbalanced,
     * e.g. each node has only one child node, the recursion call would occur N times (the height of the tree),
     * therefore the storage to keep the call stack would be O(N).
     * But in the best case (the tree is balanced), the height of the tree would be log(N).
     * Therefore, the space complexity in this case would be O(log(N)).
     * @param node
     * @param givenPath
     * @param result
     */
    public void generatePathRecursion(TreeNode<Integer, Integer> node,
                                      String givenPath,
                                      List<String> result){
        // pointer pointing to a leaf, we need a givenPath from previous
        if (node.getLeft() ==null && node.getRight()==null){
            result.add(givenPath + node.getKey());
            return;
        }
        // if not leaf,
        // first, we need to accumulate the node key to the path + '->'
        givenPath = givenPath + node.getKey() + "->";
        // second, do recursively , if left child is not null
        if (node.getLeft()!=null) {
            generatePathRecursion(node.getLeft(), givenPath, result);
        }
        // third, do recursively , if right child is not null
        if (node.getRight()!=null) {
            generatePathRecursion(node.getRight(), givenPath, result);
        }
    }

    public void constructPathRecursion(TreeNode<Integer, Integer> node, String path, List<String> paths) {
        // this is leaf
        if (node.getLeft() == null && node.getRight() == null) {
            path = path + node.getKey().toString();
            paths.add(path);
        } else {
            path = path + node.getKey().toString() + "->";
            if (node.getLeft() != null) {
                constructPathRecursion(node.getLeft(), path, paths);
            }
            if (node.getRight() != null) {
                constructPathRecursion(node.getRight(), path, paths);
            }
        }

    }


}
