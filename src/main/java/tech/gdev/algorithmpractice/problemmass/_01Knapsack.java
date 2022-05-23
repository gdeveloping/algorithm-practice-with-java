package tech.gdev.algorithmpractice.problemmass;

/**
 * three ways
 * 1. recursion tree,
 *    reverse(path)
 *    residual capacity
 * 2. recursion tree
 *    path
 *    weight sum
 * 3. dynamic programming
 *    use two variables to cover all situations
 *
 * @author gdev
 * @date 2022/5/23 09:13
 */
public class _01Knapsack {

    public static void main(String[] args) {
        int[] wt;
        int[] val;
        int w;
        wt = new int[]{2, 1, 3};
        val = new int[]{4, 2, 3};
        w = 4;
        test(w, wt, val);

        wt = new int[]{10, 20, 30};
        val = new int[]{60, 100, 120};
        w = 50;
        test(w, wt, val);

        wt = new int[]{1, 2, 3, 8, 7, 4};
        val = new int[]{20, 5, 10, 40, 15, 25};
        w = 10;
        test(w, wt, val);
    }

    private static void test(int w, int[] wt, int[] val) {
        Solution1_1 solution1_1 = new Solution1_1();
        Solution1_2 solution1_2 = new Solution1_2();
        Solution1_3 solution1_3 = new Solution1_3();
        Solution2_1 solution2_1 = new Solution2_1();
        Solution2_2 solution2_2 = new Solution2_2();
        Solution2_3 solution2_3 = new Solution2_3();
        Solution3 solution3 = new Solution3();

        int res;
        System.out.println();

        res = solution1_1.knapsack(w, wt, val);
        System.out.println("solution1_1: " + res);

        res = solution1_2.knapsack(w, wt, val);
        System.out.println("solution1_2: " + res);

        res = solution1_3.knapsack(w, wt, val);
        System.out.println("solution1_3: " + res);

        res = solution2_1.knapsack(w, wt, val);
        System.out.println("solution2_1: " + res);

        res = solution2_2.knapsack(w, wt, val);
        System.out.println("solution2_2: " + res);

        res = solution2_3.knapsack(w, wt, val);
        System.out.println("solution2_3: " + res);

        res = solution3.knapsack(w, wt, val);
        System.out.println("solution3:   " + res);
    }


    private static class Solution1_1 {

        public int knapsack(int w, int[] wt, int[] val){
            return knapsack(wt, val, wt.length-1, w);
        }

        public int knapsack(int[] wt, int[] val, int n, int cap) {
            if (cap <= 0 || n < 0) {
                return 0;
            }
            int v1 = 0;
            if (wt[n] <= cap) {
                v1 = val[n] + knapsack(wt, val, n-1, cap-wt[n]);
            }
            int v2 = knapsack(wt, val, n-1, cap);
            return Math.max(v1, v2);
        }
    }

    private static class Solution1_2 {
        public int knapsack(int w, int[] wt, int[] val){
            int[][] dp = new int[wt.length+1][w+1];
            for (int i = 1; i <= wt.length; i++) {
                int index = i - 1;
                for (int j = 1; j <= w; j++) {
                    if (j >= wt[index]) {
                        dp[i][j] = Math.max(dp[i-1][j], val[index] + dp[i-1][j - wt[index]]);
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            return dp[wt.length][w];
        }
    }


    private static class Solution1_3 {
        public int knapsack(int w, int[] wt, int[] val){
            int[] dp = new int[w+1];
            for (int i = 0; i < wt.length; i++) {
                for (int j = w; j >= wt[i]; j--) {
                    dp[j] = Math.max(dp[j], val[i] + dp[j - wt[i]]);
                }
            }
            return dp[w];
        }
    }

    private static class Solution2_1 {

        public int knapsack(int w, int[] wt, int[] val){
            return knapsack(wt, val, w, 0, 0);
        }

        public int knapsack(int[] wt, int[] val, int w, int n, int wSum) {
            if (wSum >= w || n >= wt.length) {
                return 0;
            }
            int v1 = 0;
            if (wt[n] + wSum <= w) {
                v1 = val[n] + knapsack(wt, val, w, n+1, wSum+wt[n]);
            }
            int v2 = knapsack(wt, val, w, n+1, wSum);
            return Math.max(v1, v2);
        }
    }

    private static class Solution2_2 {
        public int knapsack(int w, int[] wt, int[] val){
            int[][] dp = new int[wt.length+1][w+1];
            for (int i = wt.length-1; i >= 0; i--) {
                for (int j = w; j >= 0; j--) {
                    if (j <= w - wt[i]) {
                        dp[i][j] = Math.max(dp[i+1][j], val[i] + dp[i+1][j + wt[i]]);
                    } else {
                        dp[i][j] = dp[i+1][j];
                    }
                }
            }
            return dp[0][0];
        }
    }

    private static class Solution2_3 {
        public int knapsack(int w, int[] wt, int[] val){
            int[] dp = new int[w+1];
            for (int i = wt.length-1; i >= 0; i--) {
                for (int j = 0; j <= w - wt[i]; j++) {
                    dp[j] = Math.max(dp[j], val[i] + dp[j + wt[i]]);
                }
            }
            return dp[0];
        }
    }

    private static class Solution3 {
        /**
         * use two variable: available weight, items count
         * cover all situations.
         *
         * status:
         * dp[...] = value sum
         * every item can be used at most 1 times
         * so, dp[items count][available weight] = value sum
         *
         * select:
         * select item, or
         * unselect item
         *
         * @param w -
         * @param wt -
         * @param val -
         * @return -
         */
        public int knapsack(int w, int[] wt, int[] val){
            int[][] dp = new int[wt.length+1][w+1];
            for (int i = 1; i <= wt.length; i++) {
                int index = i - 1;
                for (int j = 1; j <= w; j++) {
                    if (j >= wt[index]) {
                        dp[i][j] = Math.max(dp[i-1][j], val[index] + dp[i-1][j - wt[index]]);
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            return dp[wt.length][w];
        }
    }
}