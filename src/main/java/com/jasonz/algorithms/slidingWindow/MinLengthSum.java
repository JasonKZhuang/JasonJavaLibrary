package com.jasonz.algorithms.slidingWindow;

/**
 * @author Jason Zhuang
 * @created 2024.01.28 23:42
 * @project JasonJavaLibrary
 * @description:
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 *
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray
 * whose sum is greater than or equal to target.
 * If there is no such subarray, return 0 instead.
 *
 * Example 1:
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 *
 * Example 2:
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 *
 * Example 3:
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 *
 */
public class MinLengthSum {

    public static void main(String[] args) {
        int[] arr = { 1,1,1,1,1,1,1,1 };
        int target = 11;
        System.out.println(minLengthSumOfSubArrayByDynamicSlideWindow(arr, target));
    }

    /**
     * return a minimum length of sub array where sum the sub array equals or is greater than given value
     *
     * @param nums { 1, 4, 2, 10, 2, 3, 1, 0, 20 }
     * @param target
     * @return minimum length
     * @analisis
     * we need a minimum length of sub array, which means we need minimum window size that could be dynamic
     *
     * initial window size = 0, left pointer and right pointer is both on Zero
     * increase window size by moving right pointer step by step
     *
     * we do the calculation to compare the sum to given value
     *
     * if sum < given then
     *  compare the min length to the current window size
     *  continue the loop, which means moving right pointer to next step, also means increasing window size by one step
     * else
     *  the right pointer is at the element where our desired condition was not met before, hold this pointer.
     *  another imagination is that we tried to expend window size before but it failed, so we need to return to previous window size, how?
     *  let's move left pointer to next one step, so we got the same window size, but the window has moved to right one step
     *  meantime, we already calculate the sum value there, we need to minus the left-previous element.
     *  at this moment, we got the window size that is same to before, we got the new right element and removed the pre-left element
     * end if
     * keep looping
     *
     * notes the key things:
     *  we need to know
     *      where the edges pointers of window are, and
     *      how to move the left and/or right pinter
     *      what we should do when any pointer moved
     *  when condition got unWanted
     *
     */
    private static int minLengthSumOfSubArrayByDynamicSlideWindow(int[] nums, int target) {
        // tracking the minimum length, also is window size
        int min_length = nums.length;

        // the current range and sum of the sliding window
        int left = 0;
        int right = 0;
        int sum = 0;
        boolean existing = false;

        // move the right pointer to extend the window size
        while (right < nums.length) {
            //accumulating sum when moving right pointer
            sum = sum + nums[right];
            // move right pointer to one-right-step
            right++;

            // if sum value is equal or larger than give
            // we need to move left pointer
            while (left < right && sum >= target) {

                //calculate sum by minus the left-most element
                sum = sum - nums[left];

                // move left pointer
                left = left + 1;

                // update the min_length if this is shorter than the current min
                // this mean the window size is still the size before move right pointer
                min_length = Math.min(min_length, (right - left + 1));

                existing = true;
            }
            //after left pointer stop, keep moving right pointer, increasing window size
        }

        if (!existing){
            return 0;
        }

        min_length = Math.min(min_length, (right - left + 1));

        return min_length;

    }


}
