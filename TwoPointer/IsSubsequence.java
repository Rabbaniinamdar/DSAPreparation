
/*
 * Problem: Is Subsequence
 * LeetCode: 392
 * URL: https://leetcode.com/problems/is-subsequence/
 *
 * PROBLEM DESCRIPTION:
 *
 * Given two strings s and t, return true if s is a subsequence
 * of t, otherwise return false.
 *
 * A subsequence is formed by deleting zero or more characters
 * from a string without changing the relative order of the
 * remaining characters.
 *
 *
 * SAMPLE INPUT 1:
 * s = "abc"
 * t = "ahbgdc"
 *
 * SAMPLE OUTPUT 1:
 * true
 *
 * EXPLANATION:
 * a -> h -> b -> g -> d -> c
 *
 * We can find a, b, and c in the same order in t.
 *
 *
 * SAMPLE INPUT 2:
 * s = "axc"
 * t = "ahbgdc"
 *
 * SAMPLE OUTPUT 2:
 * false
 *
 * EXPLANATION:
 * We can find 'a' in t.
 * But after that, we cannot find 'x'.
 *
 *
 * APPROACH: TWO POINTERS (SLOW AND FAST)
 *
 * We use two pointers:
 *
 * slow = 0  -> Tracks characters of s.
 * fast = 0  -> Traverses characters of t.
 *
 * ALGORITHM:
 *
 * 1. Traverse both strings while slow < s.length()
 *    and fast < t.length().
 *
 * 2. Compare s.charAt(slow) with t.charAt(fast).
 *
 * 3. If both characters match:
 *      Increment slow.
 *
 * 4. Always increment fast.
 *
 * 5. If slow reaches s.length(), all characters matched.
 *    Return true.
 *
 * Otherwise, return false.
 *
 *
 * DRY RUN 1:
 *
 * s = "abc"
 * t = "ahbgdc"
 *
 * Initially:
 * slow = 0, fast = 0
 *
 * fast = 0:
 * a == a -> Match
 * slow = 1
 *
 * fast = 1:
 * b != h -> No match
 *
 * fast = 2:
 * b == b -> Match
 * slow = 2
 *
 * fast = 3:
 * c != g -> No match
 *
 * fast = 4:
 * c != d -> No match
 *
 * fast = 5:
 * c == c -> Match
 * slow = 3
 *
 * slow == s.length()
 * Return true.
 *
 *
 * DRY RUN 2:
 *
 * s = "axc"
 * t = "ahbgdc"
 *
 * a == a -> Match
 * slow = 1
 *
 * x != h
 * x != b
 * x != g
 * x != d
 * x != c
 *
 * fast reaches the end of t.
 * slow = 1, s.length() = 3.
 *
 * Return false.
 *
 *
 * TIME COMPLEXITY:
 * O(n), where n is the length of t.
 *
 * SPACE COMPLEXITY:
 * O(1), because we use only two pointers.
 *
 *
 * INTERVIEW-READY ANSWER:
 *
 * "I solve this problem using two pointers.
 *
 * The first pointer tracks the characters of string s, and
 * the second pointer traverses string t.
 *
 * Whenever both characters match, I increment the first pointer.
 * I always increment the second pointer because we need to
 * traverse the complete target string.
 *
 * Finally, if the first pointer reaches the length of s,
 * it means all characters were found in the correct order,
 * so I return true.
 *
 * The time complexity is O(n), where n is the length of t,
 * and the space complexity is O(1)."
 *
 *
 * FOLLOW-UP INTERVIEW QUESTIONS:
 *
 * Q1. What is a subsequence?
 * Answer: A subsequence is formed by deleting characters
 * without changing the relative order of remaining characters.
 *
 * Q2. Why do we increment fast every time?
 * Answer: Because we must examine every character in t.
 *
 * Q3. Why do we increment slow only when characters match?
 * Answer: Because slow tracks the next character we need to
 * find from s.
 *
 * Q4. What if s is an empty string?
 * Answer: Return true because an empty string is a subsequence
 * of every string.
 *
 * Q5. What if s is longer than t?
 * Answer: Return false because t cannot contain all characters
 * of s in the required order.
 *
 * Q6. Can we solve this using one pointer?
 * Answer: We can use a single pointer to track s while iterating
 * over t, but conceptually this is still a two-sequence scan.
 */

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {

        int slow = 0;
        int fast = 0;

        while (slow < s.length() && fast < t.length()) {

            if (s.charAt(slow) == t.charAt(fast)) {
                slow++;
            }

            fast++;
        }

        return slow == s.length();
    }

    public static void main(String[] args) {

        IsSubsequence obj = new IsSubsequence();

        String s = "axc";
        String t = "ahbgdc";

        boolean result = obj.isSubsequence(s, t);

        System.out.println(result);

        // Output: false
    }
}
