package tech.gdev.algorithmpractice.codinginterviews2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 50
 * Easy
 *
 * @author gdev
 * @date 2022/6/18 23:31
 */
public class Offer50 {

    private static class Solution1 {
        /**
         * time: 100%
         * space: 67.29%
         *
         * time: O(N)
         * space: O(1)
         * modify source: N
         *
         * @param s -
         * @return -
         */
        public char firstUniqChar(String s) {
            int index = s.length();
            char res = ' ';
            for (int i = 'a'; i <= 'z'; i++) {
                int cur = s.indexOf((char)i);
                if (cur != -1 && cur == s.lastIndexOf((char)i) && cur < index) {
                    index = cur;
                    res = (char) i;
                }
            }
            return res;
        }
    }

    private static class Solution2 {
        /**
         * time: O(N)
         * space: O(1)
         * modify source: N
         *
         * @param s -
         * @return -
         */
        public char firstUniqChar(String s) {
            Map<Character, Boolean> map = new LinkedHashMap<>();
            for (char c : s.toCharArray()) {
                map.put(c, !map.containsKey(c));
            }
            for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
                if (entry.getValue()) {return entry.getKey();}
            }
            return ' ';
        }
    }

    private static class Solution3 {
        /**
         * time: O(N)
         * space: O(1)
         * modify source: N
         *
         * @param s -
         * @return -
         */
        public char firstUniqChar(String s) {
            Map<Character, Boolean> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                map.put(c, !map.containsKey(c));
            }
            for (char c : s.toCharArray()) {
                if (map.get(c)) {return c;}
            }
            return ' ';
        }
    }
}
