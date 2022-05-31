package tech.gdev.algorithmpractice.codinginterviews2;

/**
 * 39
 * Easy
 *
 * @author gdev
 * @date 2022/5/31 21:46
 */
public class Offer39 {

    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        int[] nums = new int[]{1,2,3,2,2,2,5,4,2};
        int res1 = s1.majorityElement(nums);
        System.out.println(res1);

        Solution2 s2 = new Solution2();
        int res2 = s2.majorityElement(nums);
        System.out.println(res2);
    }

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * @param nums -
         * @return -
         */
        public int majorityElement(int[] nums) {
            if (nums.length == 1) {return nums[0];}
            int num = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (count == 0) {
                    num = nums[i];
                    count++;
                } else if (num == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
            return num;
        }
    }

    private static class Solution1_2 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * @param nums -
         * @return -
         */
        public int majorityElement(int[] nums) {
            if (nums.length == 1) {return nums[0];}
            int num = nums[0];
            int count = 1;
            int index = 1;
            while (index < nums.length) {
                if (num == nums[index]) {
                    count++;
                    index++;
                } else {
                    count--;
                    if (count == 0) {
                        num = nums[++index];
                        count = 1;
                    }
                    index++;
                }
            }
            return num;
        }
    }


    private static class Solution2 {
        /**
         * time: O(N*log(N))
         * space: O(log(N)) stack
         *
         * @param nums -
         * @return -
         */
        public int majorityElement(int[] nums) {
            if (nums.length == 1) {return nums[0];}
            int middle = nums.length >> 1;
            int low = 0;
            int high = nums.length - 1;
            int pivot = partition(nums, low, high);
            while (pivot != middle) {
                if (pivot < middle) {
                    low = pivot + 1;
                } else {
                    high = pivot - 1;
                }
                pivot = partition(nums, low, high);
            }
            return nums[middle];
        }

        private int partition(int[] nums, int low, int high) {
            int value = nums[low];
            int i = low;
            int j = high + 1;
            while (true) {
                while (i < high && nums[++i] <= value);
                while (j > low && nums[--j] > value);
                if (i >= j) {break;}
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            nums[low] = nums[j];
            nums[j] = value;
            return j;
        }
    }
}
