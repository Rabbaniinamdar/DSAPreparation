package Arrays;
// "The goal of this code is to find the union of two arrays, 
// which means creating an array that contains all unique elements from both arrays. 
// To achieve this, we're using a HashSet, a data structure that automatically maintains
//  uniqueness of elements, ensuring that each element appears only once in the resulting union."

// Algorithm Explanation:

// "We have a method union that takes two arrays, arr1 and arr2, 
// as input and returns an array containing the union of their elements. 
// Here's a step-by-step breakdown of the algorithm:

// Initialization: 
// We start by creating a HashSet<Integer> named unionSet. 
// This set will automatically keep track of unique elements from both arrays.

// Adding Elements from the First Array:

// We loop through each element in arr1.
// For each element num, we add it to the unionSet. 
// The HashSet's uniqueness property ensures that duplicates are automatically removed.
// Adding Elements from the Second Array:

// We then loop through each element in arr2.
// Again, for each element num, we add it to the unionSet. 
// If it's already in the set, it won't be duplicated due to the HashSet's behavior.

// Converting HashSet to Array:

// We create an int array named unionArray with a size equal to the size of the unionSet. 
// This will be the final union of elements.
// We loop through the elements in the unionSet.
// For each element num, we add it to the unionArray at the current index and increment the index.
// Returning the Union Array:

// After processing all unique elements from both arrays, we return the unionArray as the result."

import java.util.*;

public class Union_intersction {
    public static int[] union(int[] arr1, int[] arr2) {
        Set<Integer> unionSet = new HashSet<>();

        // Add elements from the first array to the set
        for (int num : arr1) {
            unionSet.add(num);
        }

        // Add elements from the second array to the set
        for (int num : arr2) {
            unionSet.add(num);
        }

        // Convert the set to an array
        int[] unionArray = new int[unionSet.size()];
        int index = 0;
        for (int num : unionSet) {
            unionArray[index++] = num;
        }

        return unionArray;
    }

    // Introduction:

    // "The objective of this code is to find the intersection of two arrays, which
    // means identifying elements that are common to both arrays.
    // To achieve this, we're using two HashSets: one to store unique elements from
    // the first array,
    // and another to store the elements that are common between both arrays."

    // Algorithm Explanation:

    // "We have a method named intersection that takes two arrays, arr1 and arr2,
    // as input, and returns an array containing the intersection of their elements.
    // Here's a step-by-step explanation of the algorithm:

    // Initialization: We start by creating two HashSets: set and intersect.

    // set will store unique elements from the first array.
    // intersect will store elements that are common between both arrays.
    // Adding Elements from the First Array:

    // We loop through each element in arr1.
    // For each element num, we add it to the set. The HashSet's uniqueness property
    // ensures duplicates are automatically removed.
    // Finding Intersection:

    // We then loop through each element in arr2.
    // If the set contains the current element num, it means it's a common element.
    // In such cases, we add the element num to the intersect set.
    // Converting HashSet to Array:

    // After identifying common elements, we create an int array named
    // intersectArray with a size equal to the size of the intersect set. This will
    // be the final intersection of elements.
    // We loop through the elements in the intersect set.
    // For each element num, we add it to the intersectArray at the current index
    // and increment the index.
    // Returning the Intersection Array:

    // After processing all common elements, we return the intersectArray as the
    // result."

    public static int[] intesection(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();

        // Add elements from the first array to the set
        for (int num : arr1) {
            set.add(num);
        }

        // Add elements from the second array to the interset if intersect contains set
        for (int num : arr2) {
            if (set.contains(num)) {
                intersect.add(num);
            }
        }

        // Convert the set to an array
        int[] intersectArray = new int[intersect.size()];
        int index = 0;
        for (int num : intersect) {
            intersectArray[index++] = num;
        }

        return intersectArray;
    }

    // The minDifference function you've provided is aimed at finding the minimum
    // difference between the largest and smallest elements after removing exactly
    // three elements from the input array. Here's an explanation of the code:

    // Minimum Number of Elements Check:

    // The function checks if the length of the input array nums is less than 5. If
    // this condition is met, it immediately returns 0, as it's not possible to
    // remove three elements from a smaller array.
    // Initialization:

    // The variable min is initialized to Integer.MAX_VALUE. This will be used to
    // keep track of the minimum difference between the largest and smallest
    // elements after removing three elements.
    // Sorting the Array:

    // The input array nums is sorted in ascending order using Arrays.sort(nums).
    // Iterating Over Possible Removals:

    // The loop runs four times (i < 4), representing the four possible scenarios of
    // removing three elements:
    // The first three elements.
    // The last three elements.
    // The first two and the last one.
    // The first one and the last two.
    // Calculating Minimum Difference:

    // For each scenario, the difference between the largest element among the
    // remaining elements (nums[n-4+i]) and the smallest element among the remaining
    // elements (nums[i]) is calculated. This difference is compared with the
    // current value of min, and the smaller value is stored in min.
    // Return Minimum Difference:

    // After all scenarios are considered, the function returns the value of min,
    // representing the minimum difference between the largest and smallest elements
    // after removing three elements.

    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n < 5) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            min = Math.min(min, nums[n - 4 + i] - nums[i]);
        }
        return min;
    }

    // The findMedianSortedArrays function
    // you've provided aims to find the median of two sorted arrays arr1 and arr2.
    // Here's an explanation of the code:

    // Initialization:

    // Three pointers i, j, and k are initialized to 0 to keep track of the
    // positions in arr1, arr2, and the merged array arr.
    // Merged Array Initialization:

    // A new array arr of length m + n is created to store the merged elements of
    // arr1 and arr2.
    // Merging Sorted Arrays:

    // The loop runs while both pointers i and j are within their respective array
    // lengths.
    // If the element at arr1[i] is less than or equal to the element at arr2[j],
    // it's added to the merged array arr, and i and k are incremented.
    // If the element at arr1[i] is greater than the element at arr2[j], the element
    // at arr2[j] is added to the merged array arr, and j and k are incremented.
    // Remaining Elements:

    // After merging, if there are remaining elements in arr1, they are added to the
    // merged array.
    // Similarly, if there are remaining elements in arr2, they are added to the
    // merged array.
    // Calculating Median:

    // The length l of the merged array arr is calculated.
    // If l is odd, the median is the middle element at index l / 2.
    // If l is even, the median is the average of the elements at indices l / 2 - 1
    // and l / 2.
    // Return Median:

    // The calculated median value is returned.

    public static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int n = arr1.length;
        int m = arr2.length;

        int arr[] = new int[m + n];
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                arr[k++] = arr1[i++];
            } else {
                arr[k++] = arr2[j++];
            }
        }
        while (i < n) {
            arr[k++] = arr1[i++];
        }
        while (j < m) {
            arr[k++] = arr2[j++];
        }
        int l = arr.length;
        if (l % 2 == 1) {
            return arr[l / 2];
        } else {
            return (arr[l / 2 - 1] + arr[l / 2]) / 2.0;
        }
    }

    // Absolutely, I'll walk you through how the provided code works and how it
    // solves the problem of merging overlapping intervals.

    // Step 1: Sorting
    // The first step is to sort the given intervals based on their start values.
    // This is important because it allows us to easily identify overlapping
    // intervals later on.
    // The sorting is done using the Arrays.sort method along with a custom
    // Comparator that compares intervals based on their start values.

    // Step 2: Merging Process
    // After sorting the intervals, we initialize an empty list called ans (which is
    // equivalent to your ArrayList in the original code) to store the merged
    // intervals. We also keep track of the number of merged intervals using the
    // size variable.

    // Step 3: Iterating Through Intervals
    // We iterate through each interval in the sorted array. For each interval:

    // If the ans list is empty (no merged intervals yet), or if the start value of
    // the current interval is greater than the end value of the last merged
    // interval in ans, it means there is no overlap. In this case, we add the
    // current interval to the ans list as a new merged interval.

    // If there is an overlap, we update the end value of the last merged interval
    // in the ans list to be the maximum of its current end value and the end value
    // of the current interval. This effectively merges the overlapping intervals
    // into a single interval.

    // Step 4: Returning the Result
    // Once the merging process is complete, we create a 2D array called sol to hold
    // the final merged intervals. We copy the merged intervals from the ans list
    // into this array, and then return this array as the final result. The
    // Arrays.copyOf method is used to create a new array of the exact size needed
    // to hold the merged intervals.

    public int[][] mergeIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int a[], int b[]) {
                return a[0] - b[0];
            }
        });

        int[][] ans = new int[n][2];
        int size = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (size == 0 || intervals[i][0] > ans[size - 1][1]) {
                ans[size++] = new int[] { intervals[i][0], intervals[i][1] };
            } else {
                ans[size - 1][1] = Math.max(ans[size - 1][1], intervals[i][1]);
            }
        }
        return Arrays.copyOf(ans, size);
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 2, 0, 0, 0 };
        int[] arr2 = { 4, 5, 6 };

        int[] unionArray = intesection(arr1, arr2);

        System.out.println("Union of arrays: " + Arrays.toString(unionArray));
    }
}
