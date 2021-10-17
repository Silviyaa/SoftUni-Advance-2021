import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _3MaximumElement {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String command = scanner.nextLine();
            //"1 X" -> push x to stack
            //"2" -> pop/delete of stack
            if(command.equals("2")){
                stack.pop();
            }else if(command.equals("3")){      //"3" -> print max element only if stack is not empty
                // проверка дали имаме елементи
                if(stack.size()>0){
                    System.out.println(Collections.max(stack));
                }
            }else{
                //command = "1 X" .split ->["1", "X"]
                int x =Integer.parseInt(command.split("\\s+")[1]);
                stack.push(x);
            }




        }
    }
}
