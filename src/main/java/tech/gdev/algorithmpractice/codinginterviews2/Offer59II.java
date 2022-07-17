package tech.gdev.algorithmpractice.codinginterviews2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 59II
 * Medium
 *
 * @author gdev
 * @date 2022/7/17 11:53
 */
public class Offer59II {
    private static class MaxQueue {
        Deque<Integer> nums;
        Deque<Integer> maxValues;

        public MaxQueue() {
            nums = new ArrayDeque<>();
            maxValues = new ArrayDeque<>();
        }

        public int max_value() {
            if (nums.isEmpty()) {
                return -1;
            }
            return maxValues.peekFirst();
        }

        public void push_back(int value) {
            while (!maxValues.isEmpty() && maxValues.peekLast() < value) {
                maxValues.pollLast();
            }
            nums.offerLast(value);
            maxValues.offerLast(value);
        }

        public int pop_front() {
            if (nums.isEmpty()) {
                return -1;
            }
            int num = nums.pollFirst();
            if (num == maxValues.peekFirst()) {
                maxValues.pollFirst();
            }
            return num;
        }
    }
}
