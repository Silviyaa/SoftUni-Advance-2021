import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        // n -> брой на числа за добавяне -> push
        // s -> брой на числата за премахване; -> pop
        // х -> проверка дали го има в стека -> true/false

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();

        //n на брой пъти да добавяме
        for (int count = 1; count <= n; count++) {
            queue.offer(scanner.nextInt());
        }

        //s на брой пъти да премахваме
        for (int count = 1; count <= s; count++) {
            queue.poll();
        }

        //x го има в стека
        if (queue.contains(x)) {
            System.out.println("true");
        } else {//x го няма в стека
            //имаме елементи
            if (!queue.isEmpty()) {// isEmpty -проверка дали стека е празен
                //минимален елемент
                System.out.println(Collections.min(queue));
            } else {
                System.out.println(0);
            }
        }


    }
}
