package tech.gdev.algorithmpractice.leetcode.greedy.medium;

import java.util.Arrays;

/**
 * 55.
 * Medium
 *
 * @author gdev
 * @date 2022/4/27 21:12
 */
public class JumpGame {

    public static void main(String[] args) {
        int[][] arrs = new int[][]{
                {2,3,1,1,4}, // true
                {3,2,1,0,4} // false
        };
        Solution1 solution1 = new Solution1();
        for (int[] nums : arrs) {
            System.out.println(solution1.canJump(nums) + "\t" + Arrays.toString(nums));
        }
        System.out.println();

        Solution2 solution2 = new Solution2();
        for (int[] nums : arrs) {
            System.out.println(solution2.canJump(nums) + "\t" + Arrays.toString(nums));
        }
    }

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(N)
         *
         * Runtime: 4 ms, faster than 43.22% of Java online submissions for Jump Game.
         * Memory Usage: 68 MB, less than 48.15% of Java online submissions for Jump Game.
         *
         * @param nums -
         * @return -
         */
        public boolean canJump(int[] nums) {
            final int size = nums.length;
            int[] jump = new int[size];
            for (int i = 0; i < size; i++) {
                jump[i] = i + nums[i];
            }
            int maxJump = jump[0];
            int index = 0;
            while (index < size && index <= maxJump) {
                if (jump[index] > maxJump) {
                    maxJump = jump[index];
                }
                index++;
            }
            if (index == size) {
                return true;
            }
            return false;
        }
    }


    private static class Solution2 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 2 ms, faster than 86.02% of Java online submissions for Jump Game.
         * Memory Usage: 42.9 MB, less than 81.41% of Java online submissions for Jump Game.
         *
         * @param nums -
         * @return -
         */
        public boolean canJump(int[] nums) {
            final int size = nums.length;
            int farthest = 0;
            for (int i = 0; i < size - 1; i++) {
                farthest = Math.max(farthest, i + nums[i]);
                if (farthest <= i) {
                    return false;
                }
            }
            return true;
        }

    }
}
