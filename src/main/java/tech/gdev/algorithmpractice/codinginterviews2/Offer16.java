package tech.gdev.algorithmpractice.codinginterviews2;

/**
 * 16
 * Medium
 *
 * @author gdev
 * @date 2022/5/26 17:08
 */
public class Offer16 {

    private static class Solution1 {
        /**
         * time: O(log(N))
         * space: O(log(N)) stack
         *
         * @param x -
         * @param n -
         * @return -
         */
        public double myPow(double x, int n) {
            if (x == 0) {return 0;}
            if (n == 0) {return 1;}
            if (n == 1) {return x;}
            if (x == 1) {return 1;}

            long exponent = (n < 0) ? -1L * n : n;
            double res = helper(x, exponent);
            if (n < 0) {res = 1.0 / res;}
            return res;
        }

        private double helper(double x, long exponent) {
            if (exponent == 0) {return 1;}
            if (exponent == 1) {return x;}

            double res = helper(x, exponent >> 1);
            res *= res;
            if ((exponent & 1) == 1) {
                res *= x;
            }
            return res;
        }
    }

    private static class Solution2 {
        /**
         * time: O(log(N))
         * space: O(1)
         *
         * Binary
         *
         * @param x -
         * @param n -
         * @return -
         */
        public double myPow(double x, int n) {
            if (x == 0) {return 0;}
            if (n == 0) {return 1;}
            if (n == 1) {return x;}
            if (x == 1) {return 1;}

            double res = 1;
            long exponent = (n < 0) ? -1L * n : n;
            double contribute = x;
            while (exponent > 0) {
                if ((exponent & 1) == 1) {
                    res *= contribute;
                }
                contribute *= contribute;
                exponent = exponent >> 1;
            }
            if (n < 0) {res = 1.0 / res;}

            return res;
        }
    }
}
