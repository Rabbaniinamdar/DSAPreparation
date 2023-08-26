package Arrays;

// The nextPer method finds the next permutation of the given array. 
// It does this in three main steps:

// a. Finding the First Decreasing Element (ind1): It iterates from the right of the array to find the first element that is smaller than the element to its right. The index of this element is stored in ind1.

// b. Checking for No Decreasing Element (ind1 == -1): If no such decreasing element is found (ind1 == -1), it means the array is in descending order, and there's no next permutation. In this case, the method reverses the entire array, resulting in the smallest permutation (last permutation).

// c. Finding the Smallest Element Larger Than arr[ind1] (ind2): If there's a decreasing element found (ind1 != -1), the method searches from the right of the array to find the smallest element that is larger than arr[ind1]. The index of this element is stored in ind2.

// d. Swapping Elements and Reversing:

// The method swaps the elements at indices ind1 and ind2.
// It then reverses the portion of the array to the right of index ind1.

class nextPermutation {
    public static void nextPer(int arr[]) {
        int ind1 = -1;
        int ind2 = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                ind1 = i;
                break;
            }
        }
        if (ind1 == -1) {
            reverse(arr, 0);
        } else {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] > arr[ind1]) {
                    ind2 = i;
                    break;
                }
            }
            swap(arr, ind1, ind2);
            reverse(arr, ind1 + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    // The method missingNumber takes an integer array nums as input.

    // It calculates the length of the input array nums and stores it in the
    // variable n.

    // The expected sum of a sequence of consecutive integers from 0 to n
    // (inclusive) can be
    // calculated using the formula (n * (n + 1)) / 2. This is stored in the
    // variable expectedSum.

    // The code then iterates through the elements in the nums array using an
    // enhanced for loop.

    // In each iteration, the value of the current element is added to the variable
    // actualSum.

    // After iterating through all elements in the array, the method returns the
    // difference between the expectedSum and the actualSum.
    // This difference represents the missing number in the sequence.


    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = (n * (n + 1)) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        nextPer(arr);
    }
}