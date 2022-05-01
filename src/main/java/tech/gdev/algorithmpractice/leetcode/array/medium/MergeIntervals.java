package tech.gdev.algorithmpractice.leetcode.array.medium;

import java.util.*;

/**
 * 56.
 * Medium
 *
 * @author gdev
 * @date 2022/5/1 10:22
 */
public class MergeIntervals {
    public static void main(String[] args) {
        test1(new int[][]{{1,3},{2,6},{8,10},{15,18}}, "[[1,6],[8,10],[15,18]]");
        test1(new int[][]{{1,4},{4,5}}, "[[1,5]]");
        test1(new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}}, "[[1,10]]");

        System.out.println();
        test2(new int[][]{{1,3},{2,6},{8,10},{15,18}}, "[[1,6],[8,10],[15,18]]");
        test2(new int[][]{{1,4},{4,5}}, "[[1,5]]");
        test2(new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}}, "[[1,10]]");
    }

    private static void test1(int[][] intervals, String output) {
        System.out.println();
        Solution1 solution1 = new Solution1();
        int[][] res = solution1.merge(intervals);
        System.out.println("source: " + Arrays.deepToString(intervals));
        System.out.println("res: " + Arrays.deepToString(res));
        System.out.println("output: " + output);
    }

    private static void test2(int[][] intervals, String output) {
        System.out.println();
        Solution2 solution2 = new Solution2();
        int[][] res = solution2.merge(intervals);
        System.out.println("source: " + Arrays.deepToString(intervals));
        System.out.println("res: " + Arrays.deepToString(res));
        System.out.println("output: " + output);
    }

    private static class Solution1 {
        /**
         * time: O(N*logN) sort
         * space: O(N)
         *
         * Runtime: 14 ms, faster than 41.14% of Java online submissions for Merge Intervals.
         * Memory Usage: 55.7 MB, less than 18.30% of Java online submissions for Merge Intervals.
         *
         * @param intervals -
         * @return -
         */
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
            int[] cur = intervals[0];
            Queue<int[]> queue = new ArrayDeque<>();
            for (int i = 1; i < intervals.length; i++) {
                if (cur[1] >= intervals[i][0]) {
                    cur[1] = Math.max(cur[1], intervals[i][1]);
                } else {
                    queue.offer(cur);
                    cur = intervals[i];
                }
            }
            queue.offer(cur);
            return queue.toArray(new int[queue.size()][2]);
        }

    }
    
    private static class Solution2 {
        /**
         * time: O(N)
         * space: O(N)
         *
         * Runtime: 11 ms, faster than 69.60% of Java online submissions for Merge Intervals.
         * Memory Usage: 46.9 MB, less than 94.05% of Java online submissions for Merge Intervals.
         *
         * @param intervals -
         * @return -
         */
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
            int[] cur = intervals[0].clone();
            Deque<int[]> stack = new ArrayDeque<>();
            for (int i = 1; i <= intervals.length; i++) {
                if (i == intervals.length || cur[1] < intervals[i][0]) {
                    while (!stack.isEmpty()) {
                        int[] pre = stack.pop();
                        if (pre[1] >= cur[0]) {
                            cur[0] = Math.min(pre[0], cur[0]);
                            cur[1] = Math.max(pre[1], cur[1]);
                        } else {
                            stack.push(pre);
                            break;
                        }
                    }
                    stack.push(cur.clone());
                    if (i == intervals.length) {break;}
                    cur = intervals[i].clone();
                } else {
                    cur[0] = Math.min(cur[0], intervals[i][0]);
                    cur[1] = Math.max(cur[1], intervals[i][1]);
                }
            }
            int[][] res = new int[stack.size()][2];
            int i = stack.size()-1;
            while (!stack.isEmpty()) {
                res[i--] = stack.pop();
            }
            return res;
        }

    }
}
