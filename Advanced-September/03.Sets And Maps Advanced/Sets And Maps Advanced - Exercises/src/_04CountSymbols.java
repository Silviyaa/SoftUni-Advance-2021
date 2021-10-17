import java.util.Scanner;
import java.util.TreeMap;

public class _04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        TreeMap<Character, Integer> symbolCount = new TreeMap<>();

        for (int index = 0; index < input.length(); index++) {
            char currentSymbol = input.charAt(index);
            //символът вече да съм го срещала
            if (symbolCount.containsKey(currentSymbol)) {
                int currentCount = symbolCount.get(currentSymbol);
                symbolCount.put(currentSymbol, currentCount + 1);
            }//символът да не съм го срещала
            else {
                symbolCount.put(currentSymbol, 1);
            }
        }
        //символ: бр.срещания time/s
        symbolCount.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s"));
    }

}
