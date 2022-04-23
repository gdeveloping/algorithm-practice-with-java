package tech.gdev.algorithmpractice.leetcode.slidingwindow.hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 239.
 * Hard
 *
 * @author gdev
 * @date 2022/4/23 22:50
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums;
        int k;
        int[] res;
        nums = new int[]{1,3,-1,-3,5,3,6,7};
        k = 3;
        Solution1 solution1 = new Solution1();
        res = solution1.maxSlidingWindow(nums, k);
        Solution2 solution2 = new Solution2();
        res = solution2.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(N)
         *
         * Runtime: 60 ms, faster than 41.41% of Java online submissions for Sliding Window Maximum.
         * Memory Usage: 144 MB, less than 22.44% of Java online submissions for Sliding Window Maximum.
         *
         * As a result elements in the deque are ordered in both sequence in array and their value. At each step the head of the deque is the max element in [i-(k-1),i]
         *
         * @param nums -
         * @param k -
         * @return -
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] res = new int[nums.length-k+1];
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                while (!deque.isEmpty() && deque.peek() < i-k+1) {
                    deque.poll();
                }
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    deque.pollLast();
                }
                deque.offer(i);
                if (i >= k-1) {
                    res[i-k+1] = nums[deque.peek()];
                }
            }
            return res;
        }
    }

    private static class Solution2 {
        /**
         * time: O(N)
         * space: O(N)
         *
         * Runtime: 17 ms, faster than 97.17% of Java online submissions for Sliding Window Maximum.
         * Memory Usage: 137 MB, less than 67.97% of Java online submissions for Sliding Window Maximum.
         *
         * @param nums -
         * @param k -
         * @return -
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            final int[] maxLeft = new int[nums.length];
            final int[] maxRight = new int[nums.length];
            maxLeft[0] = nums[0];
            maxRight[nums.length-1] = nums[nums.length-1];
            for (int i = 1; i < nums.length; i++) {
                maxLeft[i] = (i % k == 0) ? nums[i] : Math.max(maxLeft[i-1], nums[i]);
                int j = nums.length - i - 1;
                maxRight[j] = ((j+1) % k == 0) ? nums[j] : Math.max(maxRight[j+1], nums[j]);
            }
            int[] slidingMax = new int[nums.length - k + 1];
            for (int i = k-1, j = 0; i < nums.length; i++, j++) {
                slidingMax[j] = Math.max(maxLeft[i], maxRight[j]);
            }
            return slidingMax;
        }
    }
}
