import java.util.Scanner;

public class MouseAndCheese {
    static int row;
    static int coll;
    static int cheese = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            String line = scan.nextLine().replaceAll("\\s+", "");
            matrix[row] = line.toCharArray();

            if (line.contains("M")) {
                MouseAndCheese.row = row;
                coll = line.indexOf("M");
            }
        }
        String command = scan.nextLine();
        boolean isOutOfBounce = false;
        while (!command.equals("end")) {


            switch (command) {
                case "up":
                    isOutOfBounce = move(matrix, row - 1, coll, command);
                    break;
                case "down":
                    isOutOfBounce = move(matrix, row + 1, coll, command);
                    break;
                case "left":
                    isOutOfBounce = move(matrix, row, coll - 1, command);
                    break;
                case "right":
                    isOutOfBounce = move(matrix, row, coll + 1, command);
                    break;
            }


            if (isOutOfBounce) {
                break;
            }

            command = scan.nextLine();
        }

        if(isOutOfBounce){
            System.out.println("Where is the mouse?");
        }
        if(cheese <5){
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n",5- cheese);
        }else{
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheese);
        }



        printMatrix(matrix);
    }

    private static boolean isOutOfBounce(char[][] matrix, int newRow, int newCol) {
        return newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix.length;
    }

    private static boolean move(char[][] matrix, int newRow, int newCol, String command) {
        if (isOutOfBounce(matrix, newRow, newCol)) {
            matrix[row][coll]='-';
            return true;
        }
        char nextPosition = matrix[newRow][newCol];
        int startRow = row;
        int startCol = coll;
        if (nextPosition == 'c') {
            cheese++;
            matrix[newRow][newCol] = 'M';
            row = newRow;
            coll = newCol;
        } else if (nextPosition == 'B') {
            if (command.equals("right")) {
                if (matrix[newRow][newCol + 1] == 'c') {
                    cheese++;
                }
                matrix[newRow][newCol + 1] = 'M';
                row = newRow;
                coll = newCol + 1;
            } else if (command.equals("left")) {
                if (matrix[newRow][newCol - 1] == 'c') {
                    cheese++;
                }
                matrix[newRow][newCol - 1] = 'M';
                row = newRow;
                coll = newCol - 1;

            } else if (command.equals("up")) {
                if (matrix[newRow - 1][newCol] == 'c') {
                    cheese++;
                }
                matrix[newRow - 1][newCol] = 'M';
                row = newRow - 1;
                coll = newCol;

            } else if (command.equals("down")) {
                if (matrix[newRow + 1][newCol] == 'c') {
                    cheese++;
                }
                matrix[newRow + 1][newCol] = 'M';
                row = newRow + 1;
                coll = newCol;
            }
            matrix[newRow][newCol]='-';

        }else{
            row =newRow;
            coll =newCol;
            matrix[newRow][newCol]='M';
        }
        matrix[startRow][startCol]='-';


        return false;
    }

    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
