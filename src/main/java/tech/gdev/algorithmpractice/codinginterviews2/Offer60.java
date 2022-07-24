package tech.gdev.algorithmpractice.codinginterviews2;

import java.util.Arrays;

/**
 * 60
 * Medium
 *
 * @author gdev
 * @date 2022/7/24 14:26
 */
public class Offer60 {

    public static void main(String[] args) {
        Solution2 s2 = new Solution2();
        double[] res;
        res = s2.dicesProbability(3);
        System.out.println(Arrays.toString(res));
    }

    private static class Solution1 {
        /**
         * time: O(N^2)
         * space: O(N)
         * modify source: N
         *
         * @param n -
         * @return -
         */
        public double[] dicesProbability(int n) {
            final int maxNum = 6;
            int low = n;
            int high = maxNum * n;
            int size = high - low + 1;
            int[] dp = new int[high + 1];
            dp[0] = 0;
            Arrays.fill(dp, 1, maxNum + 1, 1);
            for (int i = 2; i <= n; i++) {
                for (int j = maxNum * i; j >= i; j--) {
                    dp[j] = 0;
                    for (int k = 1; k <= maxNum && j - k >= i - 1; k++) {
                        dp[j] += dp[j - k];
                    }
                }
            }
            double all = Math.pow(maxNum, n);
            double[] res = new double[size];
            for (int i = n; i <= high; i++) {
                res[i - n] = dp[i] / all;
            }
            return res;
        }
    }

    private static class Solution2 {
        /**
         * time: O(N^2)
         * space: O(N^2)
         * modify source: N
         *
         * @param n -
         * @return -
         */
        public double[] dicesProbability(int n) {
            final int maxNum = 6;
            double[] dp = new double[maxNum];
            Arrays.fill(dp, 1.0 / maxNum);
            for (int i = 2; i <= n; i++) {
                double[] tmp = new double[maxNum * n];
                for (int j = i - 2; j < dp.length; j++) {
                    for (int k = 1; k <= 6 && j + k < tmp.length; k++) {
                        tmp[j + k] += dp[j] / maxNum;
                    }
                }
                dp = tmp;
            }
            return Arrays.copyOfRange(dp, n - 1, dp.length);
        }
    }

    private static class Solution3 {
        /**
         * TIMEOUT
         *
         * @param n -
         * @return -
         */
        public double[] dicesProbability(int n) {
            final int maxNum = 6;
            int low = n;
            int high = maxNum * n;
            int size = high - low + 1;
            double[] res = new double[size];
            int[] nums = new int[n + 1];
            int[] freq = new int[size];
            Arrays.fill(nums, 1);
            int idx = n;
            nums[0] = 0;
            while (nums[0] == 0) {
                while (nums[idx] <= maxNum) {
                    ++freq[sum(nums) - low];
                    ++nums[idx];
                }
                while (nums[idx] > maxNum) {
                    ++nums[--idx];
                }
                Arrays.fill(nums, idx + 1, n + 1, 1);
                idx = n;
            }
            double count = Math.pow(maxNum, n);
            for (int i = 0; i < size; i++) {
                res[i] = freq[i] / count;
            }
            return res;
        }

        private static int sum(int[] nums) {
            int sum = -nums[0];
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }
    }
}
