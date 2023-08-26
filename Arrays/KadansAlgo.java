
// Initialize two variables: maxSum to store the maximum subarray sum found so far and sum to keep track of the current subarray sum.

// Start iterating through the array from the second element (index 1).
// For each element in the array:
// a. Compare the current element with the sum of the current element and the previous sum. Take the maximum of the two.
// b. Update the sum to be the greater value between the current element and the sum of the current element and the previous sum.
// c. Update maxSum to be the greater value between maxSum and the updated sum.

// After iterating through the entire array, maxSum will hold the maximum subarray sum.
// Return the maxSum as the result.

import java.util.HashMap;
import java.util.Map;

public class KadansAlgo {
    public static int kadansAlgorithem(int arr[]) {
        int n = arr.length;
        int maxSum = arr[0];
        int sum = arr[0];
        for (int i = 1; i < n; i++) {
            sum = Math.max(sum, sum + arr[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static int maximumProductBruteforce(int arr[]) {
        int maxProduct = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int product = 1;
            for (int j = i; j < arr.length; j++) {
                product *= arr[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }

    // 1.Initialize three variables: product1, product2, and product to keep track
    // of
    // the maximum product of subarrays. Initialize them with the first element of
    // the array.

    // 2.Iterate through the array starting from the second element.

    // 3.For each element in the array:
    // a. Calculate three values:

    // temp: The maximum value among the current element, the product of product1
    // and the current element, and the product of product2 and the current element.
    // product2: The minimum value among the current element, the product of
    // product1 and the current element, and the product of product2 and the current
    // element.
    // product1: Assign the value of temp to product1.
    // b. Compare the current product with the updated product1, and assign the
    // greater value to product.
    // 4.After iterating through the entire array, product will hold the maximum
    // product of subarrays.

    // 5.Return the value of product as the result.
    public static int maximumProductOptimal(int arr[]) {
        int product1 = arr[0];
        int product2 = arr[0];
        int product = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int temp = Math.max(arr[i], Math.max(product1 * arr[i], product2 * arr[i]));
            product2 = Math.min(arr[i], Math.min(product1 * arr[i], product2 * arr[i]));
            product1 = temp;
            product = Math.max(product, product1);
        }
        return product;
    }

    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int ct = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    ct++;
                }
            }
        }
        return ct;
    }

    // Certainly! Here's how you could explain the solution to the interviewer:

    // Interviewer: "Could you please explain how your solution works for the
    // subarraySum problem?"

    // You: "Of course! The subarraySum problem involves counting the number of
    // subarrays within an
    // array that have a sum equal to a given target value k. I've used a technique
    // inspired by Kadane's Algorithm to efficiently solve this problem. Here's how
    // it works:

    // We start by initializing a few variables:

    // count to keep track of the number of valid subarrays.
    // sum to calculate the cumulative sum while iterating through the array.
    // A prefixSumCount map to store prefix sums and their counts.
    // We loop through the array once:

    // For each element in the array, we update the sum by adding the current
    // element.
    // We then check whether the value sum - k exists in our prefixSumCount map. If
    // it does, it means there's a subarray with the desired sum. We increment the
    // count accordingly.
    // We update the prefixSumCount map with the current sum, either by adding a new
    // entry or incrementing the count for an existing entry.
    // Finally, after the loop, the count variable holds the count of valid
    // subarrays with the sum equal to k. We return this count as the final result.
    public static int subarraySumOptimal(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (prefixSumCount.containsKey(sum - k)) {
                count += prefixSumCount.get(sum - k);
            }
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    // The longestSubArrayZero function you've provided is used to find the length
    // of the longest subarray
    // in an array whose sum is equal to zero. This algorithm involves using nested
    // loops to iterate through different subarray combinations and checking if
    // their sum is zero. Here's an explanation of the code:

    // Initialization:

    // Initialize the n variable with the length of the input array nums.
    // Initialize the ct variable to keep track of the length of the longest
    // subarray with sum zero.
    // Outer Loop (Starting Point of Subarray):

    // Start an outer loop that iterates through the array from index 0 to n-1. This
    // represents the starting index of the subarray.
    // Inner Loop (Ending Point of Subarray):

    // Start an inner loop that iterates from the current outer loop index i to n-1.
    // This represents the ending index of the subarray.
    // Calculating Subarray Sum:

    // Within the inner loop, calculate the sum of the elements from index i to j.
    // Accumulate the sum in the sum variable.
    // Checking Sum and Updating Count:

    // If the calculated sum is equal to zero, update the ct variable to the maximum
    // value between the current ct and j - i + 1. This ensures that you're
    // capturing the length of the longest subarray with sum zero.
    // Returning the Count:

    // After both loops complete, return the value of ct as the length of the
    // longest subarray with sum zero.

    public static int longestSubArrayZero(int[] nums, int k) {
        int n = nums.length;
        int ct = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    ct = Math.max(ct, j - i + 1);
                }
            }
        }
        return ct;
    }

    // You: The key idea behind the modification is that if we encounter the
    // same cumulative sum while traversing the array, it means that the sum of
    // elements between the two occurrences is zero. This is because the difference
    // between their cumulative sums will be zero.

    // Interviewer: Interesting! Could you walk me through the steps of your
    // solution?

    // You: Absolutely! Here's how the solution works step by step:

    // We maintain a hashmap called sumToIndex to store cumulative sums along with
    // their corresponding indices. We initialize it with an entry (0, -1) to
    // represent the initial cumulative sum of 0 at index -1.

    // As we traverse through the array, we keep calculating the cumulative sum by
    // adding the current element to the sum.

    // At each step, we check if the current cumulative sum exists in the sumToIndex
    // hashmap.

    // If the sum already exists, it means we've encountered the same cumulative sum
    // before, indicating that the sum of elements between the two occurrences is
    // zero. We calculate the length of this subarray as the difference between the
    // current index and the index stored in the hashmap. We update the maxLen if
    // this length is greater.

    // If the sum doesn't exist in the hashmap, we store it along with the current
    // index.

    // Finally, we return the maxLen, which represents the length of the longest
    // subarray with sum zero.

    public static int longestSubArrayZeroOptimal(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        int sum = 0;

        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1); // Initial sum of 0 at index -1

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sumToIndex.containsKey(sum)) {
                int len = i - sumToIndex.get(sum);
                maxLen = Math.max(maxLen, len);
            } else {
                sumToIndex.put(sum, i);
            }
        }

        return maxLen;
    }

    // The provided code aims to determine whether a given array is an "ideal
    // permutation"
    // based on certain properties of local and global inversions.

    // Local Inversions: A local inversion occurs when an element is greater than
    // its immediate adjacent element. For example, in the array [3, 1, 2], [3, 1]
    // and [2, 1] are local inversions.

    // Global Inversions: A global inversion occurs when an element is greater than
    // an element later in the array. For example, in the array [2, 0, 1], [2, 0]
    // and [2, 1] are global inversions.

    // Ideal Permutation: An ideal permutation is one where every local inversion is
    // also a global inversion. In simpler terms, this means that elements can be
    // rearranged in such a way that no local inversion violates the global
    // inversion condition.

    // Approach:

    // The code follows a straightforward approach to check if a permutation is
    // ideal by iterating through the array and considering properties of local and
    // global inversions.

    // Initialize maxSeen to -1. This variable will keep track of the maximum value
    // seen so far while iterating through the array.

    // Loop through the array using an index i ranging from 0 to arr.length - 2. The
    // reasoning for going up to arr.length - 2 is to ensure that we can check the
    // element at an offset of 2.

    // Inside the loop, update maxSeen to be the maximum of its current value and
    // the current element at index i. This helps us keep track of the largest
    // element seen so far.

    // Check if the maximum value seen so far (maxSeen) is greater than the element
    // at an offset of 2 from the current element (arr[i + 2]). If this condition is
    // met, it indicates that there's a global inversion that is not a local
    // inversion. In this case, we return false as the permutation cannot be ideal.

    // If we iterate through the entire array without finding such a global
    // inversion, we can conclude that the permutation is ideal, and we return true.
    public static boolean isIdealPermutation(int[] arr) {
        int maxSeen = -1;

        for (int i = 0; i < arr.length - 2; i++) {
            maxSeen = Math.max(maxSeen, arr[i]);
            if (maxSeen > arr[i + 2]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 3, 1, 2, 4 };
        System.out.println(isIdealPermutation(arr));
    }
}