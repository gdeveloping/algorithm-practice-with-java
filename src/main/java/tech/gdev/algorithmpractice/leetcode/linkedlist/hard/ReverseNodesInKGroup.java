package tech.gdev.algorithmpractice.leetcode.linkedlist.hard;

import tech.gdev.algorithmpractice.leetcode.linkedlist.single.ListNode;

import java.util.List;

/**
 * 25.
 * Hard
 *
 * @author gdev
 * @date 2022/4/13 21:33
 */
public class ReverseNodesInKGroup {

    private static class Solution1 {
        /**
         *
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Nodes in k-Group.
         * Memory Usage: 41.8 MB, less than 92.65% of Java online submissions for Reverse Nodes in k-Group.
         *
         * a --> b --> c --> d
         * curr --> next
         *
         * count: [0, k]
         * operation times: [0, k-1]
         * operation: curr = curr.next
         * now: curr --> k+1 node
         *
         * @param head -
         * @param k -
         * @return -
         */
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode next = head;
            int count = 0;
            // k+1 node
            while (next != null && count != k) {
                next = next.next;
                count++;
            }
            if (count != k) {return head;}
            ListNode pre = reverseKGroup(next, k);
            ListNode curr = head;
            while (count-- > 0) {
                next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
            return pre;
        }
    }

    private static class Solution2 {

        /**
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Nodes in k-Group.
         * Memory Usage: 42 MB, less than 87.66% of Java online submissions for Reverse Nodes in k-Group.
         *
         * @param head -
         * @param k -
         * @return -
         */
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null || k == 1) {
                return head;
            }
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode preHead = dummy;
            int i = 0;
            while (head != null) {
                i++;
                if (i % k == 0) {
                    head = reverseKGroup(preHead, head.next);
                    preHead = head;
                }
                head = head.next;
            }
            return dummy.next;
        }

        private ListNode reverseKGroup(ListNode preHead, ListNode tailNext) {
            ListNode curr = preHead.next;
            ListNode head = curr;
            ListNode prev = preHead;
            ListNode next;
            while (curr != tailNext) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            preHead.next = prev;
            head.next = tailNext;
            return head;
        }
    }
}
