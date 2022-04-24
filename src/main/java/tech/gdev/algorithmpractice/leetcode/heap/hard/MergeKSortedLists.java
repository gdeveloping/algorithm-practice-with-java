package tech.gdev.algorithmpractice.leetcode.heap.hard;

import tech.gdev.algorithmpractice.leetcode.linkedlist.single.ListNode;

import java.util.PriorityQueue;

/**
 * 23.
 * Hard
 *
 * @author gdev
 * @date 2022/4/24 21:19
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        int[][] nums;
        nums = new int[][]{{1,4,5},{1,3,4},{2,6}};
        ListNode[] lists = new ListNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ListNode dummy = new ListNode();
            ListNode tail = dummy;
            for (int j = 0; j < nums[i].length; j++) {
                tail.next = new ListNode(nums[i][j]);
                tail = tail.next;
            }
            lists[i] = dummy.next;
        }
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            while (node != null) {
                System.out.printf("%3d", node.val);
                node = node.next;
            }
            System.out.println();
        }
        Solution2 solution2 = new Solution2();
        ListNode node = solution2.mergeKLists(lists);
        while (node != null) {
            System.out.printf("%3d", node.val);
            node = node.next;
        }
    }

    private static class Solution1 {
        /**
         * time: O(log(K)N)
         * space: O(K)
         *
         * Runtime: 5 ms, faster than 73.01% of Java online submissions for Merge k Sorted Lists.
         * Memory Usage: 47.5 MB, less than 43.01% of Java online submissions for Merge k Sorted Lists.
         *
         * @param lists -
         * @return -
         */
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length < 1) {return null;}
            PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a,b) -> a.val - b.val);
            ListNode dummy = new ListNode();
            ListNode tail = dummy;
            for (ListNode node : lists) {
                if (node != null) {
                    queue.offer(node);
                }
            }
            while (!queue.isEmpty()) {
                tail.next = queue.poll();
                tail = tail.next;
                if (tail.next != null) {
                    queue.offer(tail.next);
                }
            }
            return dummy.next;
        }
    }

    private static class Solution2 {
        /**
         * time: O(log(K)N)
         * space: O(N)
         *
         * Runtime: 1 ms, faster than 100.00% of Java online submissions for Merge k Sorted Lists.
         * Memory Usage: 44.6 MB, less than 75.65% of Java online submissions for Merge k Sorted Lists.
         *
         * @param lists -
         * @return -
         */
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length < 1) {return null;}
            return mergeKLists(lists, 0, lists.length-1);
        }

        private ListNode mergeKLists(ListNode[] lists, int left, int right) {
            if (left == right) {return lists[left];}
            int mid = (left + right) / 2;
            ListNode l1 = mergeKLists(lists, left, mid);
            ListNode l2 = mergeKLists(lists, mid+1, right);
            return mergeTwoLists(l1, l2);
        }

        private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode();
            ListNode tail = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    tail.next = l1;
                    l1 = l1.next;
                } else {
                    tail.next = l2;
                    l2 = l2.next;
                }
                tail = tail.next;
            }
            tail.next = (l1 != null) ? l1 : l2;
            return dummy.next;
        }
    }
}
