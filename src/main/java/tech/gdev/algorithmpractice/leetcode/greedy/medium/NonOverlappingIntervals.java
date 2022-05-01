package tech.gdev.algorithmpractice.leetcode.greedy.medium;

import java.util.Arrays;

/**
 * 435.
 * Medium
 *
 * @author gdev
 * @date 2022/5/1 09:54
 */
public class NonOverlappingIntervals {

    public static void main(String[] args) {
        test1(new int[][]{{1,2},{2,3},{3,4},{1,3}}, 1);
        test1(new int[][]{{1,2},{1,2},{1,2}}, 2);
    }

    private static void test1(int[][] intervals, int output) {
        Solution1 solution1 = new Solution1();
        int res = solution1.eraseOverlapIntervals(intervals);
        System.out.println(res + "\t" + (res == output));
    }

    private static class Solution1 {
        /**
         * time: O(N*logN) sort
         * space: O(1)
         *
         * Runtime: 76 ms, faster than 65.76% of Java online submissions for Non-overlapping Intervals.
         * Memory Usage: 106.1 MB, less than 8.15% of Java online submissions for Non-overlapping Intervals.
         *
         * In order to obtain more intervals,
         * we want the end of the interval to be as small as possible.
         *
         * @param intervals -
         * @return -
         */
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
            int cur = 0;
            int count = 1;
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[cur][1] <= intervals[i][0]) {
                    count++;
                    cur = i;
                }
            }
            return intervals.length - count;
        }
    }
}
