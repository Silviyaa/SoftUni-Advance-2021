
import java.util.Scanner;

public class TheHeiganDance08 {
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

        while (true) {
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
                                    playerPosition[1]--; // Player escaped LEFT (col--);
                                }
                            }
                        } else {
                            playerPosition[0]++; // Player escaped DOWN (row++);
                        }
                    } else {
                        playerPosition[1]++; // Player escaped RIGHT (col++);
                    }
                } else {
                    playerPosition[0]--; // Player escaped UP (row--);
                }
            }
        }
        // Printing the results:
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