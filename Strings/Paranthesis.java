package Strings;
import java.util.Stack;

public class Paranthesis {
    // This class contains a method to remove the outermost parentheses while
    // preserving nested structure.

    static String removeOuterParentheses(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 0; // To keep track of the nesting level of parentheses.

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') { // If an opening parenthesis is encountered.
                if (count != 0) {
                    sb.append(str.charAt(i)); // Append if not the outermost parenthesis.
                }
                count++; // Increment the nesting level.
            } else if (str.charAt(i) == ')') { // If a closing parenthesis is encountered.
                count--; // Decrement the nesting level.
                if (count != 0) {
                    sb.append(str.charAt(i)); // Append if not the outermost parenthesis.
                }
            }
        }
        return sb.toString(); // Return the string with outermost parentheses removed.
    }

    // This method uses a stack to determine if the brackets in the input string are
    // properly balanced.
    public static boolean isValid(String s) {
        // Create an empty stack to keep track of opening brackets
        Stack<Character> stack = new Stack<Character>();

        // Loop through every character in the string
        for (char c : s.toCharArray()) {
            // If the character is an opening bracket, push it onto the stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else { // If the character is a closing bracket
                // If the stack is empty, there is no matching opening bracket, so return false
                if (stack.isEmpty()) {
                    return false;
                }
                // Otherwise, get the top of the stack and check if it's the matching opening
                // bracket
                char top = stack.peek();
                if (c == ')' && top == '(' || c == ']' && top == '[' || c == '}' && top == '{') {
                    // If it is, pop the opening bracket from the stack
                    stack.pop();
                } else {
                    // Otherwise, the brackets don't match, so return false
                    return false;
                }
            }
        }
        // If the stack is empty, all opening brackets have been closed, so return true
        // Otherwise, there are unmatched opening brackets, so return false
        return stack.isEmpty();
    }

    // Problem: Given a string containing parentheses, remove the minimum number of
    // parentheses to make the string valid. A string is considered valid if for
    // every open parenthesis '(' there is a corresponding closing parenthesis ')',
    // and parentheses are balanced.

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        char str[] = s.toCharArray();
        // Traverse through the string to process parentheses
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i); // Store index of open parenthesis in stack
            } else if (s.charAt(i) == ')') {
                if (!st.isEmpty()) {
                    st.pop(); // Match with a previous open parenthesis
                } else {
                    str[i] = ' '; // Mark the closing parenthesis for removal
                }
            }
        }
        // Mark any remaining unmatched open parentheses for removal
        while (!st.isEmpty()) {
            str[st.pop()] = ' ';
        }
        StringBuilder sb = new StringBuilder();
        // Build the modified string without marked parentheses
        for (int i = 0; i < str.length; i++) {
            if (str[i] != ' ') {
                sb.append(str[i]);
            }
        }
        return sb.toString();
    }
    // maxDepth Function:
    // Problem: Given a string containing parentheses, find the maximum depth of the
    // parentheses. The depth of a valid parentheses string is defined as the
    // maximum number of parentheses nested within each other.

    public static int maxDepth(String s) {
        int ans = 0;
        int upcount = 0;
        // Traverse through the string to calculate depth
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                upcount++; // Increment count for open parenthesis
            } else if (s.charAt(i) == ')') {
                upcount--; // Decrement count for closing parenthesis
            }
            ans = Math.max(ans, upcount); // Update maximum depth
        }
        return ans; // Return the maximum depth
    }

    public static void main(String[] args) {
        String str = "rabbani";
    }
}
