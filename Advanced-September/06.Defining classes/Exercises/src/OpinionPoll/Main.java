package OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> personList = new ArrayList<>();
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person opinionPoll = new Person(name, age);
            personList.add(opinionPoll);
        }
        personList.stream().filter(person -> person.getAge() > 30).sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}