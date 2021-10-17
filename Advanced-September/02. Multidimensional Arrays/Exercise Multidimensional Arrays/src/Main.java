import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int playerHealth = 18500; // Initial health of the Player;
        double heiganHealth = 3000000; // Initial health of Heigan;

        double damage = Double.parseDouble(scanner.nextLine()); // D - number;
        int[] playerPosition = {7, 7}; // Player's start position (row, col);
        String previousSpell = "";
        boolean cloudSpell = false;
        boolean heiganIsKilled = false;
        boolean playerIsKilled = false;
        int counter = 0;

        String[][] matrix = createMatrix();
        matrix[7][7] = "P";
        System.out.println("Initial matrix state:");
        printMatrix(matrix);

        while (true) {
            counter++;
            matrix = createMatrix();
            heiganHealth -= damage; // Player attacks Heigan;
            if (heiganHealth <= 0) {
                heiganIsKilled = true;
            }
            if (cloudSpell) {
                playerHealth -= 3500;
                cloudSpell = false;
                if (playerHealth <= 0) {
                    playerIsKilled = true;
                }
            }
            if (heiganIsKilled || playerIsKilled) {
                break; // Game over, go to print;
            }
            String[] commands = scanner.nextLine().split("\\s+");
            String spell = commands[0];
            int playerRow = playerPosition[0];
            int playerCol = playerPosition[1];
            int heiganRow = Integer.parseInt(commands[1]);
            int heiganCol = Integer.parseInt(commands[2]);

            System.out.println();
            System.out.printf("%d MOVE:\n", counter);
            System.out.println();
            drawDangerZone(matrix, playerRow, playerCol, heiganRow, heiganCol);
            System.out.println("Danger zone:");
            printMatrix(matrix);
            matrix[playerRow][playerCol] = "P";
            System.out.println("Player position:");
            printMatrix(matrix);
            matrix[playerRow][playerCol] = "";

            if (isOnDamagedCell(heiganRow, heiganCol, playerRow, playerCol)) {
                playerRow--; // Try moving UP;
                if (isOnDamagedCell(heiganRow, heiganCol, playerRow, playerCol) || isOutOfBounds(playerRow)) {
                    playerRow = playerPosition[0];
                    playerCol++; // Try moving RIGHT;
                    if (isOnDamagedCell(heiganRow, heiganCol, playerRow, playerCol) || isOutOfBounds(playerCol)) {
                        playerCol = playerPosition[1];
                        playerRow++; // Try moving DOWN;
                        if (isOnDamagedCell(heiganRow, heiganCol, playerRow, playerCol) || isOutOfBounds(playerRow)) {
                            playerRow = playerPosition[0];
                            playerCol--; // Try moving LEFT;
                            if (isOnDamagedCell(heiganRow, heiganCol, playerRow, playerCol) || isOutOfBounds(playerCol)) {
                                System.out.println("Player could not escape. Hit by Heigan!");
                                System.out.println();
                                // No escape! Heigan attacks player:
                                switch (spell) {
                                    case "Cloud":
                                        playerHealth -= 3500;
                                        previousSpell = "Plague Cloud";
                                        cloudSpell = true;
                                        break;
                                    case "Eruption":
                                        playerHealth -= 6000;
                                        previousSpell = "Eruption";
                                        break;
                                }
                                if (playerHealth <= 0) {
                                    playerIsKilled = true;
                                    break;
                                }

                            } else {
                                if (!isOutOfBounds(playerCol)) {
                                    matrix[playerPosition[0]][playerPosition[1]] = "⚡";
                                    playerPosition[1]--; // Player escaped LEFT (col--);
                                    System.out.println("Player escaped left:");
                                    matrix[playerPosition[0]][playerPosition[1]] = "P";
                                    printMatrix(matrix);
                                }
                            }
                        } else {
                            matrix[playerPosition[0]][playerPosition[1]] = "⚡";
                            playerPosition[0]++; // Player escaped DOWN (row++);
                            System.out.println("Player escaped down:");
                            matrix[playerPosition[0]][playerPosition[1]] = "P";
                            printMatrix(matrix);
                        }
                    } else {
                        matrix[playerPosition[0]][playerPosition[1]] = "⚡";
                        playerPosition[1]++; // Player escaped RIGHT (col++);
                        System.out.println("Player escaped right:");
                        matrix[playerPosition[0]][playerPosition[1]] = "P";
                        printMatrix(matrix);
                    }
                } else {
                    matrix[playerPosition[0]][playerPosition[1]] = "⚡";
                    playerPosition[0]--; // Player escaped UP (row--);
                    System.out.println("Player escaped up:");
                    matrix[playerPosition[0]][playerPosition[1]] = "P";
                    printMatrix(matrix);
                }
            }
        }
        // Printing the results:
        System.out.println("GAME OVER");
        System.out.println();
        if (heiganIsKilled) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f\n", heiganHealth);
        }
        if (playerIsKilled) {
            System.out.printf("Player: Killed by %s\n", previousSpell);
        } else {
            System.out.printf("Player: %d\n", playerHealth);
        }
        System.out.printf("Final position: %d, %d", playerPosition[0], playerPosition[1]);
    }

    private static void drawDangerZone(String[][] matrix, int playerRow, int playerCol, int heiganRow, int heiganCol) {
        for (int row = heiganRow - 1; row < heiganRow + 2; row++) {
            for (int col = heiganCol - 1; col < heiganCol + 2; col++) {
                if (!isOutOfBounds(playerRow) && !isOutOfBounds(playerCol)) {
                    matrix[row][col] = "⚡";
                }
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 15; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static String[][] createMatrix() {
        String[][] matrix = new String[15][15];
        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 15; col++) {
                matrix[row][col] = ".";
            }
        }
        return matrix;
    }

    // This method checks if the Player hits a wall (is out of matrix bounds):
    private static boolean isOutOfBounds(int position) {
        return position < 0 || position > 14;
    }

    // This method checks if the Player is placed on damaged cell:
    private static boolean isOnDamagedCell(int heiganRow, int heiganCol, int playerRow, int playerCol) {
        for (int row = heiganRow - 1; row < heiganRow + 2; row++) {
            for (int col = heiganCol - 1; col < heiganCol + 2; col++) {
                if (playerRow == row && playerCol == col) {
                    return true;
                }
            }
        }
        return false;
    }
}