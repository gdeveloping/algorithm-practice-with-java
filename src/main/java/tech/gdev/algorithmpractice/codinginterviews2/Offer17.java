package tech.gdev.algorithmpractice.codinginterviews2;

import java.util.Arrays;

/**
 * 17
 * Easy
 *
 * @author gdev
 * @date 2022/5/26 21:00
 */
public class Offer17 {

    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        Solution2 s2 = new Solution2();

//        s1.printNumbers(3);

        System.out.println("\n\n\n");

//        s2.printNumbers(2);


        Solution3 s3 = new Solution3();
        int[] res = s3.printNumbers(2);
        System.out.println(Arrays.toString(res));
    }

    private static class Solution1 {
        /**
         * time: O(10^N)
         * space: O(N)
         *
         * @param n -
         */
        public void printNumbers(int n) {
            if (n < 1) {return;}
            char[] number = new char[n];
            Arrays.fill(number, '0');
            while (increment(number)) {
                print(number);
            }
        }

        /**
         *
         * @param number -
         * @return true: OK; false: overflow;
         */
        private boolean increment(char[] number) {
            int size = number.length;
            number[size-1] += 1;
            for (int i = size - 1; i >= 0; i--) {
                if (number[i] == '0'+10) {
                    if (i == 0) {
                        return false;
                    }
                    number[i] = '0';
                    number[i-1] += 1;
                } else {
                    return true;
                }
            }
            return true;
        }

        /**
         * do not print the '0' before the first positive number
         * @param number -
         */
        private void print(char[] number) {
            int i = 0;
            while (i < number.length) {
                if (number[i] == '0') {
                    i++;
                } else {
                    break;
                }
            }

            if (i == number.length) {
//                System.out.println("0");
                return;
            }

            for (; i < number.length; i++) {
                System.out.printf("%c", number[i]);
            }
            System.out.println();
        }
    }

    private static class Solution2 {
        /**
         * time: O(10^N)
         * space: O(N), char[], stack
         *
         * @param n -
         */
        public void printNumbers(int n) {
            if (n < 1) {return;}
            char[] number = new char[n];
            helper(number, 0);
        }

        private void helper(char[] number, int index) {
            if (index >= number.length) {
                print(number);
                return;
            }
            for (int i = 0; i < 10; i++) {
                number[index] = (char) ('0' + i);
                helper(number, index+1);
            }
        }

        /**
         * do not print the '0' before the first positive number
         * @param number -
         */
        private void print(char[] number) {
            int i = 0;
            while (i < number.length) {
                if (number[i] == '0') {
                    i++;
                } else {
                    break;
                }
            }

            if (i == number.length) {
//                System.out.println("0");
                return;
            }

            for (; i < number.length; i++) {
                System.out.printf("%c", number[i]);
            }
            System.out.println();
        }
    }


    private static class Solution3 {
        /**
         * time: O(10^N)
         * space: O(N)
         *
         * @param n -
         */
        public int[] printNumbers(int n) {
            if (n < 1) {return new int[0];}
            char[] number = new char[n];
            Arrays.fill(number, '0');
            int[] res = new int[(int) Math.pow(10, n) - 1];
            int index = 0;
            while (increment(number)) {
                save(number, res, index++);
            }
            return res;
        }

        /**
         *
         * @param number -
         * @return true: OK; false: overflow;
         */
        private boolean increment(char[] number) {
            int size = number.length;
            number[size-1] += 1;
            for (int i = size - 1; i >= 0; i--) {
                if (number[i] == '0'+10) {
                    if (i == 0) {
                        return false;
                    }
                    number[i] = '0';
                    number[i-1] += 1;
                } else {
                    return true;
                }
            }
            return true;
        }

        /**
         * do not print the '0' before the first positive number
         * @param number -
         */
        private void save(char[] number, int[] res, int index) {
            int i = 0;
            while (i < number.length) {
                if (number[i] == '0') {
                    i++;
                } else {
                    break;
                }
            }

            int num = 0;
            for (; i < number.length; i++) {
                num = num * 10 + (number[i] - '0');
            }
            res[index] = num;
        }
    }
}
