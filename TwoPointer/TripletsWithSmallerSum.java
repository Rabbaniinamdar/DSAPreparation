
import java.util.Arrays;

/*
 * Problem: Triplets with Smaller Sum
 *
 * Problem:
 * Given an array of integers and a target value, count the number
 * of triplets (i, j, k) such that:
 *
 * i < j < k
 * nums[i] + nums[j] + nums[k] < target
 *
 * LeetCode: Similar to Problem 259 - 3Sum Smaller
 * URL: https://leetcode.com/problems/3sum-smaller/
 *
 * Sample Input:
 * nums = [-2, 0, 1, 3]
 * target = 2
 *
 * Sample Output:
 * 2
 *
 * Explanation:
 * Valid triplets are:
 *
 * [-2, 0, 1]  -> sum = -1 < 2
 * [-2, 0, 3]  -> sum =  1 < 2
 *
 * Total count = 2
 *
 *
 * APPROACH: SORTING + TWO POINTERS
 *
 * 1. Sort the array.
 * 2. Fix one element using the outer loop.
 * 3. Initialize two pointers:
 *      left = i + 1
 *      right = nums.length - 1
 * 4. Calculate the sum of the three elements.
 *
 * 5. If sum >= target:
 *      Decrease right because the sum is too large.
 *
 * 6. If sum < target:
 *      All elements between left + 1 and right can form
 *      valid triplets with nums[i] and nums[left].
 *
 *      So, add (right - left) to the result.
 *      Then increment left.
 *
 *
 * WHY DO WE ADD (right - left)?
 *
 * Because the array is sorted.
 *
 * If:
 * nums[i] + nums[left] + nums[right] < target
 *
 * Then replacing nums[right] with any element between
 * left and right will also produce a sum smaller than target.
 *
 * Therefore, we can count all those combinations at once.
 *
 *
 * DRY RUN:
 *
 * nums = [-2, 0, 1, 3]
 * target = 2
 *
 * Array is already sorted.
 *
 * i = 0
 * nums[i] = -2
 * left = 1, right = 3
 *
 * sum = -2 + 0 + 3 = 1
 * 1 < 2
 *
 * result = result + (right - left)
 * result = 0 + (3 - 1) = 2
 *
 * left++
 *
 * Now left = 2, right = 3
 *
 * sum = -2 + 1 + 3 = 2
 * 2 >= 2
 *
 * right--
 *
 * left == right, so stop this iteration.
 *
 * Remaining outer-loop iterations do not add any triplets.
 *
 * Final result = 2
 *
 *
 * TIME COMPLEXITY:
 * Sorting: O(n log n)
 * Two-pointer traversal: O(n²)
 * Overall: O(n²)
 *
 * SPACE COMPLEXITY:
 * O(1) auxiliary space, excluding sorting implementation details.
 *
 *
 * INTERVIEW-READY ANSWER:
 *
 * "I solve this problem using sorting and the two-pointer technique.
 * First, I sort the array. Then I fix one element and use two
 * pointers to find the remaining two elements.
 *
 * If the sum is greater than or equal to the target, I move the
 * right pointer towards the left to reduce the sum.
 *
 * If the sum is smaller than the target, I add right minus left
 * to the count because every element between the two pointers
 * will also form a valid triplet due to the sorted order.
 *
 * This reduces the brute-force O(n³) solution to O(n²)."
 *
 *
 * FOLLOW-UP INTERVIEW QUESTIONS:
 *
 * Q1. Why do we sort the array?
 * Answer: Sorting allows us to use two pointers and count multiple
 * valid triplets at once.
 *
 * Q2. Why do we add right - left instead of 1?
 * Answer: Because all elements between left and right can form
 * valid triplets with the fixed element and nums[left].
 *
 * Q3. What is the brute-force complexity?
 * Answer: O(n³), using three nested loops.
 *
 * Q4. What happens when sum == target?
 * Answer: The triplet is not counted because the condition is
 * strictly smaller than target. We move right to reduce the sum.
 *
 * Q5. Does this method count duplicate-value triplets separately?
 * Answer: Yes. It counts index combinations, not unique value
 * combinations. This is important when duplicate values exist.
 */

public class TripletsWithSmallerSum {

    public static int countTriplets(int[] nums, int target) {

        int result = 0;

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Fix the first element
        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            // Step 3: Find the remaining two elements
            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum >= target) {

                    // Sum is too large, decrease it
                    right--;

                } else {

                    // All elements between left and right
                    // form valid triplets with nums[i]
                    result += right - left;

                    // Move left to find more combinations
                    left++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {-2, 0, 1, 3};
        int target = 2;

        System.out.println(countTriplets(nums, target));
        // Output: 2
    }
}
