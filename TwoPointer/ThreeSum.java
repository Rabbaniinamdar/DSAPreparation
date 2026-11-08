
import java.util.*;

/*
====================================================
LEETCODE 15 - 3SUM
====================================================

Problem Link:
https://leetcode.com/problems/3sum/

PROBLEM DESCRIPTION:
Given an integer array nums, find all unique triplets
whose sum is equal to zero.

INPUT:
nums = [-1, 0, 1, 2, -1, -4]

OUTPUT:
[[-1, -1, 2], [-1, 0, 1]]

EXPLANATION:
-1 + (-1) + 2 = 0
-1 + 0 + 1 = 0

APPROACH:
Sorting + Two Pointers

1. Sort the array.
2. Fix the first element using i.
3. Initialize left = i + 1.
4. Initialize right = nums.length - 1.
5. Calculate the sum of three elements.
6. If sum == 0, store the triplet.
7. And Skip duplicate elements.
8. If sum < 0, increment left.
9. If sum > 0, decrement right.

DRY RUN:

Sorted array:
[-4, -1, -1, 0, 1, 2]

First triplet:
-1 + (-1) + 2 = 0

Second triplet:
-1 + 0 + 1 = 0

TIME COMPLEXITY:
O(n²)

SPACE COMPLEXITY:
O(1) auxiliary space, excluding sorting and output.

====================================================
INTERVIEW-READY ANSWER:
====================================================

"I solve this problem using sorting and the two-pointer
technique.

First, I sort the array. Then I fix one element using
a for loop and use two pointers to find the remaining
two elements.

If the sum is zero, I add the triplet to the result.
If the sum is negative, I move the left pointer forward.
If the sum is positive, I move the right pointer backward.

I skip duplicate elements to avoid duplicate triplets.

The overall time complexity is O(n²)."

====================================================
FOLLOW-UP INTERVIEW QUESTIONS:
====================================================

1. Why do we sort the array?
   To apply two pointers and skip duplicates.

2. Why do we move left when sum is negative?
   To increase the sum.

3. Why do we move right when sum is positive?
   To decrease the sum.

4. What is the brute-force complexity?
   O(n³), using three nested loops.

5. Why skip duplicates?
   To return only unique triplets.

====================================================
JAVA IMPLEMENTATION:
====================================================
*/

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(
                        nums[i], nums[left], nums[right]
                    ));
                    left++;
                    right--;
                    while (left < right &&
                           nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right &&
                           nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
