package tech.gdev.algorithmpractice.leetcode.segmenttree.hard;

import java.util.*;

/**
 * 315.
 * Hard
 *
 * @author gdev
 * @date 2022/4/26 22:31
 */
public class CountOfSmallerNumbersAfterSelf {

    // [10,27,10,17,12,22,28,8,19,2,12,2,9,6,12,5,17,9,19,12,14,6,12,5,12,3,0,10,0,7,8,4,0,0,4,3,2,0,1,0]
    // [10,27,10,35,12,22,28,8,19,2,12,2,9,6,12,5,17,9,19,12,14,6,12,5,12,3,0,10,0,7,8,4,0,0,4,3,2,0,1,0]
    public static void main(String[] args) {
        int[][] arrs = new int[][]{
                {5,2,6,1},
                {-1},
                {-1,-1},
                {2,0,1},
                {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41}
        };

        for (int[] nums : arrs) {
            Solution1 solution1 = new Solution1();
            List<Integer> list = solution1.countSmaller(nums);
            System.out.println(list);
        }

        System.out.println();
        for (int[] nums : arrs) {
            Solution2 solution2 = new Solution2();
            List<Integer> list = solution2.countSmaller(nums);
            System.out.println(list);
        }

        System.out.println();
        for (int[] nums : arrs) {
            Solution3 solution3 = new Solution3();
            List<Integer> list = solution3.countSmaller(nums);
            System.out.println(list);
        }
    }

    private static class Solution1 {
        private static class TreeNode {
            TreeNode left, right;
            int val;
            int leftCount;
            // the count of TreeNodes whose value is val
            int duplicate = 1;
            public TreeNode(int val) {
                this.val = val;
            }
        }

        int[] nums;
        List<Integer> res;

        /**
         * Time Limit Exceeded
         *
         * @param nums -
         * @return -
         */
        public List<Integer> countSmaller(int[] nums) {
            this.nums = nums;
            res = new ArrayList<>(nums.length);
            res.add(0);
            TreeNode root = new TreeNode(nums[nums.length-1]);
            for (int i = nums.length-2; i >= 0; i--) {
                insert(nums[i], root, 0);
            }
            Collections.reverse(res);
            return res;
        }

        private TreeNode insert(int num, TreeNode node, int preSum) {
            if (node == null) {
                node = new TreeNode(num);
                res.add(preSum);
            } else if (node.val == num) {
                node.duplicate++;
                res.add(preSum+node.leftCount);
            } else if (node.val > num) {
                node.leftCount++;
                node.left = insert(num, node.left, preSum);
            } else {
                node.right = insert(num, node.right, preSum+node.duplicate +node.leftCount);
            }
            return node;
        }
    }


    private static class Solution2 {
        private static class TreeNode {
            TreeNode left, right;
            int val;
            int leftCount;
            // the count of TreeNodes whose value is val
            int duplicate = 1;

            public TreeNode(int val) {
                this.val = val;
            }

            public TreeNode(int val, int duplicate) {
                this.val = val;
                this.duplicate = duplicate;
            }
        }

        int[] nums;
        List<Integer> res;

        /**
         * Time Limit Exceeded
         *
         * @param nums -
         * @return -
         */
        public List<Integer> countSmaller(int[] nums) {
            this.nums = nums;
            res = new ArrayList<>(nums.length);
            res.add(0);
            TreeNode root = new TreeNode(nums[nums.length - 1]);
            for (int i = nums.length - 2; i >= 0; i--) {
                insert(nums[i], root);
            }
            Collections.reverse(res);
            return res;
        }

        private void insert(int num, TreeNode node) {
            int preSum = 0;
            while (node.val != num) {
                if (node.val > num) {
                    if (node.left == null) {
                        node.left = new TreeNode(num, 0);
                    }
                    node.leftCount++;
                    node = node.left;
                } else {
                    if (node.right == null) {
                        node.right = new TreeNode(num, 0);
                    }
                    preSum = preSum + node.duplicate + node.leftCount;
                    node = node.right;
                }
            }
            node.duplicate++;
            res.add(preSum+node.leftCount);
        }
    }

    private static class Solution3 {
        /** source nums */
        private int[] nums;
        /** index of num, ordered by nums[index[k]] */
        private int[] index;
        /** auxiliary index **/
        private int[] aux;
        private int[] counter;
        List<Integer> res;

        /**
         * time: O(N*logN)
         * space: O(N)
         *
         * Runtime: 95 ms, faster than 77.17% of Java online submissions for Count of Smaller Numbers After Self.
         * Memory Usage: 120.4 MB, less than 63.08% of Java online submissions for Count of Smaller Numbers After Self.
         *
         * @param nums -
         * @return -
         */
        public List<Integer> countSmaller(int[] nums) {
            final int size = nums.length;
            if (size == 0) return res;

            this.res = new ArrayList<>();
            this.nums = nums;
            this.aux = new int[size];
            this.counter = new int[size];
            this.index = new int[size];

            for (int i = 0; i < size; i++){
                index[i] = i;
            }

            merge_sort_recursive(0, size - 1);

            for (int i = 0; i < size; i++) {
                res.add(counter[i]);
            }
            return res;
        }

        private void merge_sort_recursive(int left, int right) {
            if (left == right) return;
            int mid = (left + right ) / 2;

            // [left, mid], [mid+1,right]
            merge_sort_recursive(left, mid);
            merge_sort_recursive(mid+1, right);

            if (nums[index[mid]] > nums[index[mid+1]]) {
                sortAndCount(left, mid, right);
            }
        }

        private void sortAndCount(int left, int mid, int right) {
            for(int i = left; i <= right; i++) {
                this.aux[i] = this.index[i];
            }

            int i = left;
            int j = mid + 1;

            for (int k = left; k <= right; k++) {
                if (i > mid) {
                    index[k] = aux[j++];
                } else if (j > right) {
                    index[k] = aux[i++];
                    counter[index[k]] += right - mid;
                } else if (nums[aux[i]] <= nums[aux[j]]) {
                    index[k] = aux[i++];
                    counter[index[k]] += j - 1 - mid;
                } else {
                    index[k] = aux[j++];
                }
            }
        }
    }

}
