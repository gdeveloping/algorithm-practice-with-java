package tech.gdev.algorithmpractice.codinginterviews2;

import java.util.PriorityQueue;

/**
 * 41
 * Hard
 *
 * @author gdev
 * @date 2022/6/2 21:33
 */
public class Offer41 {

    class MedianFinder {
        private PriorityQueue<Integer> min;
        private PriorityQueue<Integer> max;

        /** initialize your data structure here. */
        public MedianFinder() {
            min = new PriorityQueue<>();
            max = new PriorityQueue<>((o1, o2) -> o2 - o1);
        }

        /**
         * time: O(log(N))
         * space: O(N)
         *
         * @param num -
         */
        public void addNum(int num) {
            if (min.isEmpty()) {
                min.offer(num);
                return;
            }
            if (num >= min.peek()) {
                min.offer(num);
            } else {
                max.offer(num);
            }
            int n = min.size() - max.size();
            if (n == 0) {
                return;
            } else if (n < 0) {
                min.offer(max.poll());
            } else if (n > 1) {
                max.offer(min.poll());
            }

//            if (min.size() <= max.size()) {
//                max.offer(num);
//                min.offer(max.poll());
//            } else {
//                min.offer(num);
//                max.offer(min.poll());
//            }
        }

        /**
         * time: O(1)
         * space: O(N)
         *
         * @return -
         */
        public double findMedian() {
            if (min.size() > max.size()) {
                return min.peek();
            }
            int left = min.peek();
            int right = max.peek();
            return (left * 1.0 + right) / 2.0;
        }
    }
}
