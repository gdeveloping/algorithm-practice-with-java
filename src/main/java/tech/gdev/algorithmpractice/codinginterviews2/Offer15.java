package tech.gdev.algorithmpractice.codinginterviews2;

/**
 * 15
 * Easy
 *
 * @author gdev
 * @date 2022/5/26 16:09
 */
public class Offer15 {

    private static class Solution1 {
        /**
         * time: O(1)
         * space: O(1)
         *
         * @param n -
         * @return -
         */
        public int hammingWeight(int n) {
            int count = 0;
            int flag = 1;
            while (flag != 0) {
                if ((n & flag) != 0) {
                    count++;
                }
                flag = flag << 1;
            }
            return count;
        }
    }

    private static class Solution2 {
        /**
         * time: O(1)
         * space: O(1)
         *
         * @param n -
         * @return -
         */
        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0) {
                n = n & (n-1);
                count++;
            }
            return count;
        }
    }
}
