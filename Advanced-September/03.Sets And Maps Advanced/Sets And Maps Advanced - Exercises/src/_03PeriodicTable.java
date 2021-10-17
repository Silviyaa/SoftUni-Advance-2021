import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _03PeriodicTable {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
          int n = Integer.parseInt(scanner.nextLine());

        Set<String> chemicalSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] inputChemicalElements = input.split("\\s+");

            chemicalSet.addAll(Arrays.asList(inputChemicalElements));
        }

chemicalSet.forEach(el -> System.out.print(el + " "));

        }
}
