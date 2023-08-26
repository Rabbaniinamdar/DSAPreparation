package Arrays;
import java.util.ArrayList;
import java.util.List;

public class MajorityElement {
    // voting algorithm

    // In this problem, you're given an array of integers,
    // and the majority element is defined as the element that appears more than n/2
    // times in the array, where n is the length of the array. The task is to find
    // and return the majority element."

    // Code Explanation:

    // Initialization:

    // The n variable is set to the length of the input array nums.
    // The count variable keeps track of the frequency of the current element.
    // The el variable stores the current candidate for the majority element.
    // Finding Candidate:

    // The code iterates through the input array using a for loop.
    // For each element nums[i], it checks whether the count is 0. If it is, it
    // means there's currently no candidate, so the current element is assigned as
    // the candidate (potential majority element) and count is set to 1.
    // Incrementing or Decrementing Count:

    // If the current element nums[i] is the same as the candidate element el, then
    // count is incremented.
    // If the current element is different from the candidate element, count is
    // decremented.
    // Second Loop for Validation:

    // After the first loop, the candidate element el is found, but it's necessary
    // to validate that it's indeed the majority element.
    // The code uses a second for loop to count the occurrences of the candidate
    // element.
    // Validation Condition:

    // If the count of occurrences of the candidate element el is greater than n/2,
    // then it's confirmed as the majority element, and it's returned.
    // If not, -1 is returned to indicate that there is no majority element.

    public static int majorityElementI(int[] nums) {
        int n = nums.length;
        int count = 0;
        int element = 0;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                element = nums[i];
                count = 1;
            } else if (nums[i] == element) {
                count++;
            } else {
                count--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == element) {
                count++;
            }
        }
        if (count > n / 2) {
            return element;
        }
        return -1;
    }

    // In this problem, you're given an array of integers,
    // and the majority elements are defined as the elements that appear more than
    // n/3 times in the array, where n is the length of the array. The task is to
    // find and return all such majority elements."

    // Code Explanation:

    // Initialization:

    // The n variable is set to the length of the input array nums.
    // Two counters count1 and count2 are used to keep track of the frequency of two
    // potential majority elements.
    // Two variables element1 and element2 are used to store these two potential
    // majority elements.
    // Finding Potential Majority Elements:

    // The code iterates through the input array using a for loop.
    // It follows a voting algorithm-like approach. If the count1 is 0 (no potential
    // candidate for the first majority element) and the current element is not the
    // second majority element (element2), then the current element becomes a
    // potential candidate for the first majority element, and count1 is set to 1.
    // Similarly, if the count2 is 0 and the current element is not the first
    // majority element (element1), then the current element becomes a potential
    // candidate for the second majority element, and count2 is set to 1.
    // Incrementing or Decrementing Count:

    // If the current element nums[i] is the same as element1, then count1 is
    // incremented.
    // If the current element is the same as element2, then count2 is incremented.
    // If the current element is different from both element1 and element2, then
    // both count1 and count2 are decremented.
    // Second Loop for Validation:

    // After the first loop, two potential majority elements (element1 and element2)
    // are identified, but they need validation to determine if they indeed appear
    // more than n/3 times.
    // Validation and Result Building:

    // A second for loop counts the occurrences of each potential majority element.
    // If the count of occurrences of a potential majority element is greater than
    // n/3, it's added to the list.
    // Returning Result:

    // The list contains all the majority elements that appear more than n/3 times,
    // and it's returned.

    public static String majorityElementII(int[] nums) {
        int n = nums.length;
        int count1 = 0;
        int count2 = 0;

        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (count1 == 0 && element2 != nums[i]) {
                element1 = nums[i];
                count1 = 1;
            } else if (count2 == 0 && element1 != nums[i]) {
                element2 = nums[i];
                count2 = 1;
            } else if (nums[i] == element1) {
                count1++;
            } else if (nums[i] == element2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == element1) {
                count1++;
            }
            if (nums[i] == element2) {
                count2++;
            }
        }
        List<Integer> list = new ArrayList<>();

        if (count1 > n / 3) {
            list.add(element1);
        }
        if (count2 > n / 3) {
            list.add(element2);
        }
        return list.toString();
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2 };
        System.out.println(majorityElementII(arr));
    }
}
