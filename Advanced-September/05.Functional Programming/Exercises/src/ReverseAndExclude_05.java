import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); //"1 2 3 4 5" -> split -> ["1", "2", "3", "4", "5"]
        List<Integer> numbers =  Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());

        //обръщаме списъка
        Collections.reverse(numbers);

        //премахваме всички числа, които се делят на n
        //приема число -> true / false
        Predicate<Integer> checkDivision = number -> number % n == 0;
        numbers.removeIf(checkDivision);

        numbers.forEach(number -> System.out.print(number + " "));

    }
}
