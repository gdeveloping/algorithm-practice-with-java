package tech.gdev.algorithmpractice.leetcode.tree.medium;

import tech.gdev.algorithmpractice.leetcode.tree.binarytree.TreeNode;

/**
 * 450.
 * Medium
 *
 * @author gdev
 * @date 2022/5/3 17:54
 */
public class DeleteNodeInABst {

    private static class Solution1 {
        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a BST.
         * Memory Usage: 42.7 MB, less than 81.81% of Java online submissions for Delete Node in a BST.
         *
         * @param root -
         * @param key -
         * @return -
         */
        public TreeNode deleteNode(TreeNode root, int key) {
            parent = target = null;

            // find key
            dfs(root, key, null);

            // not found
            if (target == null) {return root;}

            // found
            TreeNode curr;
            if (target.left == null) {
                curr = target.right;
            } else if (target.right == null) {
                curr = target.left;
            } else {
                TreeNode p = target.right;
                while (p.left != null) {
                    p = p.left;
                }
                p.left = target.left;
                curr = target.right;
            }

            if (parent == null) {
                // root.val equals key
                return curr;
            } else {
                if (target.equals(parent.left)) {
                    parent.left = curr;
                } else {
                    parent.right = curr;
                }
                return root;
            }
        }

        private TreeNode parent;
        private TreeNode target;

        private void dfs(TreeNode root, int key, TreeNode pre) {
            if (root == null) {return;}
            if (target != null) {return;}
            if (root.val == key) {
                parent = pre;
                target = root;
                return;
            }
            dfs(root.left, key, root);
            dfs(root.right, key, root);
        }
    }

    private static class Solution2 {
        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a BST.
         * Memory Usage: 49.3 MB, less than 63.64% of Java online submissions for Delete Node in a BST.
         *
         * @param root -
         * @param key -
         * @return -
         */
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {return null;}
            if (key < root.val) {
                root.left = deleteNode(root.left, key);
                return root;
            } else if (key > root.val) {
                root.right = deleteNode(root.right, key);
                return root;
            } else {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                } else {
                    TreeNode p = root.right;
                    while (p.left != null) {
                        p = p.left;
                    }
                    p.left = root.left;
                    return root.right;
                }
            }
        }
    }
}
