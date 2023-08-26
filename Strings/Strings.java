package Strings;
import java.util.*;

public class Strings {
    // This class contains methods to perform various string manipulations.

    // Method to generate a string containing alternating characters from two input
    // strings.
    // Example: alternativesOfString("abc", "123") returns "a1b2c3".
    static String alternativesOfString(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        int m = str1.length();
        int n = str2.length();
        for (int i = 0; i < Math.max(m, n); i++) {
            if (i < m) {
                sb.append(str1.charAt(i)); // Append character from str1 if available
            }
            if (i < n) {
                sb.append(str2.charAt(i)); // Append character from str2 if available
            }
        }
        return sb.toString(); // Return the merged string.
    }

    // Method to reverse the words in a sentence.
    // Example: reverseSentence("Hello world") returns "world Hello".
    static String reverseSentence(String str) {
        String sentence = str.replaceAll("/s+", " ").trim(); // Replace extra spaces and trim.
        String[] words = sentence.split(" "); // Split sentence into words.
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(reverseWord(words[i])); // Append reversed word.
            if (i != 0) {
                sb.append(" "); // Add space between words.
            }
        }
        return sb.toString(); // Return the sentence with reversed words.
    }

    // Method to reverse a single word.
    // Example: reverseWord("hello") returns "olleh".
    static String reverseWord(String str) {
        String word = str.trim(); // Trim any extra spaces.
        char[] characters = word.toCharArray(); // Convert word to character array.
        StringBuilder sb = new StringBuilder();
        for (int i = characters.length - 1; i >= 0; i--) {
            sb.append(characters[i]); // Append characters in reverse order.
        }
        return sb.toString(); // Return the reversed word.
    }

    // Method to find the length of the last word in a sentence.
    // Example: lengthOfLastWord("Hello world") returns 5.
    static int lengthOfLastWord(String str) {
        String sentence = str.replaceAll("/s+", " ").trim(); // Replace extra spaces and trim.
        StringBuilder sb = new StringBuilder();
        for (int i = sentence.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                break; // Stop if a space is encountered.
            }
            sb.append(sentence.charAt(i)); // Append characters until a space.
        }
        return sb.length(); // Return the length of the last word.
    }

    // Method to find the longest palindrome substring in a given string.
    // Example: longestPalindrome("babad") returns "bab".
    public static String longestPalindrome(String s) {
        int n = s.length();
        int start = 0, maxLength = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j) && j - i + 1 > maxLength) {
                    start = i; // Update start index of palindrome.
                    maxLength = j - i + 1; // Update length of palindrome.
                }
            }
        }
        return s.substring(start, start + maxLength); // Extract and return longest palindrome.
    }

    // Method to check if a substring is a palindrome.
    static boolean isPalindrome(String str, int st, int ed) {
        while (st < ed) {
            if (str.charAt(st) != str.charAt(ed)) {
                return false; // If characters don't match, it's not a palindrome.
            }
            st++;
            ed--;
        }
        return true; // If characters match for all pairs, it's a palindrome.
    }

    // This method checks if two strings are anagrams of each other.
    public static boolean isAnagram(String str1, String str2) {
        // Convert the input strings to character arrays for comparison.
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        // Sort the character arrays in ascending order.
        Arrays.sort(s1);
        Arrays.sort(s2);

        // Check if the sorted arrays are equal, indicating an anagram.
        return Arrays.equals(s1, s2);
    }

    static String longestOddNumber(String str) {
        // This method returns the longest suffix of a string that forms an odd number.

        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) % 2 == 1) {
                return str.substring(0, i + 1);
            }
        }
        return " "; // If no odd suffix is found, return an empty string.
    }

    static boolean isStringRotated(String str1, String str2) {
        // This method checks if one string is a rotation of another string.

        if (str1.length() != str2.length()) {
            return false; // If lengths are different, strings cannot be rotations.
        }

        String rotated = str1 + str1; // Duplicate the first string to form all possible rotations.
        return rotated.contains(str2); // Check if the second string is present in the rotated string.
    }

    /**
     * Rearranges the characters in the given string such that the same characters
     * are separated by at least one character and returns the rearranged string.
     * 
     * @param s The input string to be rearranged.
     * @return The rearranged string with characters separated by at least one other
     *         character.
     */
    public static String zigZag(String str, int noRows) {
        if (noRows == 1) {
            return str; // If only one row, return the input string as is
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < noRows; i++) {
            list.add(new StringBuilder()); // Create a list of StringBuilders for each row
        }
        int row = 0;
        boolean direction = true;
        int i = 0;
        while (true) {
            if (direction) {
                // Append characters to rows while moving down the rows
                while (row < noRows && i < str.length()) {
                    list.get(row++).append(str.charAt(i++));
                }
                row = noRows - 2; // Reset row index for upward traversal
            } else {
                // Append characters to rows while moving up the rows
                while (row >= 0 && i < str.length()) {
                    list.get(row--).append(str.charAt(i++));
                }
                row = 1; // Reset row index for downward traversal
            }
            if (i >= str.length()) {
                break; // Exit the loop if all characters are processed
            }
            direction = !direction; // Toggle direction for zigzag traversal
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder sb : list) {
            ans.append(sb);
        }
        return ans.toString(); // Combine StringBuilder rows to get the final rearranged string
    }

    public int countDistinctSubstrings(String s) {
        // Problem: Given a string 's', count the number of distinct substrings it
        // contains.
        int n = s.length();
        HashSet<String> substrings = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                substrings.add(s.substring(i, j + 1)); // Collect all substrings and add to a set
            }
        }

        return substrings.size(); // Return the count of distinct substrings
    }

    static String addBinary(String a, String b) {
        // Problem: Given two binary strings 'a' and 'b', return their sum as a binary
        // string.
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0) {
                carry += a.charAt(i--) - '0'; // Convert character to digit
            }
            if (j >= 0) {
                carry += b.charAt(j--) - '0'; // Convert character to digit
            }
            sb.append(carry % 2); // Append the sum modulo 2
            carry /= 2; // Update carry for the next addition
        }
        return sb.reverse().toString(); // Return the binary sum as a string
    }

    public static String compress(String str) {
        // Problem: Given a string 'str', compress it by replacing consecutive repeating
        // characters with the character followed by its count.
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= str.length(); i++) {
            char prev = str.charAt(i - 1);
            char curr = (i == str.length()) ? ' ' : str.charAt(i);
            if (curr == prev) {
                count++; // Count consecutive occurrences of characters
            } else {
                sb.append(prev); // Append the character
                if (count > 1) {
                    sb.append(count); // Append the count if it's greater than 1
                }
                count = 1; // Reset count for the next character
            }
        }
        return sb.toString(); //
    }

    // This method converts a string to an integer following atoi rules.
    public static int myAtoi(String str) {
        str = str.trim(); // Remove leading and trailing whitespace
        int sign = 1; // Initialize sign to positive
        int ans = 0; // Initialize the final integer value
        int i = 0; // Initialize index for string traversal

        // Check for sign symbols
        if (i < str.length() && str.charAt(i) == '-') {
            sign = -1; // Set sign to negative
            i++;
        } else if (i < str.length() && str.charAt(i) == '+') {
            sign = 1; // Set sign to positive
            i++;
        }

        // Process digits and calculate integer value
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            int digit = str.charAt(i) - '0'; // Convert character to integer
            // Handle integer overflow
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + digit; // Accumulate the integer value
            i++;
        }

        return ans * sign; // Return the final integer value with appropriate sign
    }

    // This method finds the longest common prefix among an array of strings.
    public static String longestCommonPrefix(String[] str) {
        Arrays.sort(str); // Sort the array of strings
        String str1 = str[0]; // Get the first string
        String str2 = str[str.length - 1]; // Get the last string
        int idx = 0; // Initialize index for comparison

        // Compare characters until a mismatch is found
        while (idx < str1.length() && idx <= str2.length()) {
            if (str1.charAt(idx) == str2.charAt(idx)) {
                idx++;
            } else {
                break;
            }
        }

        return str1.substring(0, idx); // Return the common prefix substring
    }

    // This method calculates the length of the longest substring without repeating
    // characters.
    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0; // Initialize pointers and max length
        Set<Character> set = new HashSet<>(); // Initialize a set to store unique characters

        // Iterate through the string with the second pointer (j)
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j)); // Add character to the set
                max = Math.max(max, set.size()); // Update max length
                j++;
            } else {
                set.remove(s.charAt(i)); // Remove character at first pointer (i)
                i++;
            }
        }

        return max; // Return the maximum length of the substring
    }

    // This method converts an integer to a Roman numeral string.
    public static String intToRoman(int num) {
        // Define arrays for Roman numeral symbols and their corresponding values.
        String s[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int a[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        StringBuilder sb = new StringBuilder(); // Initialize a StringBuilder to build the result.

        // Iterate through the symbol-value arrays and build the Roman numeral string.
        for (int i = 0; i < a.length; i++) {
            while (num >= a[i]) {
                sb.append(s[i]); // Append the Roman numeral symbol to the result.
                num -= a[i]; // Reduce the remaining number.
            }
        }

        return sb.toString(); // Return the Roman numeral string.
    }

    // This method converts a Roman numeral string to an integer.
    public static int romanToInt(String s) {
        int num = 0, ans = 0;
        // Iterate through the Roman numeral string in reverse.
        for (int i = s.length() - 1; i >= 0; i--) {
            // Convert the Roman numeral symbol to its corresponding value.
            switch (s.charAt(i)) {
                case 'I':
                    num = 1;
                    break;
                case 'V':
                    num = 5;
                    break;
                case 'X':
                    num = 10;
                    break;
                case 'L':
                    num = 50;
                    break;
                case 'C':
                    num = 100;
                    break;
                case 'D':
                    num = 500;
                    break;
                case 'M':
                    num = 1000;
                    break;
            }
            // Handle cases where subtraction is needed (e.g., IV for 4).
            if (4 * num < ans) {
                ans -= num;
            } else {
                ans += num;
            }
        }
        return ans; // Return the integer value.
    }

    // This method finds how many times string 'a' must be repeated to contain
    // string 'b'.
    public static int repeatedStringMatch(String a, String b) {
        int idx = b.length() / a.length(); // Calculate the minimum possible repetitions.
        StringBuilder sb = new StringBuilder(a); // Initialize a StringBuilder with string 'a'.
        int count = 1; // Initialize the repetition count.

        // Iterate to check whether the concatenated string contains 'b'.
        for (int i = 0; i <= idx + 1; i++) {
            if (sb.toString().contains(b)) {
                return count++; // If 'b' is found, return the repetition count.
            } else {
                sb.append(a); // Concatenate 'a' to the StringBuilder.
                count++;
            }
        }

        return -1; // Return -1 if 'b' cannot be obtained by repeating 'a'.
    }

    public static void main(String[] args) {
        // Uncomment these lines to test the methods
        String str[] = { "aabc", "aabc", "aadbc" };
        System.out.println(repeatedStringMatch("abcd", "cdabcdab"));
        // System.out.println(longestCommonPrefix(str));
        // System.out.println(compress("aaabbbbcc"));
        // System.out.println(myAtoi("-988765087"));
        // System.out.println(alternativesOfString("rabbani", "iamdar"));
        // System.out.println(reverseSentence("rabbani inamdar"));
        // System.out.println(reverseWord("rabbani"));
        // System.out.println(lengthOfLastWord("rabbani hi"));
        // System.out.println(longestPalindrome("aaa"));
        // System.out.println(lengthOfLongestSubstring("ababcabcbb"));
        // System.out.println(isAnagram("arbiban", "rabbani"));
        // System.out.println(longestOddNumber("3542"));
        // System.out.println(isStringRotated("abcde", "dceab"));
        // System.out.println(zigZag("abcdef", 3));
        // System.out.println(addBinary("101", "010"));
    }
}
