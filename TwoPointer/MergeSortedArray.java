
/*
 * Problem: Merge Sorted Array
 * LeetCode: 88
 * URL: https://leetcode.com/problems/merge-sorted-array/
 *
 * PROBLEM DESCRIPTION:
 *
 * You are given two integer arrays nums1 and nums2, sorted
 * in non-decreasing order.
 *
 * nums1 has a size of m + n, where:
 * - The first m elements contain valid values.
 * - The remaining n positions are empty (represented by 0).
 *
 * nums2 contains n elements.
 *
 * Merge nums2 into nums1 so that nums1 becomes sorted.
 *
 * The merged result must be stored inside nums1.
 * Do not return a new array.
 *
 *
 * SAMPLE INPUT:
 *
 * nums1 = [1, 3, 5, 0, 0, 0]
 * m = 3
 *
 * nums2 = [2, 4, 6]
 * n = 3
 *
 * SAMPLE OUTPUT:
 *
 * [1, 2, 3, 4, 5, 6]
 *
 * EXPLANATION:
 *
 * Both arrays are already sorted.
 * We merge them into nums1 while maintaining sorted order.
 *
 *
 * APPROACH: THREE POINTERS (MERGE FROM END)
 *
 * We use three pointers:
 *
 * i = m - 1       Last valid element in nums1
 * j = n - 1       Last element in nums2
 * k = m + n - 1   Last available position in nums1
 *
 * WHY DO WE START FROM THE END?
 *
 * nums1 already contains elements that we need to preserve.
 * If we start merging from the beginning, we may overwrite
 * elements that we have not processed yet.
 *
 * Starting from the end avoids this problem.
 *
 *
 * ALGORITHM:
 *
 * 1. Compare nums1[i] and nums2[j].
 *
 * 2. If nums1[i] is greater:
 *      Place nums1[i] at nums1[k].
 *      Decrement i and k.
 *
 * 3. Otherwise:
 *      Place nums2[j] at nums1[k].
 *      Decrement j and k.
 *
 * 4. Continue while both i and j are valid.
 *
 * 5. If elements remain in nums2, copy them into nums1.
 *
 * 6. If elements remain in nums1, no action is required
 *    because they are already in their correct positions.
 *
 *
 * DRY RUN:
 *
 * Initial:
 *
 * nums1 = [1, 3, 5, 0, 0, 0]
 * nums2 = [2, 4, 6]
 *
 * i = 2, j = 2, k = 5
 *
 * Step 1:
 * Compare 5 and 6.
 * 6 is greater.
 * nums1[5] = 6
 *
 * nums1 = [1, 3, 5, 0, 0, 6]
 * i = 2, j = 1, k = 4
 *
 * Step 2:
 * Compare 5 and 4.
 * 5 is greater.
 * nums1[4] = 5
 *
 * nums1 = [1, 3, 5, 0, 5, 6]
 * i = 1, j = 1, k = 3
 *
 * Step 3:
 * Compare 3 and 4.
 * 4 is greater.
 * nums1[3] = 4
 *
 * nums1 = [1, 3, 5, 4, 5, 6]
 * i = 1, j = 0, k = 2
 *
 * Step 4:
 * Compare 3 and 2.
 * 3 is greater.
 * nums1[2] = 3
 *
 * nums1 = [1, 3, 3, 4, 5, 6]
 * i = 0, j = 0, k = 1
 *
 * Step 5:
 * Compare 1 and 2.
 * 2 is greater.
 * nums1[1] = 2
 *
 * nums1 = [1, 2, 3, 4, 5, 6]
 * i = 0, j = -1, k = 0
 *
 * j is now -1, so the loop stops.
 *
 * Final Output:
 * [1, 2, 3, 4, 5, 6]
 *
 *
 * TIME COMPLEXITY:
 *
 * O(m + n)
 *
 * Each element is processed at most once.
 *
 * SPACE COMPLEXITY:
 *
 * O(1)
 *
 * We merge directly into nums1 without creating another array.
 *
 *
 * INTERVIEW-READY ANSWER:
 *
 * "I solve this problem using three pointers and merge from
 * the end of the arrays.
 *
 * The first pointer starts at the last valid element of nums1.
 * The second pointer starts at the last element of nums2.
 * The third pointer starts at the last available position of nums1.
 *
 * I compare the elements at the first two pointers and place
 * the larger element at the third pointer.
 *
 * I move the corresponding pointer backwards and continue until
 * one array is exhausted.
 *
 * If elements remain in nums2, I copy them into nums1.
 * If elements remain in nums1, they are already in the correct
 * positions.
 *
 * This solution takes O(m + n) time and O(1) extra space."
 *
 *
 * FOLLOW-UP INTERVIEW QUESTIONS:
 *
 * Q1. Why do we merge from the end?
 * Answer: To avoid overwriting valid elements already present
 * in nums1.
 *
 * Q2. Why don't we need to copy remaining elements from nums1?
 * Answer: They are already in their correct positions.
 *
 * Q3. Why do we copy remaining elements from nums2?
 * Answer: Because nums2 elements have not yet been placed
 * into nums1.
 *
 * Q4. What if nums1 has no valid elements (m = 0)?
 * Answer: The remaining nums2 elements are copied into nums1.
 *
 * Q5. What if nums2 is empty (n = 0)?
 * Answer: No merging is required. nums1 is already sorted.
 *
 * Q6. What is the brute-force approach?
 * Answer: Copy nums2 into the empty positions of nums1 and
 * sort the entire array. That takes O((m+n) log(m+n)) time.
 *
 * Q7. What is the optimal approach?
 * Answer: Three pointers, merging from the end in O(m+n) time.
 */

import java.util.Arrays;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        // Merge elements from the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }

        }

        // Copy remaining elements from nums2
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 3, 5, 0, 0, 0};
        int m = 3;

        int[] nums2 = {2, 4, 6};
        int n = 3;

        merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));

        // Output: [1, 2, 3, 4, 5, 6]
    }
}
