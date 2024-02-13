package com.jasonz.utilities;

import com.github.javafaker.Faker;
import com.jasonz.dataStructures.list.linkedList.ListNode;
import com.jasonz.dataStructures.tree.BinarySearchTree;
import com.jasonz.dataStructures.tree.BinaryTree;
import com.jasonz.dataStructures.tree.TreeNode;
import com.jasonz.dto.IntegerData;
import com.jasonz.dto.Vertex;

import java.util.*;

/**
 * @author Jason Zhuang
 * @created 2024.01.26 11:29
 * @project JasonJavaLibrary
 * @description:
 */
public class GenerateExampleData {

    public static ListNode generateNodeList(int[] array) {
        ListNode root = new ListNode(array[0]);
        ListNode temp = root;
        for (int i = 1; i < array.length; i++) {
            temp.setNext(new ListNode(array[i]));
            temp = temp.getNext();
        }
        return root;
    }

    public static TreeNode<Integer, Integer> generateBinaryTree(Integer[] array) {
        return  BinaryTree.constructACompleteBinaryTree(array);
    }

    public static TreeNode<Integer, Integer> generateBinaryTree() {

        BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(20, 200);
        binarySearchTree.insert(9, 90);
        binarySearchTree.insert(5, 50);
        binarySearchTree.insert(12, 120);
        binarySearchTree.insert(11, 110);
        binarySearchTree.insert(14, 140);
        binarySearchTree.insert(25, 250);
        binarySearchTree.insert(30, 300);
        binarySearchTree.insert(28, 280);
        return binarySearchTree.getRoot();
    }

    public static Vertex<Integer> generateVertexGraph() {
        Vertex<Integer> v0 = new Vertex<>(0);
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Vertex<Integer> v4 = new Vertex<>(4);
        Vertex<Integer> v5 = new Vertex<>(5);
        Vertex<Integer> v6 = new Vertex<>(6);

        v0.setNeighbors(Arrays.asList(v1, v5, v6));
        v1.setNeighbors(Arrays.asList(v3, v4, v5));
        v4.setNeighbors(Arrays.asList(v2, v6));
        v6.setNeighbors(List.of(v0));
        return v0;
    }

    public static void generateIntegerKeyValueArray(IntegerData[] tempData) {
        tempData[0] = new IntegerData(8, 80);
        tempData[1] = new IntegerData(3, 30);
        tempData[2] = new IntegerData(10, 100);
        tempData[3] = new IntegerData(1, 10);
        tempData[4] = new IntegerData(6, 60);
        tempData[5] = new IntegerData(14, 140);
        tempData[6] = new IntegerData(4, 40);
        tempData[7] = new IntegerData(7, 70);
        tempData[8] = new IntegerData(13, 130);
        tempData[9] = new IntegerData(5, 50);
    }

    public static void generateMap(Map<Integer, String> argMap, boolean randomFlag) {
        // initialize map and binary tree
        Faker faker = new Faker();
        if (randomFlag) {
            Set<Integer> keys = new HashSet<>();
            Random random = new Random();
            while (keys.size() < 10) {
                int k = random.nextInt(100);
                if (keys.contains(k)) {
                    continue;
                }
                argMap.put(k, faker.name().firstName());
                keys.add(k);
            }
        } else {
            argMap.put(8, faker.name().firstName());
            argMap.put(3, faker.name().firstName());
            argMap.put(10, faker.name().firstName());
            argMap.put(1, faker.name().firstName());
            argMap.put(6, faker.name().firstName());
            argMap.put(14, faker.name().firstName());
            argMap.put(4, faker.name().firstName());
            argMap.put(7, faker.name().firstName());
            argMap.put(13, faker.name().firstName());
        }
    }


}
