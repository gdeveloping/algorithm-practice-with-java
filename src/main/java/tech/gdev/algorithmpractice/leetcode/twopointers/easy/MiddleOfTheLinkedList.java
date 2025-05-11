package tech.gdev.algorithmpractice.leetcode.twopointers.easy;

import tech.gdev.algorithmpractice.leetcode.linkedlist.single.ListNode;
import tech.gdev.algorithmpractice.utils.ListNodeUtil;

/**
 * 876.
 * Easy
 * Middle of the Linked List
 *
 * @author gdev
 * @date 1/5/2025 11:01
 */
public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        testSolution1(new int[]{1, 2, 3, 4, 5}); // 3
        testSolution1(new int[]{1, 2, 3, 4, 5, 6}); // 4
    }

    private static void testSolution1(int[] arr) {
        System.out.println("\n***");
        ListNode node = ListNodeUtil.convertArrayToListNode(arr);
        ListNode res = new Solution1().middleNode(node);
        System.out.println(res.val);
    }

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * time: 0ms, 100.00%
         * space: 40.31MB, 51.50%
         *
         * fast 的步长为 2，路径轨迹为 1、3、5，...。
         * slow 的步长为 1，路径轨迹为 1、2、3，...。
         * 当节点数量 n 为奇数时，触发约束条件 (fast.next != null)，slow 表示中点。
         * 当节点数量 n 为偶数时，触发约束条件 (fast != null)，slow 表示 (n+1) 个节点的中点，也是 n 个节点的两个中点节点中的第二个节点。
         * 示例如下：
         *
         * src: node1 node2 node3
         * fast: node3, break (fast.next != null)
         * slow: node2
         *
         * src: node1 node2 node3 node4
         * fast: null, break(fast != null)
         * slow: node2
         */
        public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
