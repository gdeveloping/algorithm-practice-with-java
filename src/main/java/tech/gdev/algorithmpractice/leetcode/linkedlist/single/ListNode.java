package tech.gdev.algorithmpractice.leetcode.linkedlist.single;

/**
 * @author gdev
 * @date 2022/4/11 21:10
 */
public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}