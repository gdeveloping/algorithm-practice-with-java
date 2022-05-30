package tech.gdev.algorithmpractice.codinginterviews2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 38
 * Medium
 *
 * @author gdev
 * @date 2022/5/30 11:53
 */
public class Offer38 {

    private static class Solution1 {
        /**
         * time: O(N*N!), N:sub question for loop, N!:count
         * space: O(N)
         *
         * @param s -
         * @return -
         */
        public String[] permutation(String s) {
            if (s == null || s.length() == 0) {return new String[]{""};}
            chars = s.toCharArray();
            Arrays.sort(chars);
            visited = new boolean[chars.length];
            list = new ArrayList<>();
            sb = new StringBuilder();
            backtrack();
            return list.toArray(new String[0]);
        }

        private char[] chars;
        private boolean[] visited;
        private List<String> list;
        private StringBuilder sb;

        private void backtrack() {
            if (sb.length() == chars.length) {
                list.add(sb.toString());
                return;
            }
            for (int i = 0; i < chars.length; i++) {
                if (visited[i]) {continue;}
                if (i > 0 && !visited[i-1] && chars[i] == chars[i-1]) {continue;}
                visited[i] = true;
                sb.append(chars[i]);
                backtrack();
                visited[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }


    private static class Solution2 {
        /**
         * time: O(N*N!), N:sub question, N!:count
         * space: O(N) no stack
         *
         * @param s -
         * @return -
         */
        public String[] permutation(String s) {
            if (s == null || s.length() == 0) {return new String[]{""};}
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            List<String> res = new ArrayList<>();
            do {
                res.add(new String(chars));
            } while (nextPermutation(chars));
            return res.toArray(new String[0]);
        }

        private boolean nextPermutation(char[] chars) {
            int i = chars.length - 2;
            while (i >= 0 && chars[i] >= chars[i+1]) {
                i--;
            }
            if (i < 0) {return false;}
            int j = chars.length - 1;
            while (chars[j] <= chars[i]) {
                j--;
            }
            swap(chars, i, j);
            reverse(chars, i+1);
            return true;
        }

        private void swap(char[] chars, int i, int j) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
        }

        private void reverse(char[] chars, int start) {
            int left = start, right = chars.length - 1;
            while (left < right) {
                swap(chars, left, right);
                left++; right--;
            }
        }
    }
}
