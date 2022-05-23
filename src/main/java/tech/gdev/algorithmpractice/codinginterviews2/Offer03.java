package tech.gdev.algorithmpractice.codinginterviews2;


import java.util.Arrays;
import java.util.Objects;

/**
 * 03
 * Easy
 *
 * @author gdev
 * @date 2022/5/23 21:12
 */
public class Offer03 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();
        int[] nums;
        int[] duplications;

        System.out.println("could modify nums:");
        nums = new int[]{2,1,3,1,4};
        duplications = new int[]{1};
        test1(solution1, nums, duplications);

        nums = new int[]{2,4,2,1,4};
        duplications = new int[]{2,4};
        test1(solution1, nums, duplications);

        System.out.println("\ncould not modify nums:");
        nums = new int[]{2,1,3,1,4};
        duplications = new int[]{1};
        test2(solution2, nums, duplications);

        nums = new int[]{2,4,2,1,4};
        duplications = new int[]{2,4};
        test2(solution2, nums, duplications);
    }

    private static void test1(Solution1 solution1, int[] nums, int[] duplications) {
        int res = solution1.findRepeatNumber(nums);
        System.out.printf("%d\t", res);
        System.out.println(Arrays.stream(duplications).anyMatch(o -> Objects.equals(o, res)));
    }

    private static void test2(Solution2 solution2, int[] nums, int[] duplications) {
        int res = solution2.findRepeatNumber(nums);
        System.out.printf("%d\t", res);
        System.out.println(Arrays.stream(duplications).anyMatch(o -> Objects.equals(o, res)));
    }

    /**
     * modify nums
     *
     * way 1 order
     * time: O(nlog(n))
     * space: merge sort O(N); quick sort O(1); heap sort O(1)
     *
     * way 2 hash set
     * time: O(N)
     * space: O(N)
     *
     * way 3 this
     * time: O(N)
     * space: O(1)
     */
    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * @param nums [0,n-1]
         * @return -
         */
        public int findRepeatNumber(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0 || nums[i] >= nums.length) {
                    return -1;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                while (i != nums[i]) {
                    if (nums[i] == nums[nums[i]]) {
                        return nums[i];
                    }
                    int temp = nums[i];
                    nums[i] = nums[nums[i]];
                    nums[temp] = temp;
                }
            }
            return -1;
        }
    }


    /**
     * not modify nums
     *
     * way 1 copy
     * time: O(N)
     * space: O(N)
     *
     * way 2 hash set
     * time: O(N)
     * space: O(N)
     *
     * way 3 this
     * time: O(Nlog(N))
     * space: O(1)
     */
    private static class Solution2 {
        /**
         * time: O(Nlog(N))
         * space: O(1)
         *
         * @param nums [0,n-1]
         * @return -
         */
        public int findRepeatNumber(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= 0 || nums[i] >= nums.length) {
                    return -1;
                }
            }
            int left = 1;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = ((right-left)>>1) + left;
                int count = countRange(nums, left, mid);
                if (left == right) {
                    if (count > 1) {
                        return left;
                    } else {
                        return -1;
                    }
                }
                if (count > (mid - left + 1)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }

        private int countRange(int[] nums, int left, int right) {
            if (left > right) {
                return 0;
            }
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= left && nums[i] <= right) {
                    count++;
                }
            }
            return count;
        }
    }
}
