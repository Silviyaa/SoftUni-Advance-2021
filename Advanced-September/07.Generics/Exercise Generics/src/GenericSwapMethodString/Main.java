package GenericSwapMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<String> box = new Box<>();
        for (int i = 0; i < n; i++) {
            String value = scanner.nextLine();
            box.add(value);
        }
        String[] tokens = scanner.nextLine().split(" ");
        int firstIndex  = Integer.parseInt(tokens[0]);
        int secondIndex  = Integer.parseInt(tokens[1]);
        box.swap(firstIndex,secondIndex);
        System.out.println(box);

    }
}
