package tech.gdev.algorithmpractice.codinginterviews2;

/**
 * 05
 * Easy
 *
 * @author gdev
 * @date 2022/5/24 21:02
 */
public class Offer05 {

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(N)
         *
         * @param s -
         * @return -
         */
        public String replaceSpace(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }
            int count = 0;
            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    count++;
                }
            }
            char[] arr = new char[s.length() + 2*count];
            int i = 0;
            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    arr[i++] = '%';
                    arr[i++] = '2';
                    arr[i++] = '0';
                } else {
                    arr[i++] = c;
                }
            }
            return new String(arr);
        }
    }
}
