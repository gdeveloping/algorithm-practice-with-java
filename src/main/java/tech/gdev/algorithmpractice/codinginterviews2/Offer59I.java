package tech.gdev.algorithmpractice.codinginterviews2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 59 I
 * Hard
 *
 * @author gdev
 * @date 2022/6/19 11:18
 */
public class Offer59I {

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(K)
         * modify source: N
         *
         * @param nums -
         * @param k -
         * @return -
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k < 1) {return new int[0];};
            int size = nums.length;
            int[] res = new int[size - k + 1];
            Deque<Integer> deque = new ArrayDeque<>(k);
            for (int i = 0; i < k - 1; i++) {
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {deque.pollLast();}
                deque.offerLast(i);
            }
            for (int i = k - 1; i <= size; i++) {
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
                res[i - k + 1] = nums[deque.peekFirst()];
                if (i - k + 1 == deque.peekFirst()) {deque.pollFirst();}
            }
            return res;
        }
    }

    private static class Solution2 {
        /**
         * time: O(N*log(K))
         * space: O(K)
         * modify source: N
         *
         * @param nums -
         * @param k -
         * @return -
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k < 1) {return new int[0];};
            int size = nums.length;
            int[] res = new int[size - k + 1];
            PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];});
            for (int i = 0; i < k - 1; i++) {
                queue.offer(new int[]{nums[i], i});
            }
            for (int i = k - 1; i < size; i++) {
                queue.offer(new int[]{nums[i], i});
                while (!queue.isEmpty() && queue.peek()[1] < i - k + 1) {queue.poll();}
                res[i - k + 1] = queue.peek()[0];
            }
            return res;
        }
    }
}
