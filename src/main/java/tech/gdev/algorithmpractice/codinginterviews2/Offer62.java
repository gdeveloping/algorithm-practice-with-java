package tech.gdev.algorithmpractice.codinginterviews2;

/**
 * 62
 * Easy
 *
 * @author gdev
 * @date 2022/7/24 18:29
 */
public class Offer62 {
    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         * modify source: N
         *
         * link:
         * https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/
         * https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/jian-zhi-offer-62-yuan-quan-zhong-zui-ho-dcow/
         *
         * @param n -
         * @param m -
         * @return -
         */
        public int lastRemaining(int n, int m) {
            int last = 0;
            for (int i = 2; i <= n; i++) {
                last = (last + m) % i;
            }
            return last;
        }
    }
}
