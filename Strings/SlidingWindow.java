package Strings;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SlidingWindow {

    // he longestSubstringNoRepeat method is designed to find the length of the
    // longest substring within a given string that does not contain any repeating
    // characters.
    static int longestSubstringNoRepeat(String str) {
        Set<Character> set = new HashSet<>(); // Create a set to track characters in the current substring.
        int i = 0, j = 0, max = 0; // Initialize pointers and a variable to track maximum length.

        while (j < str.length()) { // Loop through the string with the second pointer.
            if (!set.contains(str.charAt(j))) {
                // If the character at j is not in the set (no repeat), add it to the set, move
                // j, and update max.
                set.add(str.charAt(j++));
                max = Math.max(max, set.size()); // Update max with the size of the current non-repeating substring.
            } else {
                // If the character at j is already in the set (repeat), remove the character at
                // i from the set and move i.
                set.remove(str.charAt(i++));
            }
        }
        return max; // Return the maximum length of a substring with no repeating characters.
    }

    // This class contains a method to count the occurrences of each character in a
    // given string.
    static void occurenceOfCharacter(String str) {
        int[] count = new int[256]; // Create an array to hold the count of each character.
        str = str.toLowerCase(); // Convert the input string to lowercase for case-insensitive counting.

        // Loop through the characters in the string and update the count array.
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }

        // Loop through the characters again to print the occurrences.
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] != 0 && str.charAt(i) != ' ') {
                System.out.println(str.charAt(i) + ":" + count[str.charAt(i)]);
                count[str.charAt(i)] = 0; // Reset the count to avoid duplicate printing.
            }
        }
    }

    // Problem: Determine if two given strings are isomorphic. Two strings are
    // isomorphic if characters from the first string can be replaced to get the
    // second string while preserving the order of characters.
    static boolean isIsomorphic(String str1, String str2) {
        // Initialize character frequency maps for both strings
        int map1[] = new int[256];
        int map2[] = new int[256];

        // Check if lengths of both strings are equal
        if (str1.length() != str2.length()) {
            return false; // If lengths differ, strings can't be isomorphic
        }

        // Compare characters and their mappings in both strings
        for (int i = 0; i < str1.length(); i++) {
            if (map1[str1.charAt(i)] != map2[str2.charAt(i)]) {
                return false; // If mappings differ, strings are not isomorphic
            }
            map1[str1.charAt(i)]++;
            map2[str2.charAt(i)]++;
        }
        return true; // If all characters' mappings match, strings are isomorphic
    }

    // Problem: Sort characters in a string based on their frequency. Given a
    // string, create a new string where characters are sorted in decreasing order
    // of their frequency.
    public static String sortCharacterFreq(String s) {
        // Initialize character frequency count array
        char count[] = new char[256];

        // Count character frequencies
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        // Create StringBuilder to build sorted string
        StringBuilder sb = new StringBuilder();

        int max = -1;
        while (max != 0) {
            max = -1;
            char charmax = 0;

            // Find character with maximum frequency
            for (char i = 0; i < count.length; i++) {
                if (count[i] > max) {
                    max = count[i];
                    charmax = i;
                }
            }

            // Append the character `max` times
            for (int i = 0; i < max; i++) {
                sb.append(charmax);
            }

            count[charmax] = 0; // Mark character as used
        }

        return sb.toString(); // Return the sorted string
    }

    // Problem: Count the number of substrings with exactly k distinct characters.
    // Given a string and an integer k, count the number of substrings that have
    // exactly k distinct characters.
    public static int countDistinctSubString(String s, int k) {
        int result = 0;

        // Iterate through each character as a potential starting point
        for (int i = 0; i < s.length(); i++) {
            char count[] = new char[26]; // Array to count character occurrences
            int distinct = 0; // Count of distinct characters

            // Iterate through substrings starting at position `i`
            for (int j = i; j < s.length(); j++) {
                int idx = s.charAt(j) - 'a'; // Convert character to array index

                if (count[idx] == 0) {
                    distinct++; // Increment distinct count for new character
                }

                count[idx]++; // Increment character frequency

                // Check if distinct characters match the desired count `k`
                if (distinct == k) {
                    result++; // Increment result count
                } else if (distinct > k) {
                    break; // Break if distinct count exceeds `k`
                }
            }
        }
        return result; // Return the count of substrings with `k` distinct characters
    }

    // Rearrange characters of a string to maximize the distance between the same
    // characters. Given a string, the goal is to rearrange its characters in such a
    // way that the same characters are at least 2 indices apart, and if not
    // possible, return an empty string.

    public static String reArrangeString(String s) {
        int hash[] = new int[26];
        int max_num = Integer.MIN_VALUE;
        char max_char = 'a';

        // Count the frequency of each character in the input string
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }

        // Find the character with the highest frequency
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max_num) {
                max_num = hash[i];
                max_char = (char) (i + 'a');
            }
        }

        int idx = 0;
        char result[] = new char[hash.length];

        // Rearrange the string by placing the character with max frequency at even
        // indices
        while (max_num > 0 && idx < s.length()) {
            result[idx] = max_char;
            max_num--;
            idx += 2;
        }

        hash[max_char - 'a'] = 0;

        // If characters remain and can't be rearranged, return an empty string
        if (max_num != 0) {
            return "";
        }

        // Fill the remaining characters at odd indices
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= s.length()) {
                    idx = 1;
                }
                result[idx] = (char) (i + 'a');
                hash[i]--;
                idx += 2;
            }
        }

        return new String(result); // Return the rearranged string
    }

    public static boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // Problem: Check if `s1` is a permutation (anagram) of any substring in `s2`.
        // Solution:
        // - Use two arrays `data` and `test` to count character frequencies in `s1` and
        // sliding window of `s2`.
        // - Slide the window over `s2`, maintaining the count of characters in the
        // window.
        // - If the counts match, return true.
        // - If not, slide the window and adjust counts accordingly.

        if (m > n) {
            return false; // If length of `s1` is greater than `s2`, return false
        }

        int data[] = new int[26]; // Count of characters in `s1`
        int test[] = new int[26]; // Sliding window count of characters in `s2`

        // Count character frequencies in the initial window
        for (int i = 0; i < m; i++) {
            data[s1.charAt(i) - 'a']++;
            test[s2.charAt(i) - 'a']++;
        }

        // Check if the counts match initially
        if (Arrays.equals(test, data)) {
            return true;
        }

        // Slide the window over `s2` and adjust character counts
        for (int i = m; i < n; i++) {
            test[s2.charAt(i) - 'a']++;
            test[s2.charAt(i - m) - 'a']--;

            // Check if the counts match after sliding the window
            if (Arrays.equals(test, data)) {
                return true;
            }
        }

        return false; // No matching anagram found, return false
    }

    // Problem: Calculate the "beauty" of a string. The beauty of a string is
    // calculated as the sum of the differences between the maximum and minimum
    // frequencies of characters in all possible substrings of the given string.
    public static int beautyString(String str) {
        int ans = 0;

        // Iterate through each character in the string
        for (int i = 0; i < str.length(); i++) {
            int count[] = new int[26];
            // Consider all possible substrings starting from index i
            for (int j = i; j < str.length(); j++) {
                // Increment the count of the current character in the substring
                count[str.charAt(j) - 'a']++;
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                // Calculate the maximum and minimum frequencies in the current substring
                for (int k = 0; k < count.length; k++) {
                    max = Math.max(max, count[k]);
                    if (count[k] != 0) {
                        min = Math.min(min, count[k]);
                    }
                }
                // Add the difference between max and min frequencies to the answer
                ans += max - min;
            }
        }
        return ans; // Return the final beauty value
    }

    // Problem: Find the length of the longest substring with at most k replacements
    // allowed. You can replace any character in the string with any other character
    // to make the substring balanced.
    public static int characterReplacement(String s, int k) {
        char count[] = new char[26];
        int maxCount = 0;
        int maxLength = 0;
        int start = 0;

        // Iterate through each character in the string
        for (int end = 0; end < count.length; end++) {
            // Increment the count of the current character in the window
            count[s.charAt(end) - 'a']++;
            // Track the maximum count of any character in the current window
            maxCount = Math.max(maxCount, count[s.charAt(end) - 'a']);
            // Calculate the number of replacements needed to make the substring balanced
            int rep = (end - start + 1) - maxCount;
            // If replacements exceed k, shrink the window from the left
            if (rep > k) {
                count[s.charAt(start) - 'a']--;
                start++;
            }
            // Update the maximum length of a valid substring
            maxLength = Math.max(end - start + 1, maxLength);
        }
        return maxLength; // Return the maximum length of substring with at most k replacements
    }

    public static void main(String[] args) {
        String str = "aabbc";
        // System.out.println(isIsomorpic("gso", "see"));
        System.out.println(checkInclusion("abc", "eidbacoo"));
    }
}
