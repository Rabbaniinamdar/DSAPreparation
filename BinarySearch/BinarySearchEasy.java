package BinarySearch;
// The search method takes in two parameters: 
// the sorted array nums and the target value we're looking for.

// The method initializes two pointers, st and ed, representing the start and end indices of the current search range within the array. 
// Initially, st points to the first element (index 0) and ed points to the last element (index nums.length - 1).

// Inside a while loop, the method continues to search as long as st is less than or equal to ed, meaning there are still elements in the search range.

// Within each iteration of the loop, the method calculates the mid index using the formula st + (ed - st) / 2.
//  This calculates the middle index of the current search range.

// It compares the value at the mid index, nums[mid], with the target value.

// If nums[mid] is equal to target, it means we've found the target value, and the method returns mid as the index.
// If nums[mid] is less than target, we know that the target, if present, must be on the right side of the mid index.
//  So, we update st to mid + 1, effectively narrowing the search range to the right half.
// If nums[mid] is greater than target, we update ed to mid - 1, narrowing the search range to the left half.
// The loop continues to divide the search range in half with each iteration until st becomes greater than ed,
//  indicating that the search range has become empty. At this point, if the target hasn't been found, the method
//   returns -1 to indicate that the target value is not present in the array.

import java.util.Arrays;

public class BinarySearchEasy {
    public int search(int[] nums, int target) {
        int st = 0, ed = nums.length - 1;
        int mid = -1;
        while (st <= ed) {
            mid = st + (ed - st) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }
        return -1;
    }

    // You: Certainly. This code uses a binary search approach to efficiently search
    // for a target value within a sorted 2D matrix.

    // The searchMatrix method takes in two parameters: a 2D matrix matrix and the
    // target value we're looking for.

    // It first checks if the matrix is null, has no rows, or has no columns. If any
    // of these conditions are true,
    // it immediately returns false, as there are no elements to search.

    // The dimensions of the matrix are calculated: m represents the number of rows,
    // and n represents the number of columns.

    // The start variable is initialized to 0, which represents the index of the
    // first element in the flattened matrix, and end is initialized to m * n - 1,
    // which represents the index of the last element.

    // The main part of the code is the while loop that runs as long as start is
    // less than or equal to end.

    // In each iteration of the loop, the code calculates the middle index mid using
    // the formula (start + end) / 2.

    // The middle index mid is then converted to a row index midX and a column index
    // midY. This conversion is done using division and modulo operations with n.

    // The code checks if the element at the matrix position matrix[midX][midY] is
    // equal to the target value.

    // If they are equal, the target is found, and the method returns true.
    // If the element is less than the target, it means the target, if present, must
    // be in the right half of the current search range. So, start is updated to mid
    // + 1.
    // If the element is greater than the target, it means the target, if present,
    // must be in the left half of the current search range. So, end is updated to
    // mid - 1.
    // The loop continues to divide the search range in half with each iteration
    // until start becomes greater than end, indicating that the search range has
    // become empty. At this point, if the target hasn't been found, the method
    // returns false.

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int midX = mid / n;
            int midY = mid % n;

            if (matrix[midX][midY] == target)
                return true;
            else if (matrix[midX][midY] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return false;
    }

    // Let's break down the code and explain how it works:

    // The searchInsert method takes two parameters: a sorted array nums and the
    // target
    // value we want to insert or find.

    // It initializes three variables: n, which stores the length of the input array
    // nums; st, which represents the start index of the current search range; and
    // ed, which represents the end index of the current search range.

    // The code enters a while loop that continues as long as the start index st is
    // less than or equal to the end index ed.

    // In each iteration of the loop, the code calculates the middle index mid using
    // the formula (st + ed) / 2.

    // The value at index mid in the nums array, nums[mid], is then compared with
    // the target value.

    // If nums[mid] is equal to target, it means the target value is already present
    // in the array, and the method returns mid.
    // If nums[mid] is less than target, it means the target, if inserted, must be
    // on the right side of the mid index. So, the st index is updated to mid + 1,
    // effectively narrowing the search range to the right half.
    // If nums[mid] is greater than target, it means the target, if inserted, must
    // be on the left side of the mid index. So, the ed index is updated to mid - 1,
    // narrowing the search range to the left half.
    // The loop continues to divide the search range in half with each iteration
    // until the start index st becomes greater than the end index ed. At this
    // point, the st index represents the position where the target value should be
    // inserted to maintain the sorted order.

    // Finally, the method returns the value of st, which is the appropriate index
    // for inserting the target value.

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int st = 0;
        int ed = n - 1;
        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }
        return st;
    }

    // This code is for finding the unique element in a sorted array where all
    // other elements appear exactly twice.

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int st = 1;
        int ed = n - 2;
        if (n == 1)
            return nums[0];
        if (nums[0] != nums[1])
            return nums[0];
        if (nums[n - 1] != nums[n - 2])
            return nums[n - 1];

        while (st <= ed) {
            int mid = st + (ed - st) / 2;
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }
            if (mid % 2 == 1 && nums[mid] == nums[mid - 1] || mid % 2 == 0 && nums[mid] == nums[mid + 1]) {
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;

    }

    public int findFirst(int[] nums, int target) {
        int st = 0, ed = nums.length - 1;
        int idx = -1;
        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (nums[mid] == target) {
                idx = mid;
                ed = mid - 1;
            } else if (nums[mid] < target) {
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }
        return idx;
    }

    public int findLast(int[] nums, int target) {
        int st = 0, ed = nums.length - 1;
        int idx = -1;
        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (nums[mid] == target) {
                idx = mid;
                st = mid + 1;
            } else if (nums[mid] < target) {
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }
        return idx;
    }

    // This Java code defines a class Solution that finds a peak element in an array
    // using a binary search approach.
    // A peak element is an element that is greater than its neighbors.

    public int findPeakElement(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return 0;
        if (arr[0] > arr[1])
            return 0;
        if (arr[n - 1] > arr[n - 2])
            return n - 1;
        int st = 1, ed = n - 2;
        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (arr[mid - 1] < arr[mid]) {
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }
        return -1;
    }

    // . This code is an implementation of binary search specifically designed to
    // search for a target value in a rotated and sorted array.

    public int searchInRotated(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < nums[high]) {
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    // This function is used to find the index of the upper bound of the target
    // value in the sorted array. The upper bound is the smallest index at which the
    // element is strictly greater than the target.

    public static int findUpperbond(int[] nums, int target) {
        int st = 0, ed = nums.length - 1;
        int idx = -1;
        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (nums[mid] > target) {
                idx = mid;
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return idx;
    }

    // This function is used to find the index of the lower bound of the target
    // value in the sorted array. The lower bound is the smallest index at which the
    // element is greater than or equal to the target.
    public static int findLowerbond(int[] nums, int target) {
        int st = 0, ed = nums.length - 1;
        int idx = -1;
        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (nums[mid] >= target) {
                idx = mid;
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return idx;
    }

    public int findKthPositive(int[] arr, int k) {
        // for(int i=0;i<arr.length;i++){
        // if(arr[i]<=k){
        // k++;
        // }
        // else{
        // break;
        // }
        // }
        // return k;
        int st = 0, ed = arr.length - 1;
        while (st <= ed) {
            int mid = (st + ed) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }
        return st + k;
    }

    // This code is designed to find the minimum element in a rotated and sorted
    // array. In other words, it's looking for the value that was originally at the
    // beginning of the sorted array before the rotation occurred.

    public int findMin(int[] nums) {
        int n = nums.length;
        int st = 0, ed = n - 1;
        while (st < ed) {
            int mid = (st + ed) / 2;
            if (nums[mid] == nums[ed]) {
                return nums[st];
            }
            if (nums[mid] > nums[ed]) {
                st = mid + 1;
            } else {
                ed = mid;
            }
        }
        return nums[st];
    }

    // The floor of x is the largest element in the array that is smaller than or
    // equal to x
    static int findFloor(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] <= x) {
                ans = arr[mid];
                // look for smaller index on the left
                low = mid + 1;
            } else {
                high = mid - 1; // look on the right
            }
        }
        return ans;
    }

    // ceiling of x is the smallest element in the array that is greater than or
    // equal to x.
    static int findCeil(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] >= x) {
                ans = arr[mid];
                // look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

    public static int findKRotation(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // If the search space is already sorted:
            if (arr[low] < arr[high]) {
                if (arr[low] < ans) {
                    ans = arr[low];
                    index = low;
                }
                break;
            }
            // If left part is sorted:
            if (arr[low] <= arr[mid]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                low = mid + 1; // Eliminate left half
            } else { // If right part is sorted:
                if (arr[mid] < ans) {
                    index = mid;
                    ans = arr[mid];
                }
                high = mid - 1; // Eliminate right half
            }
        }
        return index;
    }

    // calculates the floor square root of a given positive integer n using a binary
    // search approach. The floor square root of an integer n is the largest integer
    // x such that x*x is less than or equal to n.

    public static int floorSqrt(int n) {
        int low = 1, high = n;
        // Binary search on the answers:
        while (low <= high) {
            int mid = (low + high) / 2;
            int val = mid * mid;
            if (val <= (n)) {
                // eliminate the left half:
                low = (mid + 1);
            } else {
                // eliminate the right half:
                high = (mid - 1);
            }
        }
        return high;
    }

    // This function finds the smallest divisor such that the sum of quotients
    // obtained by dividing each element of the array by the divisor does not exceed
    // the given threshold.

    public int sumDiv(int arr[], int div) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.ceil(((double) arr[i]) / (double) div);
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxi = Math.max(maxi, nums[i]);
        }
        int ans = -1;
        int st = 0, ed = maxi;

        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (sumDiv(nums, mid) <= threshold) {
                ans = mid;
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return ans;
    }

    // The provided code defines a function aggressiveCows that solves the
    // "Aggressive Cows" problem using binary search. This problem involves placing
    // a certain number of cows in stalls along a straight path, while maximizing
    // the minimum distance between any two cows. The goal is to find the maximum
    // possible minimum distance.
    public static int aggressiveCows(int arr[], int cows) {
        Arrays.sort(arr); // Sort the array in ascending order
        int low = 0, high = arr[arr.length - 1] - arr[0];

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWePlace(arr, mid, cows)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    static boolean canWePlace(int[] arr, int mid, int cows) {
        int cntCows = 1, last = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - last >= mid) {
                cntCows++;
                last = arr[i];
            }
            if (cntCows >= cows)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2, 3 };
        int ans = findKRotation(arr);
        System.out.println("The array is rotated " + ans + " times.");
    }
}
