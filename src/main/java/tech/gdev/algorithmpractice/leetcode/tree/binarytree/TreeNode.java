package tech.gdev.algorithmpractice.leetcode.tree.binarytree;

/**
 * @author gdev
 * @date 2022/4/17 23:32
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
