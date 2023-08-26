package Arrays;
import java.util.*;

public class Sum {
    static int[] towSumApproach1(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int currentSum = arr[start] + arr[end];
            if (currentSum == target) {
                return new int[] { start, end };
            } else if (currentSum < target) {
                start++;
            } else {
                end--;
            }
        }
        return new int[] { 0, 0 };
    }

    // Introduction:

    // "I'll walk you through the Java code for solving the Two Sum problem using
    // the second approach, which utilizes a HashMap.
    // This approach is highly versatile and efficient for finding pairs of elements
    // that sum up to a given target value."

    // Code Explanation:

    // HashMap Usage:

    // We use a HashMap to store elements from the array along with their indices.
    // The HashMap enables efficient lookups to find whether a specific element's
    // complementary value (target minus the current element) has been seen before.
    // Iterating Through the Array:

    // We iterate through the input array using a for loop.
    // For each element arr[i], we check if target - arr[i] is already present in
    // the HashMap.
    // Finding a Pair:

    // If the complementary value is found in the HashMap, it means we've already
    // seen an element that, when added to the current element, results in the
    // target sum.
    // We return a new integer array containing the indices of the two elements that
    // form the pair.
    // Storing Elements in the HashMap:

    // If the complementary value is not found in the HashMap, we haven't
    // encountered a suitable pair yet. So, we add the current element to the
    // HashMap with its index.
    // Fallback Value:

    // If no pair is found in the entire array, we return a default value [0, 0] to
    // indicate that no valid pair was found.
    static int[] towSumApproach2(int arr[], int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                return new int[] { map.get(target - arr[i]), i };
            }
            map.put(arr[i], i);
        }
        return new int[] { 0, 0 };
    }

    // Introduction:

    // "I'll walk you through the Java code that aims to find all unique sets of
    // three elements in an array that sum up to zero.
    // This problem is commonly referred to as the Three Sum problem. The code
    // demonstrates a two-pointer approach that efficiently solves this problem."

    // Code Explanation:

    // HashSet for Uniqueness:

    // We use a HashSet named list to store the unique sets of three elements that
    // sum up to zero.
    // HashSets are used here to automatically ensure uniqueness of sets, preventing
    // duplicates from being added.
    // Iterating Through Array:

    // The outer loop iterates through the array until the third-to-last element (to
    // leave room for the two-pointer pairs).
    // For each ith element, we set two pointers, mid and end, one starting from the
    // next element and the other from the end of the array.
    // Finding Triplet:

    // For each combination of i, mid, and end, we calculate the currentSum as the
    // sum of the three elements.
    // If the currentSum is zero, we've found a triplet that sums to zero.
    // We add this triplet as a list to the list HashSet.
    // Moving Pointers:

    // If currentSum is less than zero, we increment mid (moving to a larger
    // element) to potentially increase the sum.
    // If currentSum is greater than zero, we decrement end (moving to a smaller
    // element) to potentially decrease the sum.
    // Returning Result:

    // Finally, we convert the HashSet list to an ArrayList and return it.
    static List<List<Integer>> threeSum(int arr[]) {
        Set<List<Integer>> list = new HashSet<>();
        for (int i = 0; i < arr.length - 2; i++) {
            int mid = i + 1;
            int end = arr.length - 1;
            while (mid < end) {
                int currentSum = arr[i] + arr[mid] + arr[end];
                if (currentSum == 0) {
                    list.add(List.of(arr[i], arr[mid], arr[end]));
                    mid++;
                    end--;
                } else if (currentSum < 0) {
                    mid++;
                } else {
                    end--;
                }
            }
        }
        return new ArrayList<>(list);
    }

    // "I'll walk you through the Java code for solving the Four Sum problem.
    // This problem involves finding all unique sets of four elements in an array
    // that sum up to a given target value. The code demonstrates a nested
    // two-pointer approach that efficiently solves this problem."

    // Code Explanation:

    // HashSet for Uniqueness:

    // Similar to the Three Sum solution, we use a HashSet named list to store the
    // unique sets of four elements that sum up to the target value.
    // HashSets are used to ensure the uniqueness of sets and prevent duplicates.
    // Double Nested Loop:

    // The code utilizes two nested loops:
    // The outer loop iterates through the array until the fourth-to-last element.
    // The inner loop iterates through the array starting from the element after the
    // current outer loop index.
    // Two-Pointer Approach:

    // For each pair of elements arr[i] and arr[j], where i is the outer loop index
    // and j is the inner loop index, we employ a two-pointer approach to find the
    // other two elements.
    // The two pointers, mid and end, start from the elements immediately after
    // arr[j] and the last element of the array, respectively.
    // Finding Quadruplet:

    // For each combination of i, j, mid, and end, we calculate the currentSum as
    // the sum of the four elements.
    // If the currentSum is equal to the target sum, we've found a quadruplet that
    // meets the requirement.
    // We add this quadruplet as a list to the list HashSet.
    // Moving Pointers:

    // If currentSum is less than the target sum, we increment mid (moving to a
    // larger element) to potentially increase the sum.
    // If currentSum is greater than the target sum, we decrement end (moving to a
    // smaller element) to potentially decrease the sum.
    // Returning Result:

    // Finally, we convert the HashSet list to an ArrayList and return it.
    
    static List<List<Integer>> fourSum(int arr[], int target) {
        Set<List<Integer>> list = new HashSet<>();
        for (int i = 0; i < arr.length - 3; i++) {
            for (int j = i + 1; j < arr.length - 2; j++) {
                int mid = j + 1;
                int end = arr.length - 1;
                while (mid < end) {
                    int currentSum = arr[i] + arr[j] + arr[mid] + arr[end];
                    if (currentSum == target) {
                        list.add(List.of(arr[i], arr[j], arr[mid], arr[end]));
                        mid++;
                        end--;
                    } else if (currentSum < target) {
                        mid++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return new ArrayList<>(list);
    }

    public static void main(String[] args) {
        int arr[] = { 4, -5, 3, 1, 1, 7, 8, 4 };
        List<List<Integer>> ans = fourSum(arr, 10);
        for (List<Integer> list : ans) {
            System.err.println(list);
        }
    }
}
