import java.util.*;
import java.util.stream.Collectors;

public class AutumnCocktails {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int[] ingredientsArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] freshnessArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> ingredientsQueue = new ArrayDeque<>();
        for (Integer integer : ingredientsArray) {
            ingredientsQueue.offer(integer);
        }

        Deque<Integer> freshnessStack = new ArrayDeque<>();
        for (Integer integer : freshnessArray) {
            freshnessStack.push(integer);
        }

        Map<String, Integer> cocktailsMade = new TreeMap<>();

        while (true) {
            int currIngredient = ingredientsQueue.peek();
            int currFreshness = freshnessStack.peek();
            if (currIngredient == 0) {
                ingredientsQueue.poll();
                if (!freshnessStack.isEmpty() && !ingredientsQueue.isEmpty()) {
                    continue;
                } else {
                    break;
                }
            }
            int totalFreshness = currIngredient * currFreshness;
            String cocktail = "";

            if (makeTheCocktail(totalFreshness)) {
                cocktail = kindOfCocktail(totalFreshness);
                ingredientsQueue.poll();
                freshnessStack.pop();
                cocktailsMade = addNewCocktail(cocktail, cocktailsMade);
            } else {
                freshnessStack.pop();
                int curIngredientValue = ingredientsQueue.poll() + 5;
                ingredientsQueue.offer(curIngredientValue);
            }
            if (ingredientsQueue.isEmpty() || freshnessStack.isEmpty()) {
                break;
            }

        }
        int count = cocktailsMade.keySet().size();
        if (count >= 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!ingredientsQueue.isEmpty()) {
            int sum = 0;
            for (Integer integer : ingredientsQueue) {
                sum += integer;
            }
            System.out.println("Ingredients left: " + sum);
        }

        if (!cocktailsMade.isEmpty()) {
            for (Map.Entry<String, Integer> stringIntegerEntry : cocktailsMade.entrySet()) {
                System.out.printf("# %s --> %d%n", stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
            }
        }
    }

    private static Map<String, Integer> addNewCocktail(String cocktail, Map<String, Integer> cocktailsMade) {
        if (cocktailsMade.containsKey(cocktail)) {
            String key = cocktail;
            int newCount = cocktailsMade.get(cocktail) + 1;
            cocktailsMade.put(cocktail, newCount);
        } else {
            String key = cocktail;
            int newCount = 1;
            cocktailsMade.put(cocktail, newCount);
        }
        return cocktailsMade;
    }

    private static String kindOfCocktail(int totalFreshness) {
        String cocktail = "";
        switch (totalFreshness) {
            case 150:
                cocktail = "Pear Sour";
                break;
            case 250:
                cocktail = "The Harvest";
                break;
            case 300:
                cocktail = "Apple Hinny";
                break;
            case 400:
                cocktail = "High Fashion";
                break;
        }
        return cocktail;
    }

    private static boolean makeTheCocktail(int totalFreshness) {
        if (totalFreshness == 150 || totalFreshness == 250 || totalFreshness == 300 || totalFreshness == 400) {
            return true;
        } else {
            return false;
        }
    }

}