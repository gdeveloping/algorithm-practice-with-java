package tech.gdev.algorithmpractice.leetcode.twopointers.easy;

import java.util.Arrays;

/**
 * 977.
 * Easy
 *
 * @author gdev
 * @date 2022/4/26 21:39
 */
public class SquaresOfASortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{-4,-1,0,3,10};
        Solution1 solution1 = new Solution1();
        int[] res;
        res = solution1.sortedSquares(nums);
        System.out.println(Arrays.toString(res));
        Solution2 solution2 = new Solution2();
        res = solution2.sortedSquares(nums);
        System.out.println(Arrays.toString(res));

    }

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 3 ms, faster than 46.60% of Java online submissions for Squares of a Sorted Array.
         * Memory Usage: 55.5 MB, less than 58.90% of Java online submissions for Squares of a Sorted Array.
         *
         * @param nums -
         * @return -
         */
        public int[] sortedSquares(int[] nums) {
            int[] res = new int[nums.length];
            int left = 0;
            int right = nums.length-1;
            int index = nums.length-1;
            while (index >= 0) {
                if (getNumSquare(nums[left]) > getNumSquare(nums[right])) {
                    res[index] = getNumSquare(nums[left]);
                    left++;
                } else {
                    res[index] = getNumSquare(nums[right]);
                    right--;
                }
                index--;
            }
            return res;
        }

        private static int getNumSquare(int n) {
            return (int) Math.pow(n, 2);
        }
    }


    private static class Solution2 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 2 ms, faster than 76.70% of Java online submissions for Squares of a Sorted Array.
         * Memory Usage: 56.5 MB, less than 5.96% of Java online submissions for Squares of a Sorted Array.
         *
         * @param nums -
         * @return -
         */
        public int[] sortedSquares(int[] nums) {
            int[] res = new int[nums.length];
            int left = 0;
            int right = nums.length-1;
            for (int i = nums.length-1; i >= 0; i--) {
                if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                    res[i] = nums[left] * nums[left];
                    left++;
                } else {
                    res[i] = nums[right] * nums[right];
                    right--;
                }
            }
            return res;
        }
    }
}
