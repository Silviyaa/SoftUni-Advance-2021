import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        //name -> true/ false
        //true: length <= n
        //false: length > n
        Predicate<String> validLength = name -> name.length() <= n;
        String [] names = scanner.nextLine().split("\\s+"); //"Sara Sam George Mark John".split -> ["Sara", "Sam", ...]

        Arrays.stream(names).filter(validLength).forEach(System.out::println);
        //filter ->true: оставя; false: маха
        // оставя в списъка елементите, които отговарят на дадено условие

    }
}
