import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mouse {
    public static int row, col, cheeses = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int rowsAndCols = Integer.parseInt(reader.readLine());

        char[][] field = readMatrix(reader, rowsAndCols);
        initialRowAndCol(field);

        boolean outOfBounds = false;
        String command = reader.readLine();
        while (!command.equals("End")) {

            switch (command) {
                case "left":
                    outOfBounds = move(row, col - 1, row, col - 2, field);
                    break;
                case "right":
                    outOfBounds = move(row, col + 1, row, col + 2, field);
                    break;
                case "up":
                    outOfBounds = move(row - 1, col, row - 2, col, field);
                    break;
                case "down":
                    outOfBounds = move(row + 1, col, row + 2, col, field);
                    break;
            }


            if (outOfBounds) {
                System.out.println("Where is the mouse?");
                break;
            }
            command = reader.readLine();
        }

        String output = cheeses >= 5
                ? String.format("Great job, the mouse is fed %d cheeses!", cheeses)
                : String.format("The mouse couldn't eat the cheeses, she needed %d cheeses more.", 5 - cheeses);

        System.out.println(output);
        printMatrix(field);


    }

    private static char[][] readMatrix(BufferedReader reader, int rowsAndCols) throws IOException {
        char[][] matrix = new char[rowsAndCols][rowsAndCols];
        for (int row = 0; row < rowsAndCols; row++) {
            matrix[row] = reader.readLine().toCharArray();
        }
        return matrix;
    }

    private static void initialRowAndCol(char[][] field) {
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                if (field[r][c] == 'M') {
                    row = r;
                    col = c;
                    break;
                }
            }
        }
    }

    private static boolean isOutOfBounds(int row, int col, char[][] field) {
        return row < 0 || row >= field.length || col < 0 || col >= field[row].length;
    }

    private static boolean move(int newRow, int newCol, int rowForBonus, int colForBonus, char[][] field) {
        if (isOutOfBounds(newRow, newCol, field)) {
            field[row][col] = '-';
            return true;
        }
        char symbol = field[newRow][newCol];
        if (field[newRow][newCol] == 'c') {
            field[newRow][newCol] = '-';
            cheeses++;
        } else if (field[newRow][newCol] == '-') {
            field[newRow][newCol] = '-';

        }else if(field[newRow][newCol] == 'B'){
            field[newRow][newCol] = '-';
            field[newRow][newCol] = 'B';


        }
//        if (symbol == 'М') {
//            field[row][col] = '-';
//            field[newRow][newCol] = 'B';
//            row = newRow;
//            col = newCol;
//        } else if (symbol == 'f') {
//            field[row][col] = '.';
//            field[newRow][newCol] = 'B';
//            cheeses++;
//            row = newRow;
//            col = newCol;
//        } else if (symbol == 'O') {
//            if (field[rowForBonus][colForBonus] == 'B'){
//                cheeses++;
//            }
//            field[row][col] = '.';
//            field[newRow][newCol] = '.';
//            field[rowForBonus][colForBonus] = 'B';
//            row = rowForBonus;
//            col = colForBonus;
//        }
            if(symbol == 'B'){
            char sym = field[rowForBonus][colForBonus];
            if(sym == 'c'){
                cheeses++;
            }
            field[row][col]='-';
            field[newRow][newCol] = '-';
            field[rowForBonus][colForBonus]='M';
            row = rowForBonus;
            col = colForBonus;

        }

        return false;
    }

    private static void printMatrix(char[][] field){
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                System.out.print(field[r][c]);
            }
            System.out.println();
        }
    }
}
