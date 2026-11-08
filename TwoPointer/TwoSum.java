import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/**
 * LeetCode 1: Two Sum
 * https://leetcode.com/problems/two-sum/
 *
 * Problem:
 * Given an integer array nums and an integer target, return the indices
 * of two numbers whose sum equals target. Assume exactly one solution
 * exists and do not use the same element twice.
 *
 * INTERVIEW EXPLANATION:
 *
 * Approach 1 - Brute Force:
 * Check every pair (i, j), where j > i. If nums[i] + nums[j] == target,
 * return their indices.
 *
 * Approach 2 - HashMap (optimal):
 * Traverse the array once. For each value nums[i], calculate the number
 * needed to complete the target: complement = target - nums[i].
 * If complement is already in the map, its index and i form the answer.
 * Otherwise, store nums[i] and its index.
 *
 * Why check before inserting?
 * This prevents using the same array element twice.
 *
 * Complexity:
 * Brute force: O(n^2) time, O(1) extra space.
 * HashMap:    O(n) average time, O(n) extra space.
 *
 * INTERVIEW-READY ANSWER:
 * "I can solve this with two nested loops in O(n squared) time.
 * To optimize it, I use a HashMap to store each number and its index.
 * For every element, I calculate its complement and check whether that
 * complement has already been seen. This gives O(n) average time and
 * O(n) extra space."
 */
public class TwoSum {

    // Brute-force solution
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // Optimal HashMap solution
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexByValue = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (indexByValue.containsKey(complement)) {
                return new int[]{indexByValue.get(complement), i};
            }

            indexByValue.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println("Brute force: " +
                Arrays.toString(twoSumBruteForce(nums, target)));
        System.out.println("HashMap: " +
                Arrays.toString(twoSum(nums, target)));
    }
}
