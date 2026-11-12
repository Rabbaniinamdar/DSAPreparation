
import java.util.*;

/*
 * Problem: 4Sum
 * LeetCode: 18
 * URL: https://leetcode.com/problems/4sum/
 *
 * PROBLEM DESCRIPTION:
 *
 * Given an integer array nums and an integer target, return all
 * unique quadruplets [nums[i], nums[j], nums[left], nums[right]]
 * such that:
 *
 * nums[i] + nums[j] + nums[left] + nums[right] == target
 *
 * All four indices must be distinct.
 *
 * SAMPLE INPUT:
 * nums = [1, 0, -1, 0, -2, 2]
 * target = 0
 *
 * SAMPLE OUTPUT:
 * [
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2],
 *   [-1,  0, 0, 1]
 * ]
 *
 * EXPLANATION:
 *
 * The sum of every quadruplet is equal to 0.
 *
 * [-2, -1, 1, 2] = 0
 * [-2,  0, 0, 2] = 0
 * [-1,  0, 0, 1] = 0
 *
 * Duplicate quadruplets are not allowed.
 *
 *
 * APPROACH: SORTING + TWO POINTERS
 *
 * Step 1:
 * Sort the array.
 *
 * Step 2:
 * Use the first loop to fix the first element (i).
 *
 * Step 3:
 * Use the second loop to fix the second element (j).
 *
 * Step 4:
 * Initialize two pointers:
 * left = j + 1
 * right = nums.length - 1
 *
 * Step 5:
 * Calculate the sum of all four elements.
 *
 * If sum == target:
 *   Add the quadruplet to the result.
 *   Move both left and right.
 *   Skip duplicate values.
 *
 * If sum < target:
 *   Increment left to increase the sum.
 *
 * If sum > target:
 *   Decrement right to decrease the sum.
 *
 *
 * DUPLICATE HANDLING:
 *
 * 1. Skip duplicate i values:
 *    if (i > 0 && nums[i] == nums[i - 1])
 *
 * 2. Skip duplicate j values:
 *    if (j > i + 1 && nums[j] == nums[j - 1])
 *
 * 3. After finding a valid quadruplet, skip duplicate
 *    left and right values.
 *
 *
 * DRY RUN:
 *
 * Input:
 * nums = [1, 0, -1, 0, -2, 2]
 * target = 0
 *
 * After sorting:
 * [-2, -1, 0, 0, 1, 2]
 *
 * First valid quadruplet:
 * i = 0, j = 1, left = 4, right = 5
 *
 * -2 + -1 + 1 + 2 = 0
 *
 * Add:
 * [-2, -1, 1, 2]
 *
 * Second valid quadruplet:
 * i = 0, j = 2, left = 3, right = 5
 *
 * -2 + 0 + 0 + 2 = 0
 *
 * Add:
 * [-2, 0, 0, 2]
 *
 * Third valid quadruplet:
 * i = 1, j = 2, left = 3, right = 4
 *
 * -1 + 0 + 0 + 1 = 0
 *
 * Add:
 * [-1, 0, 0, 1]
 *
 * Final result:
 * [
 *   [-2, -1, 1, 2],
 *   [-2, 0, 0, 2],
 *   [-1, 0, 0, 1]
 * ]
 *
 *
 * TIME COMPLEXITY:
 *
 * Sorting: O(n log n)
 * Two nested loops: O(n²)
 * Two-pointer traversal: O(n)
 *
 * Overall: O(n³)
 *
 * SPACE COMPLEXITY:
 *
 * O(1) auxiliary space, excluding sorting and output storage.
 *
 *
 * INTERVIEW-READY ANSWER:
 *
 * "I solve the 4Sum problem using sorting and the two-pointer
 * technique.
 *
 * First, I sort the array. Then I use two nested loops to fix
 * the first two elements.
 *
 * For the remaining two elements, I use left and right pointers.
 *
 * If the sum equals the target, I add the quadruplet and move
 * both pointers while skipping duplicates.
 *
 * If the sum is smaller than the target, I move left forward.
 * If the sum is greater, I move right backward.
 *
 * I also skip duplicate values at both fixed positions to
 * ensure that the result contains only unique quadruplets.
 *
 * The overall time complexity is O(n³)."
 *
 *
 * FOLLOW-UP INTERVIEW QUESTIONS:
 *
 * Q1. Why do we sort the array?
 * Answer: Sorting allows us to use two pointers and efficiently
 * skip duplicate values.
 *
 * Q2. Why do we skip duplicates for i and j?
 * Answer: To avoid generating the same quadruplet multiple times.
 *
 * Q3. Why do we move both pointers after finding a valid sum?
 * Answer: We have found one valid combination. Moving both
 * pointers helps search for other combinations.
 *
 * Q4. What is the time complexity?
 * Answer: O(n³), because we have two nested loops and one
 * two-pointer traversal.
 *
 * Q5. How is 4Sum related to 3Sum?
 * Answer: 4Sum fixes two elements and uses two pointers for
 * the remaining two. 3Sum fixes one element and uses two pointers.
 *
 * Q6. Why should we use long for sum?
 * Answer: Four integer values can overflow the int range.
 * Using long prevents overflow during sum calculation.
 */

class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {

                // Skip duplicate second elements
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {

                    // Use long to avoid integer overflow
                    long sum = (long) nums[i] + nums[j]
                             + nums[left] + nums[right];

                    if (sum == target) {

                        ans.add(Arrays.asList(
                            nums[i],
                            nums[j],
                            nums[left],
                            nums[right]
                        ));

                        left++;
                        right--;

                        // Skip duplicate left values
                        while (left < right &&
                               nums[left] == nums[left - 1]) {
                            left++;
                        }

                        // Skip duplicate right values
                        while (left < right &&
                               nums[right] == nums[right + 1]) {
                            right--;
                        }

                    } else if (sum < target) {

                        // Increase the sum
                        left++;

                    } else {

                        // Decrease the sum
                        right--;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        System.out.println(fourSum(nums, target));
    }
}
