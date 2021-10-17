import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _01BrowserHistory {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Deque<String> history = new ArrayDeque<>();
        while (true){

            String line = scanner.nextLine();
           // String line = nextInputLine();
            String output = "";

            switch (line) {
                case "back":
                    if (history.size() <= 1) {
                        output = "no previous URLs";
                    } else {
                        history.pop();
                        output = history.peek();
                    }
                    break;
                case "Home":

                    return;
                default:
                    output = line;
                    history.push(line);
            }

            System.out.println(output);
        }
    }

    private static String nextInputLine() {
        Scanner scanner = new Scanner(System.in);
        return  scanner.nextLine();
    }
}
