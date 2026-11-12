
/*
 * Problem: Remove Element
 * LeetCode: 27
 * URL: https://leetcode.com/problems/remove-element/
 *
 * PROBLEM DESCRIPTION:
 *
 * Given an integer array nums and an integer val, remove all
 * occurrences of val in-place.
 *
 * Return the number of elements remaining after removal.
 *
 * The relative order of the remaining elements may be changed,
 * but it is not necessary.
 *
 * SAMPLE INPUT:
 * nums = [3, 2, 2, 3]
 * val = 3
 *
 * SAMPLE OUTPUT:
 * k = 2
 * nums = [2, 2, _, _]
 *
 * EXPLANATION:
 *
 * The value 3 occurs twice.
 * We remove both occurrences and keep the remaining elements.
 *
 * The first k elements must contain the valid result.
 *
 *
 * APPROACH: TWO POINTERS (SLOW AND FAST)
 *
 * We use two pointers:
 *
 * slow = 0
 * fast = 0
 *
 * fast:
 * Traverses the complete array.
 *
 * slow:
 * Maintains the position where the next valid element
 * should be placed.
 *
 * ALGORITHM:
 *
 * 1. Traverse the array using fast.
 *
 * 2. If nums[fast] != val:
 *      Copy nums[fast] to nums[slow].
 *      Increment slow.
 *
 * 3. If nums[fast] == val:
 *      Ignore that element.
 *
 * 4. Return slow.
 *
 *
 * DRY RUN:
 *
 * Input:
 * nums = [3, 2, 2, 3]
 * val = 3
 *
 * Initially:
 * slow = 0
 *
 * fast = 0:
 * nums[fast] = 3
 * It equals val, so skip.
 *
 * fast = 1:
 * nums[fast] = 2
 * It is not equal to val.
 * nums[slow] = nums[fast]
 * Array = [2, 2, 2, 3]
 * slow = 1
 *
 * fast = 2:
 * nums[fast] = 2
 * It is not equal to val.
 * nums[slow] = nums[fast]
 * Array = [2, 2, 2, 3]
 * slow = 2
 *
 * fast = 3:
 * nums[fast] = 3
 * It equals val, so skip.
 *
 * Final:
 * slow = 2
 *
 * First two elements:
 * [2, 2]
 *
 * Return 2.
 *
 *
 * TIME COMPLEXITY:
 * O(n) - We traverse the array once.
 *
 * SPACE COMPLEXITY:
 * O(1) - We modify the original array without extra space.
 *
 *
 * INTERVIEW-READY ANSWER:
 *
 * "I solve this problem using the two-pointer technique.
 *
 * I maintain a slow pointer to track the position where the
 * next valid element should be placed, and a fast pointer to
 * traverse the array.
 *
 * Whenever the fast pointer finds an element that is not
 * equal to the given value, I copy that element to the slow
 * pointer's position and increment slow.
 *
 * If the element equals the given value, I simply skip it.
 *
 * Finally, slow represents the number of valid elements.
 *
 * The solution takes O(n) time and O(1) extra space."
 *
 *
 * FOLLOW-UP INTERVIEW QUESTIONS:
 *
 * Q1. Why do we need two pointers?
 * Answer: One pointer scans the array, and the other maintains
 * the position for valid elements.
 *
 * Q2. Why do we return slow?
 * Answer: Because slow represents the number of elements
 * that are not equal to val.
 *
 * Q3. Are we creating a new array?
 * Answer: No. We modify the original array in-place.
 *
 * Q4. What happens if all elements equal val?
 * Answer: slow remains 0, so we return 0.
 *
 * Q5. What happens if val is not present?
 * Answer: Every element is copied to the valid region,
 * and we return nums.length.
 *
 * Q6. Is the relative order maintained?
 * Answer: Yes. The fast pointer scans from left to right,
 * so the remaining elements retain their original order.
 */

class RemoveElement {

    public int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        return slow;
    }

    public static void main(String[] args) {

        RemoveElement obj = new RemoveElement();

        int[] nums = {3, 2, 2, 3};
        int val = 3;

        int k = obj.removeElement(nums, val);

        System.out.println("Number of valid elements: " + k);

        System.out.print("Modified array: ");

        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }

        // Output:
        // Number of valid elements: 2
        // Modified array: 2 2
    }
}
