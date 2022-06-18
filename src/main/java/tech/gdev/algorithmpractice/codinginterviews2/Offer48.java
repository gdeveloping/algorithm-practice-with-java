package tech.gdev.algorithmpractice.codinginterviews2;

/**
 * 48
 * Medium
 *
 * @author gdev
 * @date 2022/6/18 21:30
 */
public class Offer48 {

    private static class Solution1 {
        /**
         * time: O(N), N:len(s)
         * space: O(1)
         * modify source: N
         *
         * @param s -
         * @return -
         */
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {return 0;}
            int[] arr = new int[128];
            int left, right;
            left = right = 0;
            int size = s.length();
            int res = 0;
            int count = 0;
            while (right < size) {
                arr[s.charAt(right)] += 1;
                count++;
                while (arr[s.charAt(right)] > 1) {
                    arr[s.charAt(left)]--;
                    left++;
                    count--;
                }
                res = Math.max(res, count);
                right++;
            }
            return res;
        }
    }

    private static class Solution2 {
        /**
         * time: O(N^2)
         * space: O(1)
         * modify source: N
         *
         * @param s -
         * @return -
         */
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {return 0;}
            int res = 0;
            int pre = 0;
            int cur;
            for (int i = 0; i < s.length(); i++) {
                int j = i - 1;
                while (j >= 0 && s.charAt(i) != s.charAt(j)) {j--;}
                cur = pre < i - j ? pre + 1 : i - j;
                pre = cur;
                res = Math.max(res, cur);
            }
            return res;
        }
    }
}
