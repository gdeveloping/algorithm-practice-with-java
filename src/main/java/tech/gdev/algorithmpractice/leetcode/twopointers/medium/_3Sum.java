package tech.gdev.algorithmpractice.leetcode.twopointers.medium;

import java.util.*;

/**
 * 15.
 * Medium
 *
 * @author gdev
 * @date 2022/4/14 21:08
 */
public class _3Sum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        // -4, -1, -1, 0, 1, 2
        List<List<Integer>> res = (new Solution1()).threeSum(nums);
        System.out.println(res);
    }

    private static class Solution1 {
        /**
         * time: O(N^2)
         * space: O(1)
         *
         * Runtime: 24 ms, faster than 86.13% of Java online submissions for 3Sum.
         * Memory Usage: 46.7 MB, less than 85.82% of Java online submissions for 3Sum.
         *
         * @param nums -
         * @return -
         */
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new LinkedList<>();
            if (nums == null || nums.length < 3) {return res;}
            Arrays.sort(nums);
            for (int index = 0; index < nums.length - 2; index++) {
                if (index > 0 && nums[index] == nums[index-1]) {continue;}
                int sum = 0 - nums[index];
                int left = index + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int a = nums[left] + nums[right];
                    if (a == sum) {
                        res.add(List.of(nums[index], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[++left]);
                        while (left < right && nums[right] == nums[--right]);
                    } else if (a < sum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return res;
        }
    }
}
