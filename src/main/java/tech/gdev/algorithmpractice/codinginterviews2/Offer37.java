package tech.gdev.algorithmpractice.codinginterviews2;

import tech.gdev.algorithmpractice.leetcode.tree.binarytree.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;


/**
 * 37
 * Hard
 *
 * @author gdev
 * @date 2022/5/30 15:50
 */
public class Offer37 {

    private static class Solution1 {
        public class Codec {

            private static final String NULL_STR = "null";
            private static final String SEPARATOR = ",";

            /**
             * Encodes a tree to a single string.
             *
             * time: O(N)
             * space: O(N)
             *
             * @param root -
             * @return -
             */
            public String serialize(TreeNode root) {
                if (root == null) {return NULL_STR;}
                StringBuilder sb = new StringBuilder();
                serialize(root, sb);
                return sb.substring(0, sb.length()-1);
            }

            private void serialize(TreeNode root, StringBuilder sb) {
                if (root == null) {
                    sb.append(NULL_STR);
                    sb.append(SEPARATOR);
                    return;
                }
                sb.append(root.val);
                sb.append(SEPARATOR);
                serialize(root.left, sb);
                serialize(root.right, sb);
            }

            /**
             * Decodes your encoded data to tree.
             * time: O(N)
             * space: O(N)
             *
             * @param data -
             * @return -
             */
            public TreeNode deserialize(String data) {
                if (NULL_STR.equals(data)) {return null;}
                String[] arr = data.split(SEPARATOR);
                index = 0;
                return deserialize(arr);
            }

            private int index;

            public TreeNode deserialize(String[] arr) {
                if (index >= arr.length || NULL_STR.equals(arr[index])) {
                    index++;
                    return null;
                }
                TreeNode root = new TreeNode(Integer.parseInt(arr[index++]));
                root.left = deserialize(arr);
                root.right = deserialize(arr);
                return root;
            }
        }
    }

    private static class Solution2 {
        public class Codec {

            private static final String NULL_STR = "null";
            private static final String SEPARATOR = ",";

            /**
             * Encodes a tree to a single string.
             *
             * time: O(N)
             * space: O(N)
             *
             * @param root -
             * @return -
             */
            public String serialize(TreeNode root) {
                if (root == null) {return NULL_STR;}
                StringBuilder sb = new StringBuilder();
                Queue<TreeNode> queue = new ArrayDeque<>();
                queue.offer(root);
                TreeNode nullNode = new TreeNode(-1);
                TreeNode cur;
                while (!queue.isEmpty()) {
                    cur = queue.poll();
                    if (cur == nullNode) {
                        sb.append(NULL_STR).append(SEPARATOR);
                        continue;
                    }
                    sb.append(cur.val).append(SEPARATOR);
                    queue.offer((cur.left == null) ? nullNode : cur.left);
                    queue.offer((cur.right == null) ? nullNode : cur.right);
                }
                return sb.substring(0, sb.length()-1);
            }

            /**
             * Decodes your encoded data to tree.
             *
             * time: O(N)
             * space: O(N)
             *
             * @param data -
             * @return -
             */
            public TreeNode deserialize(String data) {
                if (NULL_STR.equals(data)) {return null;}
                String[] arr = data.split(SEPARATOR);
                int index = 0;
                Queue<TreeNode> queue = new ArrayDeque<>();
                TreeNode root = new TreeNode(Integer.parseInt(arr[index++]));
                queue.offer(root);
                TreeNode cur;
                while (!queue.isEmpty()) {
                    cur = queue.poll();
                    if (!NULL_STR.equals(arr[index])) {
                        cur.left = new TreeNode(Integer.parseInt(arr[index]));
                        queue.offer(cur.left);
                    }
                    index++;
                    if (!NULL_STR.equals(arr[index])) {
                        cur.right = new TreeNode(Integer.parseInt(arr[index]));
                        queue.offer(cur.right);
                    }
                    index++;
                }
                return root;
            }
        }
    }
}
