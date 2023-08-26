package Arrays;
import java.util.Arrays;

// Introduction:

// "The goal of this code is to merge two sorted arrays, arr1 and arr2, into a single sorted array arr1.
//  The challenge here is to perform this merging in-place without using extra space. This algorithm demonstrates efficient array manipulation techniques."

// Algorithm Explanation:

// "We have a method called merge that takes four parameters: 
// arr1(the first sorted array),m(the number of elements in arr1),arr2(the second sorted array),and n(the number of elements in arr2).Here'sa step-by-step explanation of the algorithm:

// Initialization:

// We start with two pointers, i and j, both initialized to the last valid indices of arr1 and arr2 respectively.
// Another pointer, lastIndex, is initialized to the last index of the merged array.
// Merging Process:

// We iterate while both i and j are within their respective arrays:
// Compare the elements at arr1[i] and arr2[j].
// If arr1[i] is greater than or equal to arr2[j], we place arr1[i] at the lastIndex in arr1, and then decrement i.
// If arr2[j] is greater, we place arr2[j] at the lastIndex in arr1, and then decrement j.
// After each placement, we decrement lastIndex to keep track of the next available position in arr1.
// Handling Remaining Elements:

// If there are any remaining elements in arr2 (i.e., if j >= 0), we copy them directly to arr1 starting from lastIndex.
// Complexity:

// "The algorithm runs in linear time complexity of O(m + n), where m is the number of 
public class TwoPointer {

    static int[] mergeWithNoExtraSpace(int arr1[], int m, int arr2[], int n) {
        int i = m - 1;
        int j = n - 1;
        int idx = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (arr1[i] >= arr2[j]) {
                arr1[idx] = arr1[i--];
            } else {
                arr1[idx] = arr2[j--];
            }
            idx--;
        }
        while (j >= 0) {
            arr1[idx] = arr2[j--];
            idx--;
        }
        return arr1;
    }

    // The removeElement function you've provided is designed to remove all
    // occurrences of a specific value from an array while maintaining the order of
    // other elements. Here's an explanation of the code:

    // Two Pointers:

    // The function uses two pointers, left and right, to traverse through the
    // array. The left pointer will point to the next available position where a
    // non-target value should be placed.
    // Loop through the Array:

    // The loop runs from the beginning to the end of the array using the right
    // pointer.
    // Comparison with Target:

    // For each element at index right, the function checks if the element is not
    // equal to the target value (val).
    // Place Non-Target Elements:

    // If the element is not equal to the target value, it means that it should be
    // kept in the modified array. The element is then placed at the position
    // pointed to by the left pointer.
    // Increment Left Pointer:

    // After placing the non-target element, the left pointer is incremented by one
    // to point to the next available position for a non-target element.
    // Return Length:

    // After traversing the entire array, the value of left indicates the new length
    // of the modified array, where all occurrences of the target value have been
    // removed.
    
    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 2, 0, 0, 0 };
        int[] arr2 = { 4, 5, 6 };

        int[] unionArray = mergeWithNoExtraSpace(arr1, 3, arr2, 3);

        System.out.println("Union of arrays: " + Arrays.toString(unionArray));
    }
}
