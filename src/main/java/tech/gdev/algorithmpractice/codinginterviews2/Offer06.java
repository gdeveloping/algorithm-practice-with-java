package tech.gdev.algorithmpractice.codinginterviews2;

import tech.gdev.algorithmpractice.leetcode.linkedlist.single.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 06
 * Easy
 *
 * @author gdev
 * @date 2022/5/24 21:19
 */
public class Offer06 {

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(N)
         *
         * @param head -
         * @return -
         */
        public int[] reversePrint(ListNode head) {
            Deque<Integer> stack = new ArrayDeque<>();
            while (head != null) {
                stack.push(head.val);
                head = head.next;
            }
            int[] arr = new int[stack.size()];
            int i = 0;
            while (!stack.isEmpty()) {
                arr[i++] = stack.pop();
            }
            return arr;
        }
    }

    private static class Solution2 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * @param head -
         * @return -
         */
        public int[] reversePrint(ListNode head) {
            ListNode curr = head;
            int count = 0;
            while (curr != null) {
                count++;
                curr = curr.next;
            }
            int[] arr = new int[count];
            curr = head;
            while (curr != null) {
                arr[--count] = curr.val;
                curr = curr.next;
            }
            return arr;
        }
    }
}
