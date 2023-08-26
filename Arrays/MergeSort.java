package Arrays;
public class MergeSort {

    // Merger sort

    public static int[] merge(int[] arr, int low, int mid, int high) {
        int merge[] = new int[high - low + 1];
        int idx1 = low;
        int idx2 = mid + 1;
        int k = 0;
        while (idx1 <= mid && idx2 <= high) {
            if (arr[idx1] <= arr[idx2]) {
                merge[k++] = arr[idx1++];
            } else {
                merge[k++] = arr[idx2++];
            }
        }
        while (idx1 <= mid) {
            merge[k++] = arr[idx1++];
        }
        while (idx2 <= high) {
            merge[k++] = arr[idx2++];
        }
        for (int i = low; i <= high; i++) {
            arr[i] = merge[i - low];
        }
        return arr;
    }

    public static int[] MergeSorts(int arr[], int low, int high) {
        if (low >= high) {
            return arr;
        }
        int mid = (low + high) / 2;
        MergeSorts(arr, low, mid);
        MergeSorts(arr, mid + 1, high);
        return merge(arr, low, mid, high);
    }

    public static int mergePairs(int[] arr, int low, int mid, int high) {
        int merge[] = new int[high - low + 1];
        int idx1 = low;
        int idx2 = mid + 1;
        int k = 0;
        int cnt = 0;
        while (idx1 <= mid && idx2 <= high) {
            if (arr[idx1] <= arr[idx2]) {
                merge[k++] = arr[idx1++];
            } else {
                merge[k++] = arr[idx2++];
                cnt += (mid - idx1 + 1);
            }
        }
        while (idx1 <= mid) {
            merge[k++] = arr[idx1++];
        }
        while (idx2 <= high) {
            merge[k++] = arr[idx2++];
        }
        for (int i = low; i <= high; i++) {
            arr[i] = merge[i - low];
        }
        return cnt;
    }

    // count the number of reverse pairs in an array
    // using the merge sort algorithm.
    public static int countPairs(int[] nums, int start, int mid, int end) {
        int right = mid + 1;
        int count = 0;
        for (int i = start; i <= mid; i++) {
            while (right <= end && nums[i] > 2 * nums[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }

    public static int mergeSortPairs(int arr[], int low, int high) {
        int count = 0;
        if (low >= high) {
            return count;
        }
        int mid = (low + high) / 2;
        count += mergeSortPairs(arr, low, mid);
        count += mergeSortPairs(arr, mid + 1, high);
        count += countPairs(arr, low, mid, high);
        mergePairs(arr, low, mid, high);
        return count;
    }

    public static int reversePairs(int[] nums) {
        return mergeSortPairs(nums, 0, nums.length - 1);
    }

    // count the number of inversions in an array using the modified merge sort
    // approach. Inversions occur when elements in an array are out of order with
    // respect to their indices. Here's an overview of the code:
    public static int mergeSortInversion(int nums[], int start, int end) {
        int count = 0;
        if (start >= end) {
            return count;
        }
        int mid = (start + end) / 2;
        count += mergeSortInversion(nums, start, mid);
        count += mergeSortInversion(nums, mid + 1, end);
        count += mergePairs(nums, start, mid, end);
        return count;
    }

    public static int numberOfInversions(int[] a, int n) {
        // Count the number of pairs:
        return mergeSortPairs(a, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] a = { 1, 3, 2, 3, 1 };
        int cnt = reversePairs(a);
        System.out.println("The number of reverse pair is: " + cnt);
    }
}
