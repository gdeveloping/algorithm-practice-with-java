package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.easy;

/**
 * 70.
 * Easy
 *
 * @author gdev
 * @date 2022/5/10 22:41
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        test1(2, 2);
        test1(3, 3);
        test1(10, 89);

        System.out.println();
        test2(2, 2);
        test2(3, 3);
        test2(10, 89);
    }

    private static void test1(int n, int output) {
        Solution1 solution1 = new Solution1();
        int res = solution1.climbStairs(n);
        System.out.println("n: " + n + "\tres: " + res + "\t" + (res == output));
    }

    private static void test2(int n, int output) {
        Solution2 solution2 = new Solution2();
        int res = solution2.climbStairs(n);
        System.out.println("n: " + n + "\tres: " + res + "\t" + (res == output));
    }

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
         * Memory Usage: 41.4 MB, less than 17.16% of Java online submissions for Climbing Stairs.
         *
         * @param n -
         * @return -
         */
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            int prePre = 1;
            int pre = 2;
            for (int i = 3; i <= n; i++) {
                int val = pre + prePre;
                prePre = pre;
                pre = val;
            }
            return pre;
        }
    }

    private static class Solution2 {
        /**
         * time: O(N)
         * space: O(N)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
         * Memory Usage: 39.2 MB, less than 81.47% of Java online submissions for Climbing Stairs.
         *
         * @param n -
         * @return -
         */
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            int[] dp = new int[n+1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2; // 2; 1,1
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }
            return dp[n];
        }
    }
}
