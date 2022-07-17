package tech.gdev.algorithmpractice.codinginterviews2;

import java.util.*;

/**
 * 57II
 * Easy
 *
 * @author gdev
 * @date 2022/7/17 10:42
 */
public class Offer57II {
    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        int target = 9;
        int[][] res = s1.findContinuousSequence(target);
        System.out.println(Arrays.deepToString(res));
    }

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         * modify source: N
         *
         * @param target -
         * @return -
         */
        public int[][] findContinuousSequence(int target) {
            if (target < 3) {
                return new int[0][0];
            }
            List<int[]> list = new ArrayList<>();
            int low = 1;
            int high = 2;
            int sum = 1 + 2;
            int len = 2;
            while (len > 1) {
                if (sum == target) {
                    int[] arr = new int[len];
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = low + i;
                    }
                    list.add(arr);
                    sum = sum + (++high) - (low++);
                } else if (sum < target) {
                    sum += ++high;
                    ++len;
                } else {
                    sum -= (low++);
                    --len;
                }
            }
            return list.toArray(new int[0][]);
        }
    }
}
