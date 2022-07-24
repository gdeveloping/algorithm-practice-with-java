package tech.gdev.algorithmpractice.codinginterviews2;

import java.util.Arrays;

/**
 * 61
 * Easy
 * 
 * @author gdev
 * @date 2022/7/24 17:40
 */
public class Offer61 {
    private static class Solution1 {
        /**
         * time: O(N*log(N)) sort
         * space: O(N)
         * modify source: Y
         *
         * @param nums -
         * @return -
         */
        public boolean isStraight(int[] nums) {
            Arrays.sort(nums);
            int size = nums.length;
            int count = 0;
            for (int num : nums) {
                if (0 == num) {
                    ++count;
                } else {
                    break;
                }
            }
            if (count == size) {
                return true;
            }
            int pre = nums[count];
            int idx = count + 1;
            while (idx < size) {
                if (pre + 1 == nums[idx]) {
                    ++idx;
                    ++pre;
                } else if (count > 0){
                    --count;
                    ++pre;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
