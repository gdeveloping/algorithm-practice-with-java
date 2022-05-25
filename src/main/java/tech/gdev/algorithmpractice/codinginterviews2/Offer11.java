package tech.gdev.algorithmpractice.codinginterviews2;

/**
 * 11
 * Easy
 *
 * @author gdev
 * @date 2022/5/25 22:08
 */
public class Offer11 {
    private static class Solution1 {
        /**
         * time: O(log(N))
         * space: O(1)
         *
         * @param numbers -
         * @return -
         */
        public int minArray(int[] numbers) {
            if (numbers == null || numbers.length == 0) {
                return -1;
            }
            int left = 0;
            int right = numbers.length - 1;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (numbers[mid] < numbers[right]) {
                    right = mid;
                } else if (numbers[mid] > numbers[right]) {
                    left = mid + 1;
                } else {
                    // numbers[mid] == numbers[right]
                    right--;
                }
            }
            return numbers[left];
        }
    }
}
