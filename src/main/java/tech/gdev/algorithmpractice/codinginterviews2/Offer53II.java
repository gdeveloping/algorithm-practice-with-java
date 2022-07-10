package tech.gdev.algorithmpractice.codinginterviews2;

/**
 * 53II
 * Easy
 *
 * @author gdev
 * @date 2022/7/10 12:27
 */
public class Offer53II {
    private static class Solution1 {
        /**
         * use way1
         *
         * time: O(N)
         * space: O(1)
         * modify source: N
         *
         * way 1:
         * a xor b = (¬a ∧ b) ∨ (a ∧¬b)
         *
         * way 2:
         * s1 = sum[0...n-1],
         * s2 = sum(nums)
         * res = s1 - s2
         * integer overflow
         *
         * way 3:
         * hash sets
         *
         * @param nums -
         * @return -
         */
        public int missingNumber(int[] nums) {
            int cur = 0;
            for (int num : nums) {
                cur ^= num;
            }
            for (int i = 1; i <= nums.length; i++) {
                cur ^= i;
            }
            return cur;
        }
    }
}
