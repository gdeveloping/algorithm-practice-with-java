package tech.gdev.algorithmpractice.leetcode.greedy.medium;

import java.util.*;

/**
 * 621.
 * Medium
 *
 * @author gdev
 * @date 2022/5/12 22:26
 */
public class TaskScheduler {

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 6 ms, faster than 58.44% of Java online submissions for Task Scheduler.
         * Memory Usage: 60.1 MB, less than 46.63% of Java online submissions for Task Scheduler.
         *
         * @param tasks -
         * @param n -
         * @return -
         */
        public int leastInterval(char[] tasks, int n) {
            int[] arr = new int[26];
            int max = 0;
            for (char c : tasks) {
                arr[c-'A']++;
                max = Math.max(max, arr[c-'A']);
            }

            int count = 0;
            for (int num : arr) {
                if (num == max) {
                    count++;
                }
            }

            int res = (max-1) * (n+1) + count;
            res = Math.max(res, tasks.length);
            return res;
        }
    }


    private static class Solution2 {
        class Task {
            int freq = 0;
            int lastPos = -1;
            public Task(int freq) {
                this.freq = freq;
            }
        }

        /**
         * Runtime: 53 ms, faster than 26.53% of Java online submissions for Task Scheduler.
         * Memory Usage: 67.4 MB, less than 29.08% of Java online submissions for Task Scheduler.
         *
         * @param tasks -
         * @param n -
         * @return -
         */
        public int leastInterval(char[] tasks, int n) {
            Map<Character, Task> map = new HashMap<>();
            for (char c : tasks) {
                map.putIfAbsent(c, new Task(0));
                map.get(c).freq++;
            }
            PriorityQueue<Task> pq = new PriorityQueue<>((o1, o2) -> o2.freq - o1.freq);
            pq.addAll(map.values());
            Queue<Task> queue = new ArrayDeque<>(26);
            int count = 0;
            while (!pq.isEmpty() || !queue.isEmpty()) {
                if (pq.isEmpty()) {
                    count = queue.peek().lastPos + n + 1;
                }
                if (!queue.isEmpty() && queue.peek().lastPos + n < count) {
                    pq.offer(queue.poll());
                }
                Task t = pq.poll();
                t.lastPos = count++;
                t.freq--;
                if (t.freq > 0) {
                    queue.offer(t);
                }
            }
            return count;
        }
    }
}
