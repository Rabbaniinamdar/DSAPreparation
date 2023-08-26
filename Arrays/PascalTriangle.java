package Arrays;
// Introduction:

// "The provided code is a Java implementation to generate rows of Pascal's Triangle 
// and then assemble the entire Pascal's Triangle up to a specified number of rows. Pascal's 
// Triangle is a mathematical construct where each row consists of coefficients for binomial expansion."

// Code Explanation:

// generateRow Function:

// This function generates a single row of Pascal's Triangle given a row index n.
// It initializes ans to 1, which represents the first element of each row (1).
// It uses a List<Integer> named list to store the elements of the row.
// For i from 1 to n - 1 (inclusive):
// It calculates the next value in the row using the formula: (previousValue * (n - i)) / i.
// Appends the calculated value ans to the list.
// pascalTriangle Function:

// This function generates the entire Pascal's Triangle up to a specified number of rows.
// It initializes a List<List<Integer>> named list to store the rows of the triangle.
// For i from 1 to row (inclusive):
// It generates the i-th row using the generateRow function.
// Appends the generated row to the list.

import java.util.ArrayList;
import java.util.List;

class PascalTriangle {
    public static int nCr(int n, int r) {
        int ncr = 1;
        for (int i = 0; i < r; i++) {
            ncr = ncr * (n - i);
            ncr = ncr / (i + 1);
        }
        return ncr;
    }

    public static List<Integer> generateRow(int n) {
        int ans = 1;
        List<Integer> list = new ArrayList<>();
        list.add(ans);
        for (int i = 1; i < n; i++) {
            ans = ans * (n - i) / i;
            // or
            // ans = ans * (n - i);
            // ans = ans / i;
            list.add(ans);
        }
        return list;
    }

    public static List<List<Integer>> pascalTriangle(int row) {
        List<List<Integer>> list = new ArrayList<>();
        System.out.println(nCr(4, 2));
        for (int i = 1; i <= row; i++) {
            list.add(generateRow(i));
        }
        return list;
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = pascalTriangle(5);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }
}
