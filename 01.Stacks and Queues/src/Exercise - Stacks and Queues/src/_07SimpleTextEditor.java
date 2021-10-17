import java.util.ArrayDeque;
import java.util.Scanner;

public class _07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> wordStates = new ArrayDeque<>();

        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder currentText = new StringBuilder();
        for (int count = 1; count <= n; count++) {
            String command = scanner.nextLine(); //{номер} {параметър}
            //"1 [string]" -> ["1", "string"]
            //"2 [count]" -> ["2", "count"]
            //"3 [index]" -> ["3", "index"]
            //"4" -> ["4"]
            String commandNumber = command.split("\\s+")[0]; // "1", "2", "3", "4"
            switch (commandNumber) {
                case "1":
                    //текст, който трябва да го добавя към съществуващия
                    String textToAdd = command.split("\\s+")[1];
                    currentText.append(textToAdd);
                    wordStates.push(currentText.toString());
                    break;
                case "2":
                    int countElements = Integer.parseInt(command.split("\\s+")[1]);
                    int startIndex = currentText.length() - countElements;
                    currentText.delete(startIndex, startIndex + countElements);
                    wordStates.push(currentText.toString());
                    break;
                case "3":
                    int index = Integer.parseInt(command.split("\\s+")[1]);
                    System.out.println(currentText.charAt(index - 1));
                    break;
                case "4":
                    if (wordStates.size() > 1) {
                        wordStates.pop();
                        currentText = new StringBuilder(wordStates.peek());
                    } else {
                        currentText = new StringBuilder();
                    }
                    break;
            }
        }
    }
}

