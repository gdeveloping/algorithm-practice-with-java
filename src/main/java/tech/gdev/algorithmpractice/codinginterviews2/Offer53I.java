package tech.gdev.algorithmpractice.codinginterviews2;

/**
 * 53I
 * Easy
 *
 * @author gdev
 * @date 2022/7/10 09:55
 */
public class Offer53I {

    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        int[] nums;
        int target;
        int res;
        int output;
        nums = new int[]{5,7,7,8,8,10};
        target = 8;
        output = 2;
        res = s1.search(nums, target);
        System.out.println((res == output) + "\t res:" + res);
    }

    private static class Solution1 {
        /**
         * time: O(log(N))
         * space: O(1)
         * modify source: N
         *
         * @param nums -
         * @param target -
         * @return -
         */
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int left = 0, right = nums.length - 1;
            int mid;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            int count = 0;
            while (left < nums.length && nums[left] == target) {
                ++count;
                ++left;
            }
            return count;
        }
    }
}
