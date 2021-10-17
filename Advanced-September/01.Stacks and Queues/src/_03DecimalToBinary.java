import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        if(number == 0){
            System.out.println(0);
        }

        Deque<Integer> stack = new ArrayDeque<>();

        while (number > 0 ){
            stack.push(number % 2);
            number /= 2;
        }

        int size = stack.size();
//       while (size > 0){
//           System.out.println(stack.pop());
//       }

        for (int i = 0; i < size; i++) {
            System.out.println(stack.pop());
        }



    }

//    private static int readDecimal(Scanner scanner) {
//        return scanner.nextInt();
//    }
}
