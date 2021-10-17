import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        // n -> брой на числа за добавяне -> push
        // s -> брой на числата за премахване; -> pop
        // х -> проверка дали го има в стека -> true/false

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();

        //n на брой пъти да добавяме
        for (int count = 1; count <= n; count++) {
            stack.push(scanner.nextInt());
        }

        //s на брой пъти да премахваме
        for (int count = 1; count <= s; count++) {
            stack.pop();
        }

        //x го има в стека
        if (stack.contains(x)) {
            System.out.println("true");
        } else {//x го няма в стека
            //имаме елементи
            if (!stack.isEmpty()) {// isEmpty -проверка дали стека е празен
                //минимален елемент
                System.out.println(Collections.min(stack));
            } else {
                System.out.println(0);
            }
        }


    }
}
