
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Comparator<Integer> sortEvenBeforeOdd = (first, second) -> {
            //we need even before odd
            //if first odd , second even
            if (first % 2 == 0 && second % 2 != 0) {
                return -1;
            }
            //if first even , second odd
            if (first % 2 != 0 && second % 2 == 0) {
                return 1;
            } else {
                //if both are even
                //if both odd
                //compare by size instead of returning 0, this will sort the ArrayList by numeric value after it was sorted by even and odd
                return first.compareTo(second);
            }
        };

        numbers.stream().sorted(sortEvenBeforeOdd).forEach(x -> System.out.print(x + " "));

    }
}