/**
 * LeetCode 26: Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * Problem:
 * Given a sorted array, remove duplicates in-place so that each unique
 * element appears once. Return k, the number of unique elements.
 * The first k positions must contain the unique values in sorted order.
 *
 * INTERVIEW EXPLANATION:
 *
 * Use two pointers:
 * - slow points to the last unique element written.
 * - fast scans the remaining elements.
 *
 * Because the array is sorted, duplicates are adjacent. Therefore,
 * nums[fast] is new whenever nums[fast] != nums[slow].
 * When a new value is found, increment slow and copy nums[fast] to
 * nums[slow]. At the end, slow + 1 is the number of unique elements.
 *
 * Example:
 * Input:  [1, 1, 2, 2, 3]
 * Output: k = 3; first three values become [1, 2, 3].
 *
 * Complexity:
 * Time: O(n), because the array is scanned once.
 * Extra space: O(1), because changes are made in the input array.
 *
 * INTERVIEW-READY ANSWER:
 * "Since the array is sorted, duplicate values are next to each other.
 * I maintain a slow pointer for the last unique value and a fast pointer
 * to scan the array. Whenever fast finds a different value, I move slow
 * forward and overwrite that position. This runs in O(n) time and O(1)
 * extra space."
 */

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int slow = 0;

        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3};

        int k = removeDuplicates(nums);

        System.out.println("Unique count: " + k);
        System.out.print("Unique values: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
