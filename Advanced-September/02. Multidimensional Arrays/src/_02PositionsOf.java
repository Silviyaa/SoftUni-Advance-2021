import java.util.Arrays;
import java.util.Scanner;

public class _02PositionsOf {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
        int[] dimensions = readDimensions(scanner);
        int[][] matrix = readMatrix(dimensions[0], dimensions[1], scanner);
        int number = Integer.parseInt(scanner.nextLine());

        boolean isPresent = false;

        for (int i = 0; i < dimensions[0]; i++) {
            for (int j = 0; j < dimensions[1]; j++) {
                if (matrix[i][j] == number) {
                    System.out.println(i + " " + j);
                    isPresent = true;
                }
            }
        }
        if (!isPresent)
            System.out.println("not found");

    }

    private static int[] readDimensions(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }

    public static int[][] readMatrix(int rows, int columns, Scanner scanner) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            int[] arr = readDimensions(scanner);
            matrix[i] = arr;
        }
        return matrix;
    }
}
