import java.util.Arrays;

/**
 * LeetCode 977: Squares of a Sorted Array
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 *
 * Problem:
 * Given a non-decreasing sorted integer array, return a new array
 * containing the square of every number, also sorted in non-decreasing
 * order.
 *
 * INTERVIEW EXPLANATION:
 *
 * A direct approach is to square every element and sort the result:
 * O(n log n) time.
 *
 * We can do better with two pointers. The input is sorted, but negative
 * values can have large squares. The largest square must therefore be
 * at either end of the array.
 *
 * - left starts at index 0.
 * - right starts at the last index.
 * - write the larger square at the end of the result array.
 * - move the pointer from which the larger square was taken.
 *
 * Fill the result from right to left so it ends up sorted.
 *
 * Example:
 * Input:  [-4, -1, 0, 3, 10]
 * Output: [0, 1, 9, 16, 100]
 *
 * Complexity:
 * Time: O(n), because each pointer moves inward at most n times.
 * Extra space: O(n), for the returned result array.
 *
 * INTERVIEW-READY ANSWER:
 * "Although the input is sorted, squaring can disrupt the order because
 * negative values may have large absolute values. The maximum square
 * must be at one of the two ends. I compare the squares at the left and
 * right pointers and fill the output array from right to left. This
 * achieves O(n) time."
 */
public class SquaresOfASortedArray {

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int left = 0;
        int right = n - 1;
        int write = n - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[write] = leftSquare;
                left++;
            } else {
                result[write] = rightSquare;
                right--;
            }

            write--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};

        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
}
