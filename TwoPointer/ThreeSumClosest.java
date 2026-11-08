
import java.util.*;

/*
========================================================
LEETCODE 16 - 3SUM CLOSEST
========================================================

Problem Link:
https://leetcode.com/problems/3sum-closest/

PROBLEM DESCRIPTION:

Given an integer array nums and an integer target,
find three integers in nums such that their sum is
closest to the target.

Return the sum of the three integers.

You may assume that each input has exactly one solution.

INPUT:
nums = [-1, 2, 1, -4]
target = 1

OUTPUT:
2

EXPLANATION:
The possible triplet [-1, 2, 1] gives:

-1 + 2 + 1 = 2

The sum 2 is closest to the target 1.

========================================================
APPROACH: SORTING + TWO POINTERS
========================================================

1. Sort the given array.
2. Initialize result with the sum of the first
   three elements.
3. Use a for loop to fix the first element.
4. Initialize two pointers:
      p1 = i + 1
      p2 = nums.length - 1

5. Calculate the sum of three elements.

6. Compare the current sum with the target.
   If the current sum is closer, update result.

7. If sum == target, return target immediately.

8. If sum < target:
      Move p1 forward to increase the sum.

9. If sum > target:
      Move p2 backward to decrease the sum.

10. Return result.

========================================================
DRY RUN:
========================================================

INPUT:
nums = [-1, 2, 1, -4]
target = 1

After sorting:
[-4, -1, 1, 2]

Initial result:
-4 + (-1) + 1 = -4

Iteration 1:

i = 0
p1 = 1
p2 = 3

sum = -4 + (-1) + 2
sum = -3

Difference = |-3 - 1| = 4

Update pointers:
sum < target, so p1++

Iteration 2:

p1 = 2
p2 = 3

sum = -4 + 1 + 2
sum = -1

Difference = |-1 - 1| = 2

Update pointers:
sum < target, so p1++

Next, p1 == p2, so move to the next i.

Iteration 3:

i = 1
p1 = 2
p2 = 3

sum = -1 + 1 + 2
sum = 2

Difference = |2 - 1| = 1

Update result = 2

Final output:
2

========================================================
TIME AND SPACE COMPLEXITY:
========================================================

Sorting:
O(n log n)

Outer loop:
O(n)

Two-pointer traversal:
O(n) for each iteration

Overall Time Complexity:
O(n²)

Auxiliary Space Complexity:
O(1), excluding sorting implementation.

========================================================
INTERVIEW-READY ANSWER:
========================================================

"I solve this problem using sorting and the two-pointer
technique.

First, I sort the array and initialize a result variable
with the sum of the first three elements.

Then I use a for loop to fix the first element.
For every iteration, I initialize two pointers:
one at i + 1 and another at the last index.

I calculate the sum of these three elements and compare
its absolute difference with the target against the
best result found so far.

If the current sum is closer, I update the result.

If the sum is equal to the target, I return immediately.

If the sum is smaller than the target, I move the left
pointer forward to increase the sum.

If the sum is greater than the target, I move the right
pointer backward to decrease the sum.

Finally, I return the closest sum.

The overall time complexity is O(n²)."

========================================================
FOLLOW-UP INTERVIEW QUESTIONS:
========================================================

Q1. Why do we sort the array?

Answer:
Sorting allows us to use two pointers efficiently
to increase or decrease the sum.

Q2. Why do we initialize result with the first
three elements?

Answer:
We need a valid initial triplet sum to compare
against other possible triplets.

Q3. Why do we use Math.abs()?

Answer:
To calculate the absolute difference between
the current sum and the target.

Q4. Why do we move p1 when sum < target?

Answer:
Because the array is sorted. Moving p1 forward
increases the value and helps increase the sum.

Q5. Why do we move p2 when sum > target?

Answer:
Moving p2 backward decreases the value and
helps decrease the sum.

Q6. What is the brute-force approach?

Answer:
Use three nested loops to check every possible
triplet.

Time Complexity: O(n³).

Q7. What is the difference between 3Sum
and 3Sum Closest?

Answer:

3Sum:
Find all unique triplets whose sum equals zero.

3Sum Closest:
Find one triplet whose sum is closest to target.

Q8. Can we return immediately if sum == target?

Answer:
Yes. We have found the exact target, so no
other triplet can be closer.

========================================================
JAVA IMPLEMENTATION:
========================================================
*/

class Solution {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int p1 = i + 1;
            int p2 = nums.length - 1;
            while (p1 < p2) {

                int sum = nums[i] + nums[p1] + nums[p2];
                // Update result if current sum is closer
                if (Math.abs(sum - target) < Math.abs(target - result)) {
                    result = sum;
                }
                // Exact target found
                if (sum == target) {
                    return target;
                }
                // Increase sum
                else if (sum < target) {
                    p1++;
                }
                // Decrease sum
                else {
                    p2--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = {-1, 2, 1, -4};
        int target = 1;

        int result = solution.threeSumClosest(nums, target);

        System.out.println("Closest Sum: " + result);
    }
}
