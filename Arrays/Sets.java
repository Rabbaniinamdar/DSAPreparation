package Arrays;
import java.util.HashSet;
import java.util.Set;

class Sets {

    // "I'll guide you through the Java code that solves a common problem of finding
    // a missing and a repeating element in an array.
    // This problem arises when you have an array containing distinct integers in a
    // given range, and one integer is missing while another appears more than
    // once."

    // Code Explanation:

    // HashSet Usage:

    // We use a HashSet named set to efficiently store the unique elements from the
    // input array.
    // HashSets provide fast membership checks and ensure that we can detect
    // repeating and missing elements effectively.
    // Finding Repeating and Missing Elements:

    // We iterate through the input array using an enhanced for loop.
    // For each element i, we first check if it's already present in the set. If it
    // is, it means i is the repeating element.
    // If it's not present, we add i to the set.
    // Finding Missing Element:

    // After identifying the repeating element, we use a traditional for loop to
    // iterate through numbers from 1 to n-1, where n is the length of the array.
    // If an element from this range is not found in the set, it indicates the
    // missing element.
    // Returning Result:

    // Finally, we return an array containing the repeating element and the missing
    // element.

    public static int[] missingAndRepeating(int arr[]) {
        Set<Integer> set = new HashSet<>();
        int missingNo = -1, ropeatingNO = -1;
        for (int i : arr) {
            if (set.contains(i)) {
                ropeatingNO = i;
            } else {
                set.add(i);
            }
        }
        for (int j = 1; j < arr.length; j++) {
            if (!set.contains(j)) {
                missingNo = j;
                break;
            }
        }
        return new int[] { ropeatingNO, missingNo };
    }

    // Introduction:

    // "I'll guide you through the Java code that aims to find the length of the
    // longest consecutive sequence in an array of integers.
    // This problem involves detecting the longest sequence of consecutive numbers
    // within the array and determining its length."

    // Code Explanation:

    // HashSet Usage:

    // We use a HashSet named set to efficiently store the unique elements from the
    // input array.
    // HashSets provide fast membership checks, which is crucial for this algorithm.
    // Storing Unique Elements:

    // We iterate through the input array using an enhanced for loop and add each
    // element to the set.
    // This step ensures that we eliminate duplicates from the array and have quick
    // access to each unique element.
    // Finding Longest Consecutive Sequence:

    // We maintain a variable maxLen to track the maximum length of consecutive
    // sequences found.
    // The primary loop iterates through each element in the set.
    // Checking for Sequence Start:

    // For each element num in the set, we check whether num - 1 exists in the set.
    // If it doesn't exist, it indicates that the current element is the start of a
    // new consecutive sequence.
    // Iterating to Find Sequence Length:

    // Once we identify the start of a sequence, we initialize currNum and currLen
    // to the current element and 1, respectively.
    // We use a while loop to keep incrementing currNum while the consecutive
    // elements (currNum + 1) exist in the set.
    // The currLen keeps track of the length of the current sequence.
    // Updating Maximum Length:

    // For each identified consecutive sequence, we update the maxLen to the maximum
    // of the current length and the previously stored maximum length.
    // Returning Result:

    // Finally, we return the calculated maxLen.

    public static int longestConsicutiveSequence(int arr[]) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int maxLen = 1;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currNum = num;
                int currLen = 1;
                while (set.contains(currNum + 1)) {
                    currNum++;
                    currLen++;
                }
                maxLen = Math.max(maxLen, currLen);
            }
        }
        return maxLen;
    }

    // this problem involves finding the unique element in an array where all other
    // elements appear twice."

    // Code Explanation:

    // HashSet Usage:

    // A HashSet named set is used to store the unique elements from the input
    // array.
    // It helps in fast membership checks and efficient removal of elements.
    // Identifying Single Number:

    // The code iterates through the input array using an enhanced for loop.
    // For each element i, it checks whether it's already present in the set.
    // If it is, the element is removed from the set since it appeared twice.
    // If it's not present, the element is added to the set.
    // Returning Result:

    // After processing the entire array, the set will contain only the unique
    // element that appears only once.
    // The iterator().next() method retrieves and returns this unique element.
    static int singleNumber(int arr[]) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        return set.iterator().next();
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 2, 3, 3, 12 };
        System.out.println((singleNumber(arr)));
    }
}