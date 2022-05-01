package tech.gdev.algorithmpractice.leetcode.greedy.medium;

import java.util.Arrays;

/**
 * 452.
 * Medium
 *
 * @author gdev
 * @date 2022/5/1 09:02
 */
public class MinimumNumberOfArrowsToBurstBalloons {

    public static void main(String[] args) {
        test1(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}, 2);
        test1(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}, 4);
        test1(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}, 2);
        test1(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}}, 2);

        System.out.println();
        test1b(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}, 2);
        test1b(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}, 4);
        test1b(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}, 2);
        test1b(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}}, 2);

    }

    private static void test1(int[][] points, int output) {
        Solution1 solution1 = new Solution1();
        int res = solution1.findMinArrowShots(points);
        System.out.println(res + "\t" + (res == output));
    }

    private static void test1b(int[][] points, int output) {
        Solution1b solution1b = new Solution1b();
        int res = solution1b.findMinArrowShots(points);
        System.out.println(res + "\t" + (res == output));
    }

    private static class Solution1 {
        /**
         * time: O(N*logN) sort
         * space: O(1)
         *
         * Runtime: 93 ms, faster than 39.22% of Java online submissions for Minimum Number of Arrows to Burst Balloons.
         * Memory Usage: 96.1 MB, less than 57.16% of Java online submissions for Minimum Number of Arrows to Burst Balloons.
         *
         * We know that eventually we have to shoot down every balloon,
         * so for each ballon there must be an arrow whose position is between balloon[0] and balloon[1] inclusively.
         * Given that, we can sort the array of balloons by their ending position.
         * Then we make sure that while we take care of each balloon in order,
         * we can shoot as many following balloons as possible.
         *
         * @param points -
         * @return -
         */
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points, (o1, o2) -> ((long) o1[1] - (long) o2[1]) > 0 ? 1 : -1);
            int pos = points[0][1];
            int count = 1;
            for (int i = 1; i < points.length; i++) {
                if (points[i][0] <= pos) {
                    continue;
                }
                count++;
                pos = points[i][1];
            }
            return count;
        }
    }

    private static class Solution1b {
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points, (o1, o2) -> ((long) o1[1] - (long) o2[1]) > 0 ? 1 : -1);
            int pos = points[points.length-1][0];
            int count = 1;
            for (int i = points.length-2; i >= 0; i--) {
                if (points[i][1] >= pos) {
                    continue;
                }
                count++;
                pos = points[i][0];
            }
            return count;
        }
    }
}
