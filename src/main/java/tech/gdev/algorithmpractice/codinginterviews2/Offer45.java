package tech.gdev.algorithmpractice.codinginterviews2;

import java.util.Arrays;

/**
 * 45
 * Medium
 *
 * @author gdev
 * @date 2022/6/7 21:37
 */
public class Offer45 {

    private static class Solution1 {
        /**
         * time: O(Nlog(N))
         * space: O(N)
         *
         * @param nums -
         * @return -
         */
        public String minNumber(int[] nums) {
            if (nums == null || nums.length == 0) {return "";}
            String[] arr = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                arr[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(arr, (str1, str2) -> (str1 + str2).compareTo(str2 + str1));
            StringBuilder sb = new StringBuilder();
            for (String str : arr) {
                sb.append(str);
            }
            return sb.toString();
        }
    }
}
