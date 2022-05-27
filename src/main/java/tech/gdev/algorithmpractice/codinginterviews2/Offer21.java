package tech.gdev.algorithmpractice.codinginterviews2;

/**
 * 21
 * Easy
 *
 * @author gdev
 * @date 2022/5/27 20:50
 */
public class Offer21 {
    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * @param nums -
         * @return -
         */
        public int[] exchange(int[] nums) {
            if (nums == null || nums.length <= 1) {return nums;}
            int left = 0; int right = nums.length - 1;
            while (left < right) {
                if ((nums[left] & 1) == 1) {
                    left++;
                } else if ((nums[right] & 1) == 0) {
                    right--;
                } else {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    left++;
                    right--;
                }
            }
            return nums;
        }
    }
}
