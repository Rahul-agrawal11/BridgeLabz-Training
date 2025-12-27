import java.util.Scanner;

class TwoDToOneDArray {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Take input for rows and columns
        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();

        System.out.print("Enter number of columns: ");
        int columns = input.nextInt();

        // Create 2D array (matrix)
        int[][] matrix = new int[rows][columns];

        // Take input for matrix elements
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        // Create 1D array of size rows * columns
        int[] array = new int[rows * columns];

        // Index variable for 1D array
        int index = 0;

        // Copy elements from 2D array to 1D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[index] = matrix[i][j];
                index++;
            }
        }

        // Display 1D array
        System.out.println("\nElements of 1D array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        input.close();
    }
}