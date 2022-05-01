package tech.gdev.algorithmpractice.leetcode.greedy.medium;

import java.util.Arrays;

/**
 * 376
 * Medium
 *
 * @author gdev
 * @date 2022/5/1 15:24
 */
public class WiggleSubsequence {

    public static void main(String[] args) {
        test1(new int[]{1,7,4,9,2,5}, 6);
        test1(new int[]{1,17,5,10,13,15,10,5,16,8}, 7);

        System.out.println();
        test2(new int[]{1,17,5,10,13,15,10,5,16,8}, 7);
        test2(new int[]{1,7,4,9,2,5}, 6);
    }

    private static void test1(int[] nums, int output) {
        System.out.println();
        Solution1 solution1 = new Solution1();
        int res = solution1.wiggleMaxLength(nums);
        System.out.println(res + "\t" + (res == output) + "\t" + Arrays.toString(nums));
    }

    private static void test2(int[] nums, int output) {
        System.out.println();
        Solution2 solution2 = new Solution2();
        int res = solution2.wiggleMaxLength(nums);
        System.out.println(res + "\t" + (res == output) + "\t" + Arrays.toString(nums));
    }


    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Wiggle Subsequence.
         * Memory Usage: 41.7 MB, less than 49.92% of Java online submissions for Wiggle Subsequence.
         *
         * @param nums -
         * @return -
         */
        public int wiggleMaxLength(int[] nums) {
            if (nums.length <= 1) {return nums.length;}
            int up = 1;
            int down = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i-1] < nums[i]) {
                    up = down + 1;
                } else if (nums[i-1] > nums[i]) {
                    down = up + 1;
                }
            }
            return Math.max(up, down);
        }
    }


    private static class Solution2 {
        /**
         * time: O(N^2)
         * space: O(N)
         *
         * Runtime: 6 ms, faster than 14.71% of Java online submissions for Wiggle Subsequence.
         * Memory Usage: 41.2 MB, less than 68.65% of Java online submissions for Wiggle Subsequence.
         *
         * @param nums -
         * @return -
         */
        public int wiggleMaxLength(int[] nums) {
            if (nums.length <= 1) {return nums.length;}
            final int size = nums.length;
            int[] up = new int[size];
            int[] down = new int[size];
            Arrays.fill(up, 1);
            Arrays.fill(down, 1);
            for (int i = 1; i < size; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        up[i] = Math.max(up[i], down[j] + 1);
                    } else if (nums[j] > nums[i]) {
                        down[i] = Math.max(down[i], up[j] + 1);
                    }
                }
            }
//            System.out.println("up:   " + Arrays.toString(up));
//            System.out.println("down: " + Arrays.toString(down));
            return Math.max(down[size-1], up[size-1]);
        }
    }
}
