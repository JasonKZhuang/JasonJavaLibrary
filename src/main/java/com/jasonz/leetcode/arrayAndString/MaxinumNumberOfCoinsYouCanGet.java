package com.jasonz.leetcode.arrayAndString;

import java.util.*;

/**
 * @author Jason Zhuang
 * @created 2023.11.24 12:58
 * @project JasonJavaLibrary
 * @description:
 */
public class MaxinumNumberOfCoinsYouCanGet {
    public static void main(String[] args) {
        MaxinumNumberOfCoinsYouCanGet ins = new MaxinumNumberOfCoinsYouCanGet();

        int[] numbers1 = {2, 4, 1, 2, 7, 8};
        int[] numbers2 = {2, 4, 1, 2, 7, 8};

        System.out.println(ins.maxCoins(numbers1));

        System.out.println(maxCoinsByDQueue(numbers2));
    }

    /**
     * this one is very good
     * @param piles
     * @return
     */
    public int maxCoins(int[] piles) {
        int sum = 0;
        int pSize = piles.length;
        if (pSize < 3)
            return 0;
        Arrays.sort(piles);
        int j = (pSize - 1);
        for (int i = 0; i < pSize; i++) {
            if ((j - i) < 2) {
                break;
            }
            sum = sum + piles[j - 1];
            j = j - 2;
        }
        return sum;
    }

    /**
     * this method is not efficient, when doing a long array
     * @param piles
     * @return
     */
    public static int maxCoinsByDQueue(int[] piles) {
        int sum = 0;

        // sort the Array
        List<Integer> sortedList = new LinkedList<>();
        for (int p : piles) {
            insertInSortedOrder(sortedList, p);
        }

        // Creating a sorted Deque using LinkedList and a Comparator
        Deque<Integer> sortedDeque = new LinkedList<>(sortedList);

        while (sortedDeque.size()>2){
            // remove the min one
            sortedDeque.pollFirst();

            // remove the max one
            sortedDeque.pollLast();

            // pick the second largest one to add
            if (sortedDeque.peekLast()!=null){
                sum = sum + sortedDeque.peekLast();
            }

            // remove the second largest one
            sortedDeque.pollLast();
        }
        return sum;
    }

    // Method to insert an element in a sorted order
    private static void insertInSortedOrder(List<Integer> list, int element) {
        ListIterator<Integer> iterator = list.listIterator();

        while (iterator.hasNext()) {
            if (iterator.next() > element) {
                iterator.previous(); // Move back to the previous position
                iterator.add(element);
                return; // Element inserted, so we can exit the method
            }
        }

        // If we reach here, the element is greater than or equal to all elements in the list
        iterator.add(element);
    }
}

