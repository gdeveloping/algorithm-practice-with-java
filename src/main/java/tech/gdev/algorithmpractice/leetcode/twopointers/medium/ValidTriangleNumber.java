package tech.gdev.algorithmpractice.leetcode.twopointers.medium;

import java.util.Arrays;

/**
 * 611.
 * Medium
 *
 * @author gdev
 * @date 2022/5/1 22:52
 */
public class ValidTriangleNumber {

    public static void main(String[] args) {
        test1(new int[]{2,2,3,4}, 3);
        test1(new int[]{4,2,3,4}, 4);

        System.out.println();
        test2(new int[]{2,2,3,4}, 3);
        test2(new int[]{4,2,3,4}, 4);
    }

    private static void test1(int[] nums, int output) {
        Solution1 solution1 = new Solution1();
        int res = solution1.triangleNumber(nums);
        System.out.println("res: " + res + "\tsuccess: " + (res == output));
    }

    private static void test2(int[] nums, int output) {
        Solution2 solution2 = new Solution2();
        int res = solution2.triangleNumber(nums);
        System.out.println("res: " + res + "\tsuccess: " + (res == output));
    }

    private static class Solution1 {
        /**
         * time: O(N^2)
         * space: O(1)
         *
         * Runtime: 45 ms, faster than 49.89% of Java online submissions for Valid Triangle Number.
         * Memory Usage: 44.1 MB, less than 36.50% of Java online submissions for Valid Triangle Number.
         *
         * @param nums -
         * @return -
         */
        public int triangleNumber(int[] nums) {
            if (nums.length < 3) {
                return 0;
            }
            Arrays.sort(nums);
            int res = 0;
            for (int i = nums.length - 1; i >= 2; i--) {
                int left = 0;
                int right = i - 1;
                while (left < right) {
                    if (nums[left] + nums[right] > nums[i]) {
                        res += (right - left);
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            return res;
        }
    }

    private static class Solution2 {
        /**
         * time: O(N^2*logN)
         * space: O(1)
         *
         * Runtime: 584 ms, faster than 14.07% of Java online submissions for Valid Triangle Number.
         * Memory Usage: 44.4 MB, less than 13.90% of Java online submissions for Valid Triangle Number.
         *
         * @param nums -
         * @return -
         */
        public int triangleNumber(int[] nums) {
            if (nums.length < 3) {return 0;}
            Arrays.sort(nums);
            int res = 0;
            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    int sum = nums[i] + nums[j];
                    int left = j + 1;
                    int right = nums.length - 1;
                    while (left <= right) {
                        int mid = left + (right - left) / 2;
                        if (nums[mid] == sum) {
                            right = mid - 1;
                        } else if (nums[mid] < sum) {
                            left = mid + 1;
                        } else {
                            // sum < nums[mid]
                            right = mid - 1;
                        }
                    }
                    if (sum > nums[right]) {
                        res += (right - j);
                    }
                }
            }
            return res;
        }
    }
}
