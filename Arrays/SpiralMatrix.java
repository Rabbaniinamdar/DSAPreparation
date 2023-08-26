package Arrays;
import java.util.Scanner;
// Interviewer: Can you walk me through this code?

// You: Of course. This code is a Java program that takes user input to create a matrix and then prints its elements in a spiral order. Let's break down how it works step by step.

// User Input and Matrix Creation: The program starts by asking the user to input the number of rows and columns for the matrix. 
// It then creates a 2D array (matrix) based on this input and prompts the user to enter the values for each cell.

// Printing Matrix in Row-Major Order: The code defines a function called printMatrix which iterates through the matrix and prints its elements in row-major order. This is done by using nested loops to iterate through the rows and columns and printing each element along the way.

// Printing Matrix in Spiral Order: The main part of the code is the printSpiralOrder function. This function takes the matrix dimensions (number of rows and columns) and uses a spiral traversal algorithm to print the matrix elements in a spiral order.

// It sets up four variables: topRow, bottomRow, leftCol, and rightCol to define the boundaries of the current spiral layer.

// A loop runs until all elements of the matrix have been printed.

// In each iteration of the loop, it does the following:

// Traverses the top row from leftCol to rightCol and prints the elements.
// Traverses the right column from topRow to bottomRow and prints the elements.
// Traverses the bottom row from rightCol to leftCol and prints the elements.
// Traverses the left column from bottomRow to topRow and prints the elements.
// After each traversal, the boundaries are adjusted to move to the next inner spiral layer.

// Output: Finally, the program prints the original matrix using the printMatrix function to show the user their input, and then it prints the matrix elements in spiral order using the printSpiralOrder function.

public class SpiralMatrix {
    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void printSpiralOrder(int[][] matrix, int r, int c) {
        int topRow = 0, bottomRow = r - 1, leftCol = 0, rightCol = c - 1;
        int totalElements = 0;

        while (totalElements < r * c) {
            // topRow -> leftCol to rightCol
            for (int j = leftCol; j <= rightCol; j++) {
                System.out.print(matrix[topRow][j] + " ");
                totalElements++;
            }
            topRow++;

            // rightCol -> topRow to BottomRow
            for (int i = topRow; i <= bottomRow && totalElements < r * c; i++) {
                System.out.print(matrix[i][rightCol] + " ");
                totalElements++;
            }
            rightCol--;

            // bottomRow -> rightCol to leftCol
            for (int j = rightCol; j >= leftCol && totalElements < r * c; j--) {
                System.out.print(matrix[bottomRow][j] + " ");
                totalElements++;
            }
            bottomRow--;

            // leftCol -> bottomRow to topRow
            for (int i = bottomRow; i >= topRow && totalElements < r * c; i--) {
                System.out.print(matrix[i][leftCol] + " ");
                totalElements++;
            }
            leftCol++;
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter number of rows and columns of matrix");
            int r = sc.nextInt();
            int c = sc.nextInt();
            int[][] matrix = new int[r][c];
            int total = r * c;
            System.out.println("Enter " + total + " values");
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            System.out.println("Input Matrix");
            printMatrix(matrix);

            System.out.println("Spiral Order");
            printSpiralOrder(matrix, r, c);
        }
    }
}
