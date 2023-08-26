package Arrays;
// "The Dutch National Flag problem 

// is a classic sorting problem where we are given an array containing only three distinct elements: 0, 1, and 2. 
// The task is to sort this array in non-decreasing order in linear time complexity without using any sorting algorithms.
//  The solution to this problem is often called the 'Dutch National Flag algorithm'."

// Initialization: We start with three pointers: low, mid, and high. Initially, low and mid both point to the beginning of the array, and high points to the end of the array.
                                                                                                                                                                                                            
// Partitioning:
// As we traverse the array using the mid pointer, we compare the value at arr[mid]:
// If it's 0, we swap the value at arr[low] with arr[mid], and increment both low and mid. This effectively moves the 0 to the left partition.
// If it's 1, we simply increment mid to keep it in the middle partition.
// If it's 2, we swap the value at arr[mid] with arr[high], and decrement high. This effectively moves the 2 to the right partition.

// Termination: We continue this process until mid is less than or equal to high. Once mid exceeds high, the array is sorted.

public class ThreePointerApproach {
    static int[] sort012(int arr[]) {
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                swap(arr, mid, high);
                high--;
            }
        }
        return arr;
    }

    // The task here is to rearrange an array such that all the negative numbers are
    // moved to the back while maintaining the relative order of positive or
    // non-negative numbers.
    // This algorithm allows us to reorganize an array in a way that's useful for
    // various scenarios, such as segregating elements based on certain criteria."

    // Algorithm Explanation:

    // "The algorithm uses a three-pointer approach to traverse and rearrange the
    // array. Here's a step-by-step explanation of how it works:

    // Initialization: We start with three pointers: low, mid, and high.

    // low indicates the position where the next positive or non-negative element
    // should be placed.
    // mid is used to traverse through the array.
    // high points to the last element of the array.
    // Iterating Through the Array:

    // As we traverse the array using the mid pointer, we examine the element at
    // arr[mid]:
    // If it's a negative number, we swap it with the element at arr[low] and
    // increment both low and mid. This shifts the negative number towards the back
    // of the array.
    // If it's a positive or non-negative number, we only increment mid to continue
    // traversing.

    // Reordered Array:
    // After the iteration, the negative numbers are moved to the back of the array
    // while preserving the order of negative numbers. The low
    // pointer now indicates the position where positive or non-negative numbers
    // start.
    // Return Modified Array:

    // We return the modified array, which now has all negative numbers moved to the
    // back while keeping the order."
    static int[] MoveNegBack(int arr[]) {
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] < 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else {
                mid++;
            }
        }
        return arr;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int arr[] = { -11, 2, -1, 0, -1, -32, 0, -62 };
        int ans[] = MoveNegBack(arr);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
