package tech.gdev.algorithmpractice.leetcode.stack.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 402.
 * Medium
 *
 * @author gdev
 * @date 2022/4/17 22:20
 */
public class RemoveKDigits {

    public static void main(String[] args) {
        String[] nums = new String[]{"1432219", "10200", "10", "10001"};
        int[] kArr = new int[]{3, 1, 2, 4};
        Solution1 solution1 = new Solution1();
        for (int i = 0; i < nums.length; i++) {
            System.out.println(solution1.removeKdigits(nums[i], kArr[i]));
        }
        System.out.println("***");

//        BadAttempt badAttempt = new BadAttempt();
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(badAttempt.removeKdigits(nums[i], kArr[i]));
//        }
    }

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(N)
         *
         * Runtime: 9 ms, faster than 84.23% of Java online submissions for Remove K Digits.
         * Memory Usage: 43.1 MB, less than 76.18% of Java online submissions for Remove K Digits.
         *
         * abcde
         * delete c if c > d
         * 13521
         * delete 5 for 5 > 2
         * 1321
         * delete 3 for 3 > 2
         * 121
         *
         * @param num -
         * @param k -
         * @return -
         */
        public String removeKdigits(String num, int k) {
            if (k == num.length()) return "0";
            int i = 0;
            Deque<Character> deque = new ArrayDeque<>(num.length());
            while (i < num.length()) {
                while (k > 0 && !deque.isEmpty() && deque.peek() > num.charAt(i)) {
                    deque.pop();
                    k--;
                }
                deque.push(num.charAt(i++));
            }
            while (k-- > 0) {
                deque.pop();
            }
            while (!deque.isEmpty() && deque.peekLast() == '0') {
                deque.pollLast();
            }
            StringBuilder sb = new StringBuilder();
            while (!deque.isEmpty()) {
                sb.append(deque.pollLast());
            }
            return sb.length() == 0 ? "0" : sb.toString();
        }
    }

    private static class BadAttempt {
        /**
         * Time Limit Exceeded
         *
         * time: O(KN)
         * space: O(N)
         *
         * @param num -
         * @param k -
         * @return -
         */
        public String removeKdigits(String num, int k) {
            if (k == num.length()) return "0";
            StringBuilder sb = new StringBuilder(num);
            while (k > 0) {
                int i = 0;
                while (i < sb.length()-1 && sb.charAt(i) <= sb.charAt(i+1)) {
                    i++;
                }
                sb.deleteCharAt(i);
                k--;
            }
            while (!(sb.length() == 0) && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }
            return sb.length() == 0 ? "0" : sb.toString();
        }
    }
}
