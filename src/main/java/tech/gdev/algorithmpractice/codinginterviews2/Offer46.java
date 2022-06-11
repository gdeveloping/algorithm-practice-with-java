package tech.gdev.algorithmpractice.codinginterviews2;

/**
 * 46
 * Medium
 *
 * @author gdev
 * @date 2022/6/11 20:24
 */
public class Offer46 {

    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        int num, res;
        num = 24547;
        res = s1.translateNum(num);
        System.out.println(res);
    }

    private static class Solution1 {
        /**
         * time: O(log(N))
         * space: O(1)
         *
         * @param num -
         * @return -
         */
        public int translateNum(int num) {
            if (num < 10) {return 1;}
            int p = num % 10; // pre digit
            int q; // cur digit
            num /= 10;
            int prePre = 1; // pre pre count
            int pre = 1; // pre count
            int cur = 1; // cur count
            while (num > 0) {
                q = num % 10;
                num /= 10;
                if ((q > 0) && (q * 10 + p < 26)) {
                    cur = pre + prePre;
                }
                p = q;
                prePre = pre;
                pre = cur;
            }
            return cur;
        }
    }
}
