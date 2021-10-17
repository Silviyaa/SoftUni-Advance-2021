import java.util.Arrays;
import java.util.Scanner;

public class _04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine().split(", ")[0]);
        int[][] matrix = readMatrix(rows,scanner);
        System.out.println(rows);
        System.out.println(matrix[0].length);

        int sum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }
        System.out.println(sum);
    }

    public static int[][] readMatrix(int rows,Scanner scanner) {
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }
        return matrix;
    }
}
