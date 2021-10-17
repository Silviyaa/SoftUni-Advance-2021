package CustomListSorter;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        CustomList<String> customList = new CustomList<>();
        while (!input.equals("END")) {
            String[] commands = input.split("\\s+");
            String commandName = commands[0];
            switch (commandName) {
                case "Add":
                    String elementToAdd = commands[1];
                    customList.add(elementToAdd);
                    break;
                case "Remove":
                    int index = Integer.parseInt(commands[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    String element = commands[1];
                    System.out.println(customList.contains(element));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(commands[1]);
                    int secondIndex = Integer.parseInt(commands[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String elementToCompare = commands[1];
                    System.out.println(customList.countGreaterThan(elementToCompare));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
                case "Print":
                    System.out.print(customList);
                    break;
            }
            input = scanner.nextLine();
        }
    }
}