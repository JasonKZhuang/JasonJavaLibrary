package com.jasonz.algorithms.cases;

import com.jasonz.dataStructures.tree.BinarySearchTree;
import com.jasonz.dataStructures.tree.TreeNode;
import com.jasonz.utilities.GenerateExampleData;

/**
 * @author Jason Zhuang
 * @created 2024.01.18 18:06
 * @project JasonJavaLibrary
 * @description:
 */
public class FindInorderSuccessor {

    private TreeNode<Integer, Integer> previous;
    private TreeNode<Integer, Integer> successorNode;

    public static void main(String[] args) {

        TreeNode<Integer, Integer> root = GenerateExampleData.generateBinarySearchTree();
        TreeNode<Integer, Integer> target = new TreeNode<>(14, 140, new TreeNode<>(12, 120));
        TreeNode<Integer, Integer> succ = null;

        FindInorderSuccessor fis = new FindInorderSuccessor();

        succ = fis.inorderSuccessorUseRightMinimumValue(root, target);
        System.out.println("successor [" + succ.getKey() + ":" + succ.getValue() + "]");

        succ = fis.inorderSuccessorUseBstFeature(root, target);
        System.out.println("successor [" + succ.getKey() + ":" + succ.getValue() + "]");

        // this one was not successful
        //TreeNode<Integer, Integer> succ2 = null;
        //fis.inorderSuccessorByTraversal(root, target, succ2);
        //System.out.println("successor [" + succ2.getKey() + ":" + succ2.getValue() + "]");

        // this one was not successful
        //fis.inorderSuccessorByTraversal(root,target);
        //succ = fis.successorNode;
        //System.out.println("successor [" + succ.getKey() + ":" + succ.getValue() + "]");

    }

    /**
     * The Algorithm is divided into two cases on the basis of the right subtree of the input node being empty or not.
     * <p>
     * Input: node, root // node is the node whose Inorder successor is needed.
     * <p>
     * Output: succ // succ is Inorder successor of node.
     * <p>
     * If right subtree of node is not NULL, then succ lies in right subtree. Do the following.
     * Go to right subtree and return the node with minimum key value in the right subtree.
     * If right subtree of node is NULL, then succ is one of the ancestors. Do the following.
     * Travel up using the parent pointer until you see a node which is left child of its parent. The parent of such a node is the succ.
     */
    public TreeNode<Integer, Integer> inorderSuccessorUseRightMinimumValue(TreeNode<Integer, Integer> root,
                                                                           TreeNode<Integer, Integer> node) {

        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();

        node = bst.search(root, node.getKey());

        // Step 1: We simply need to find the leftmost node in the subtree rooted at p.right.
        // since the successor Node of p is inside the p.right subtree
        if (node.getRight() != null) {

            return bst.minimum(node.getRight());

            /*
            // or we can implement find the left most method
            // initialize the left most with p.right node
            TreeNode<Integer,Integer> leftmost = p.getRight();

            // while the tempNode has left, find out the most left
            while (leftmost.getLeft() != null) {
                leftmost = leftmost.getLeft();
            }

            // return the left most is the p's successor
            this.inorderSuccessorNode = leftmost;
            */


        }

        // step 2 of the above algorithm
        TreeNode<Integer, Integer> p = node.getParent();
        // if the parent node is not null, and parent.right node key value == given node key value
        while (p != null && Integer.compare(p.getRight().getKey(), node.getKey()) == 0) {
            // backtrack parent recursively, until the parent right node is not current node
            node = p;
            p = p.getParent();
        }

        return p;
    }

    /**
     * this method utilized the feature of BST
     * the left is smaller than root
     * the right is larger than root
     *
     * @param argRoot
     * @param givenNode
     * @return
     */
    public TreeNode<Integer, Integer> inorderSuccessorUseBstFeature(TreeNode<Integer, Integer> argRoot, TreeNode<Integer, Integer> givenNode) {
        TreeNode<Integer, Integer> successor = null;
        while (argRoot != null) {

            if (givenNode.getKey() >= argRoot.getKey()) {
                argRoot = argRoot.getRight();
            } else {
                successor = argRoot;
                argRoot = argRoot.getLeft();
            }
        }
        return successor;
    }


    /**
     * (Inorder traversal)
     * An inorder transversal of BST produces a sorted sequence.
     * Therefore, we perform an inorder traversal.
     * <p>
     * The first encountered node with value greater than the node is the inorder successor.
     * <p>
     * Input: node, root // node is the node whose ignorer successor is needed.
     * <p>
     * Output: succ // succ is Inorder successor of node.
     */
    private void inorderSuccessorByTraversal(TreeNode<Integer, Integer> root,
                                             TreeNode<Integer, Integer> node,
                                             TreeNode<Integer, Integer> succ
    ) {

        if (root == null) {
            return;
        }

        // Recurse on the left side
        inorderSuccessorByTraversal(root.getLeft(), node, succ);
        // check the temp root node, compare to the give node
        if (root.getKey() > node.getKey() && succ == null) {
            succ = root;
            return;
        }
        // Recurse on the right side
        inorderSuccessorByTraversal(node.getRight(), node, succ);
    }

    private void inorderSuccessorByTraversal(TreeNode<Integer, Integer> argRoot, TreeNode<Integer, Integer> givenNode) {

        if (argRoot == null) {
            return;
        }

        // Recurse on the left side
        inorderSuccessorByTraversal(argRoot.getLeft(), givenNode);

        // Check if previous is the inorder predecessor of node
        if (this.previous == givenNode && this.successorNode == null) {
            this.successorNode = argRoot;
            return;
        }

        // Keeping previous up-to-date for further recursions
        this.previous = argRoot;

        // Recurse on the right side
        inorderSuccessorByTraversal(argRoot.getRight(), givenNode);
    }


}