import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetics_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine(); //"1 2 3 4 5" -> split -> ["1", "2", "3", "4", "5"]
        int[] numbers = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();

        //add -> adds 1: приемем масив -> върнем масив
        Function<int[], int[]> add = array -> Arrays.stream(array).map(number -> number += 1).toArray();

        //multiply -> multiply by 2: примем масив -> върна масив
        Function<int[], int[]> multiply = array -> Arrays.stream(array).map(number -> number *= 2).toArray();

        //subtract -> subtracts 1: приемам масив -> връщам масив
        Function<int[], int[]> subtract = array -> Arrays.stream(array).map(number -> number -= 1).toArray();

        //print -> print all elements: приема масив -> отпечатам елементите
        Consumer<int[]> print = array -> Arrays.stream(array).forEach(number -> System.out.print(number + " "));


        String command = scanner.nextLine();
        while (!command.equals("end")) {
            //add, multiply, subtract, print
            switch (command) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;

            }
            command = scanner.nextLine();
        }


    }
}
