package com.jasonz.algorithms.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jason Zhuang
 * @created 2024.01.29 00:43
 * @project JasonJavaLibrary
 * @description: You are visiting a farm that has a single row of fruit trees arranged from left to right.
 * The trees are represented by an integer array trees where trees[i] is the type of fruit the ith tree produces.
 * <p>
 * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
 * <p>
 * You only have two baskets, and each basket can only hold a single type of fruit.
 * There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right.
 * The picked trees must fit in one of your baskets.
 * <p>
 * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 * Given the integer array trees, return the maximum number of trees you can pick.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * Input: trees = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 * <p>
 * Example 2:
 * Input: trees = [0,1,2,2]
 * Output: 3
 * Explanation: We can pick from trees [1,2,2].
 * If we had started at the first tree, we would only pick from trees [0,1].
 * <p>
 * Example 3:
 * Input: trees = [1,2,3,2,2]
 * Output: 4
 * Explanation: We can pick from trees [2,3,2,2].
 * If we had started at the first tree, we would only pick from trees [1,2].
 *
 * References:
 * <a href="https://www.youtube.com/watch?v=ky8lfJx5jJk">Fruits Into Basket - Sliding Window - Leetcode 904 </a>
 *
 */
public class FruitIntoBaskets {

    public static void main(String[] args) {
        int[] trees = new int[]{1, 2, 3, 2, 2};
        FruitIntoBaskets ins = new FruitIntoBaskets();
        System.out.println(ins.solutionNaive(trees));
        System.out.println(ins.solutionSlidingWindow(trees));
    }

    /**
     * If the current fruit at index right makes our window (left, right) have 3 types of fruit,
     * we need to break the iteration over right and start over from index left + 1.
     * The question is, is this step necessary? Do we need to recalculate the types of fruits from left + 1 again?
     *
     * If we have found a valid window of size k starting at index left, even though we want to restart at left + 1,
     * there is no need to recalculate the fruit type from left + 1 all to way to right, which represent windows of size no larger than k.
     * We only need to look for windows larger than k!
     *
     * Thus the logic becomes very clear:
     * we let indexes left and right represent the size of the longest valid window we have encountered so far.
     * In further iterations, instead of looking for smaller windows, we just check if the newly added fruit expands the window.
     *
     * More specifically:
     * we always add fruits from the right side to temporarily increase the window size by 1 (Let's say from k to k + 1),
     * and if the new window is valid, it means that we have managed to find a larger window of size k + 1, great!
     * Otherwise, this means that we haven't encountered a valid window of size k + 1 yet,
     * so we should go back to the previous window size, by removing one fruit from the left side of the window.
     * @param trees
     * @return
     */
    private int solutionSlidingWindow(int[] trees) {
        int left = 0;
        int right = 0;

        // Hash map 'basket' to store the types of fruits and counts.
        Map<Integer, Integer> basket = new HashMap<>();

        // actually there are two pointers need to be handled right and left
        for(right = 0; right<trees.length; right++){

            // every movement, update the map
            basket.put(trees[right], basket.getOrDefault(trees[right], 0) + 1);

            // every time of movement, need to check the number of bucket
            if (basket.size()>2){ // if there are 3 types of fruits
                basket.put(trees[left], basket.get(trees[left]) - 1);
                if (basket.get(trees[left]) == 0) {
                    basket.remove(trees[left]);
                }
                left++;
            }

        }

        // Once we finish the iteration, the indexes left and right
        // stands for the longest valid subarray we encountered.
        return right - left;
    }

    private int solutionBruteForce(int[] trees) {
        // Maximum number of fruits we can pick
        int maxPicked = 0;

        // Iterate over the left index left of subarrays.
        for (int left = 0; left < trees.length; ++left) {
            // Empty set to count the type of fruits.
            Set<Integer> basket = new HashSet<>();
            int right = left;

            // Iterate over the right index right of subarrays.
            while (right < trees.length) {
                // Early stop. If adding this fruit makes 3 types of fruit,
                // we should stop the inner loop.
                if (!basket.contains(trees[right]) && basket.size() == 2)
                    break;

                // Otherwise, update the number of this fruit.
                basket.add(trees[right]);
                right++;
            }

            // Update maxPicked.
            maxPicked = Math.max(maxPicked, right - left);
        }

        // Return maxPicked as the maximum length of valid subarray.
        // (maximum number of fruits we can pick).
        return maxPicked;
    }

    private int solutionNaive(int[] trees) {
        int maxNum = 0;
        // key is the type of fruit, value is the number of fruits
        Map<Integer, Integer> buckets = new HashMap<>();
        int start = 0;
        // {0,1,2,2};
        for (start = 0; start < trees.length; start++) {
            buckets.clear();
            buckets.put(trees[start], 1);
            for (int j = start + 1; j < trees.length; j++) {
                if (buckets.size() == 1) {
                    if (buckets.get(trees[j]) == null) { //  new fruit, need to add to bucket
                        buckets.put(trees[j], 1);
                    } else { // some fruit , so update value
                        buckets.put(trees[j], buckets.get(trees[j]) + 1);
                    }
                } else if (buckets.size() == 2) {
                    if (buckets.get(trees[j]) == null) { //  new fruit, need to sto and go next round
                        maxNum = Math.max(maxNum, sumFruits(buckets));
                        break;
                    } else { // some fruit , so update value
                        buckets.put(trees[j], buckets.get(trees[j]) + 1);
                    }
                }
            }
            maxNum = Math.max(maxNum, sumFruits(buckets));
        }

        if (!buckets.isEmpty()) {
            maxNum = Math.max(maxNum, sumFruits(buckets));
        }

        return maxNum;
    }


    public int sumFruits(Map<Integer, Integer> argBuckets) {
        int sumValue = 0;
        for (Integer n : argBuckets.values()) {
            sumValue = sumValue + n;
        }
        return sumValue;
    }

}
