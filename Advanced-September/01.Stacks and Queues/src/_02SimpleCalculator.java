import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] symbols = input.split("\\s");

        if (symbols.length == 0){
            return;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(Integer.parseInt(symbols[0]));

        for (int i = 1; i < symbols.length; i++) {
            String operations = symbols[i];
            int num = Integer.parseInt(symbols[++i]);
            int stackNum = stack.pop();

            if("+".equals(operations)){
                stack.push(num + stackNum);
            }else if ("-".equals(operations)){
                stack.push(stackNum - num);
            }
        }
        System.out.println(stack.pop());

    }

//    private static String readInput() {
//        Scanner scanner = new Scanner(System.in);
//        return scanner.nextLine();
//    }
}
