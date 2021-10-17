import java.util.*;

public class _08HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Set<String>> namesAndCards = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String name = input.split(":")[0];
            String cards = input.split(": ")[1];
            String[] cardsAndValue = cards.split(", ");
            namesAndCards.putIfAbsent(name, new LinkedHashSet<>());
            Collections.addAll(namesAndCards.get(name), cardsAndValue);

            input = scanner.nextLine();
        }
        namesAndCards.entrySet().forEach(entry -> {

            int points = getCardPoints(entry.getValue());

            System.out.printf("%s: %d%n", entry.getKey(), points);
        });
    }

    private static int getCardPoints(Set<String> cards) {
        int sum = 0;
        for (String card : cards) {
            String number = "";
            String type = "";
            if (card.length() < 3) {
                number = String.valueOf(card.charAt(0));
                type = String.valueOf(card.charAt(1));
            } else {
                number = card.substring(0, 2);
                type = String.valueOf(card.charAt(2));
            }
            switch (number) {
                case "J":
                    number = "11";
                    break;
                case "Q":
                    number = "12";
                    break;
                case "K":
                    number = "13";
                    break;
                case "A":
                    number = "14";
                    break;
            }
            switch (type) {
                case "S":
                    type = "4";
                    break;
                case "H":
                    type = "3";
                    break;
                case "D":
                    type = "2";
                    break;
                case "C":
                    type = "1";
                    break;
            }
            sum += Integer.parseInt(type) * Integer.parseInt(number);
        }
        return sum;
    }
}

