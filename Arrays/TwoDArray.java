package Arrays;
// Initialize two arrays, row and col, each of length m and n respectively, with all elements set to 0.

// Iterate through each element in the matrix:

// If matrix[i][j] is 0, set row[i] and col[j] to 1.
// Iterate through each element in the matrix:

// If row[i] is 1 or col[j] is 1, set matrix[i][j] to 0.

// Return the modified matrix.

class TwoDArray {

    public static int[][] setMatrixZero(int matrix[][]) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row[] = new int[m];
        int col[] = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

    // "I'll walk you through a Java code example that demonstrates how to rotate a
    // matrix 90 degrees clockwise.
    // Rotating a matrix involves changing its orientation by 90 degrees in a
    // clockwise direction. This can be useful in various applications, such as
    // image processing and graphics transformations."

    // Code Explanation:

    // Transpose (Changing Rows into Columns):

    // The initial section of the code performs a transpose operation on the matrix
    // by swapping elements along the main diagonal. This effectively changes rows
    // into columns.
    // The outer loop iterates through rows i, and the inner loop iterates through
    // columns j starting from i + 1. This avoids redundant swaps.
    // During each iteration, the elements at (i, j) and (j, i) are swapped using a
    // temporary variable temp.

    // Reverse Columns:

    // After the transpose operation, the matrix has its rows and columns swapped.
    // To complete the 90-degree clockwise rotation, we need to reverse the columns.
    // The start and end variables define the range of columns to be reversed.
    // The while loop iterates as long as start is less than end.
    // Within the loop, for each row i, the elements at (i, start) and (i, end) are
    // swapped using the same temporary variable temp.

    public static int[][] rotate90deg(int matrix[][]) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        int start = 0;
        int end = m - 1;
        while (start < end) {
            for (int i = 0; i < matrix.length; i++) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
            }
            start++;
            end--;
        }
        return matrix;
    }

    // Interviewer: Could you please explain how the searchMatrix function works?

    // You: Of course! The searchMatrix function is designed to search for a target
    // value within a given 2D matrix.
    // This matrix is special in that it is sorted both row-wise and column-wise.
    // Let me break down the key steps of the function for you:

    // Null and Empty Matrix Check:

    // We start by checking if the input matrix is null (not initialized), has no
    // rows, or has no columns. If any of these conditions are met, we immediately
    // return false, as it is impossible to find the target value in this case.
    // Matrix Dimensions:

    // We determine the dimensions of the matrix, where m represents the number of
    // rows, and n represents the number of columns.
    // Binary Search Approach:

    // Since the matrix is sorted both row-wise and column-wise, we can use a binary
    // search approach to efficiently find the target value.
    // While Loop:

    // We set up a while loop that continues as long as the start index is less than
    // or equal to the end index. This loop allows us to narrow down the search
    // range iteratively.
    // Midpoint Calculation:

    // In each iteration of the loop, we calculate the midpoint index mid as the
    // average of start and end. This midpoint index is then converted back into 2D
    // coordinates midX and midY using division and modulo operations.
    // Comparison with Target:

    // We compare the matrix value at position (midX, midY) with the target value we
    // are searching for.
    // If the matrix value is equal to the target, we have found the target value in
    // the matrix, and we return true.
    // If the matrix value is less than the target, we update start to mid + 1, as
    // the target can only exist in the right half of the remaining search region.
    // If the matrix value is greater than the target, we update end to mid - 1, as
    // the target can only exist in the left half of the remaining search region.
    // Return False:
    // If the while loop completes without finding the target value, we return
    // false, indicating that the target is not present in the matrix.
    
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

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        int ans[][] = rotate90deg(matrix);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
