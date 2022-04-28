package tech.gdev.algorithmpractice.leetcode.twopointers.medium;

import java.util.Arrays;

/**
 * 11.
 * Medium
 *
 * @author gdev
 * @date 2022/4/28 23:09
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[][] arrs = new int[][]{
                {1,8,6,2,5,4,8,3,7} // 49
                , {1,1} // 1
        };
        Solution1 solution1 = new Solution1();
        for (int[] nums : arrs) {
            System.out.println(solution1.maxArea(nums) + "\t" + Arrays.toString(nums));
        }
    }

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(10
         *
         * Runtime: 4 ms, faster than 70.81% of Java online submissions for Container With Most Water.
         * Memory Usage: 52.7 MB, less than 84.68% of Java online submissions for Container With Most Water.
         *
         * @param height -
         * @return -
         */
        public int maxArea(int[] height) {
            final int size = height.length;
            int left = 0;
            int right = size - 1;
            int max = 0;
            while (left < right) {
                int w = right - left;
                int h = Math.min(height[left], height[right]);
                max = Math.max(max, w * h);
                if (height[left] <= height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return max;
        }
    }
}
