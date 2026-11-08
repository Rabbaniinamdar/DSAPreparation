
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 167: Two Sum II - Input Array Is Sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * Problem:
 * Given a 1-indexed array of integers sorted in non-decreasing order,
 * find two numbers that add up to the target. Return their 1-based
 * indices. The solution must use constant extra space.
 *
 * INTERVIEW EXPLANATION:
 *
 * Since the array is sorted, use two pointers:
 * - left starts at the beginning.
 * - right starts at the end.
 *
 * Calculate nums[left] + nums[right]:
 * - If the sum equals target, return the 1-based indices.
 * - If the sum is smaller, move left forward to increase the sum.
 * - If the sum is larger, move right backward to decrease the sum.
 *
 * This works because moving the left pointer can only move to a value
 * that is equal or larger, while moving the right pointer can only move
 * to a value that is equal or smaller.
 *
 * Complexity:
 * Time: O(n), because each pointer moves at most n times.
 * Extra space: O(1).
 *
 * INTERVIEW-READY ANSWER:
 * "Because the input array is sorted, I can use two pointers instead of
 * a HashMap. I start one pointer at each end and compare their sum with
 * the target. If the sum is too small, I move the left pointer right;
 * if it is too large, I move the right pointer left. I return 1-based
 * indices as required by the problem. The solution is O(n) time and
 * O(1) extra space."
 */
public class TwoSumIIInputArrayIsSorted {

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }
    public static List<List<Integer>> twoSumWithoutDuplicates(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // return new int[]{left + 1, right + 1};
                result.add(Arrays.asList(left + 1, right + 1));
                left++;
                right--;    
                while (left < right && numbers[left] == numbers[left - 1]) {
                    left++;
                }
                while (left < right && numbers[right] == numbers[right + 1]) {
                    right--;
                }
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 6, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }
}
