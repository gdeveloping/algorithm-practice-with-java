package tech.gdev.algorithmpractice.codinginterviews2;

/**
 * 42
 * Easy
 *
 * @author gdev
 * @date 2022/6/3 16:36
 */
public class Offer42 {

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * @param nums -
         * @return -
         */
        public int maxSubArray(int[] nums) {
            int pre = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                pre = nums[i] + Math.max(pre, 0);
                max = Math.max(max, pre);
            }
            return max;
        }
    }

    private static class Solution2 {
        private static class Status {
            public int lSum, rSum, mSum, iSum;

            public Status(int lSum, int rSum, int mSum, int iSum) {
                this.lSum = lSum;
                this.rSum = rSum;
                this.mSum = mSum;
                this.iSum = iSum;
            }
        }

        /**
         * time: O(N)
         * space: O(log(N)) stack
         *
         * @param nums -
         * @return -
         */
        public int maxSubArray(int[] nums) {
            return helper(nums, 0, nums.length-1).mSum;
        }

        private Status helper(int[] nums, int left, int right) {
            if (left == right) {
                return new Status(nums[left], nums[left], nums[left], nums[left]);
            }
            int middle = (left + right) >> 1;
            Status lStatus = helper(nums, left, middle);
            Status rStatus = helper(nums, middle+1, right);
            int lSum = Math.max(lStatus.lSum, lStatus.iSum + rStatus.lSum);
            int rSum = Math.max(rStatus.rSum, lStatus.rSum + rStatus.iSum);
            int mSum = Math.max(Math.max(lStatus.mSum, rStatus.mSum), lStatus.rSum + rStatus.lSum);
            int iSum = lStatus.iSum + rStatus.iSum;
            return new Status(lSum, rSum, mSum, iSum);
        }
    }
}
