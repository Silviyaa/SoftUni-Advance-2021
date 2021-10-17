import java.util.Arrays;
import java.util.Scanner;

public class _05MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine().split(", ")[0]);

        int[][] matrix = readMatrix(rows, scanner, ", ");

        int maxSum = 0;
        // TODO reduce the loops iterations by 1
        for (int r = 0; r < matrix.length - 1; r++) {
            for (int c = 0; c < matrix[r].length - 1; c++) {
                int current = matrix[r][c];
                int intRight = matrix[r][c + 1];
                int inBottom = matrix[r + 1][c];
                int leftRight = matrix[r + 1][c + 1];

                int currentSum = current + intRight +inBottom + leftRight;
                 if (maxSum < currentSum){
                     maxSum = currentSum;
                 }
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int c : arr) {
                System.out.println(c + " ");
            }
            System.out.println();
        }
    }

    public static int[][] readMatrix(int rows, Scanner scanner, String splitPattern) {
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }
        return matrix;
    }
}
