
import java.util.Arrays;

/*
 * Problem: Sort Colors
 * LeetCode: 75
 * URL: https://leetcode.com/problems/sort-colors/
 *
 * PROBLEM DESCRIPTION:
 *
 * Given an array containing only 0, 1, and 2, sort the array
 * in-place so that:
 *
 * 0 comes first.
 * 1 comes in the middle.
 * 2 comes last.
 *
 * You must solve this problem without using a sorting algorithm.
 *
 * SAMPLE INPUT:
 * nums = [2, 0, 2, 1, 1, 0]
 *
 * SAMPLE OUTPUT:
 * [0, 0, 1, 1, 2, 2]
 *
 * EXPLANATION:
 * All 0s are moved to the beginning.
 * All 1s are placed in the middle.
 * All 2s are moved to the end.
 *
 *
 * APPROACH: DUTCH NATIONAL FLAG ALGORITHM
 *
 * We use three pointers:
 *
 * low  = 0
 * mid  = 0
 * high = arr.length - 1
 *
 * The array is divided into four regions:
 *
 * [0 ... low-1]       -> All 0s
 * [low ... mid-1]     -> All 1s
 * [mid ... high]      -> Unsorted elements
 * [high+1 ... n-1]    -> All 2s
 *
 *
 * ALGORITHM:
 *
 * 1. If arr[mid] == 0:
 *      Swap arr[low] and arr[mid].
 *      Increment low and mid.
 *
 * 2. If arr[mid] == 1:
 *      Increment mid.
 *
 * 3. If arr[mid] == 2:
 *      Swap arr[mid] and arr[high].
 *      Decrement high.
 *      Do not increment mid because the swapped element
 *      from the high position is not yet checked.
 *
 * 4. Continue while mid <= high.
 *
 *
 * DRY RUN:
 *
 * Input:
 * [2, 0, 2, 1, 1, 0]
 *
 * Initial:
 * low = 0, mid = 0, high = 5
 *
 * Step 1:
 * arr[mid] = 2
 * Swap arr[0] and arr[5]
 * Array = [0, 0, 2, 1, 1, 2]
 * high = 4
 *
 * Step 2:
 * arr[mid] = 0
 * Swap arr[0] and arr[0]
 * Array = [0, 0, 2, 1, 1, 2]
 * low = 1, mid = 1
 *
 * Step 3:
 * arr[mid] = 0
 * Swap arr[1] and arr[1]
 * Array = [0, 0, 2, 1, 1, 2]
 * low = 2, mid = 2
 *
 * Step 4:
 * arr[mid] = 2
 * Swap arr[2] and arr[4]
 * Array = [0, 0, 1, 1, 2, 2]
 * high = 3
 *
 * Step 5:
 * arr[mid] = 1
 * Increment mid.
 * mid = 3
 *
 * Step 6:
 * arr[mid] = 1
 * Increment mid.
 * mid = 4
 *
 * Now mid > high, so stop.
 *
 * Final Output:
 * [0, 0, 1, 1, 2, 2]
 *
 *
 * TIME COMPLEXITY:
 * O(n) - Every element is processed at most once.
 *
 * SPACE COMPLEXITY:
 * O(1) - Sorting is performed in-place.
 *
 *
 * INTERVIEW-READY ANSWER:
 *
 * "I use the Dutch National Flag algorithm with three pointers:
 * low, mid, and high.
 *
 * The low pointer maintains the boundary of zeroes, the mid
 * pointer examines the current element, and the high pointer
 * maintains the boundary of twos.
 *
 * If the current element is zero, I swap it with low and
 * increment both pointers.
 *
 * If it is one, I simply increment mid.
 *
 * If it is two, I swap it with high and decrement high.
 * I don't increment mid in this case because the swapped
 * element still needs to be checked.
 *
 * This solution sorts the array in O(n) time and O(1) space."
 *
 *
 * FOLLOW-UP INTERVIEW QUESTIONS:
 *
 * Q1. Why don't we increment mid when arr[mid] == 2?
 * Answer: Because we swap with the high pointer, and the
 * incoming element has not been checked yet.
 *
 * Q2. Why do we increment both low and mid when arr[mid] == 0?
 * Answer: The element at mid is zero, and the element at low
 * belongs in the zero region. After swapping, both positions
 * are correctly classified.
 *
 * Q3. Why do we use mid <= high instead of mid < high?
 * Answer: Because when mid equals high, one element is still
 * unprocessed and must be examined.
 *
 * Q4. Can we use Arrays.sort()?
 * Answer: Yes, but the problem asks for a one-pass in-place
 * solution without a sorting algorithm.
 *
 * Q5. What is the name of this algorithm?
 * Answer: Dutch National Flag Algorithm.
 */

public class SortColors {

    // Swap two elements in the array
    public void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void sortColors(int[] arr) {

        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        // Process all elements, including when mid == high
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;

                // Do not increment mid here.
                // The swapped element needs to be checked.
            }
        }
    }

    public static void main(String[] args) {

        SortColors obj = new SortColors();

        int[] arr = {2, 0, 2, 1, 1, 0};

        obj.sortColors(arr);

        System.out.println(Arrays.toString(arr));

        // Output: [0, 0, 1, 1, 2, 2]
    }
}
