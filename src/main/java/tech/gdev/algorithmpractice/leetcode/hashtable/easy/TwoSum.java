package tech.gdev.algorithmpractice.leetcode.hashtable.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1.
 * Easy
 *
 * @author gdev
 * @date 2022/4/17 23:13
 */
public class TwoSum {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        test1(new int[]{2,7,11,15}, 9, solution1);
        test1(new int[]{3,2,4}, 6, solution1);
        test1(new int[]{3,3}, 6, solution1);
    }

    private static void test1(int[] nums, int target, Solution1 solution1) {
        System.out.println(Arrays.toString(solution1.twoSum(nums, target)));
    }

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(N)
         *
         * Runtime: 2 ms, faster than 91.20% of Java online submissions for Two Sum.
         * Memory Usage: 42.2 MB, less than 95.54% of Java online submissions for Two Sum.
         *
         * @param nums -
         * @param target -
         * @return -
         */
        public int[] twoSum(int[] nums, int target) {
            int[] res = new int[2];
            HashMap<Integer, Integer> map = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target-nums[i])) {
                    res[0] = map.get(target-nums[i]);
                    res[1] = i;
                    return res;
                } else {
                    map.put(nums[i], i);
                }
            }
            return res;
        }
    }
}
