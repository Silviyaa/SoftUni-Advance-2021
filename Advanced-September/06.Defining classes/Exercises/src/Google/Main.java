package Google;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Person> personMap = new HashMap<>();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            String data = tokens[1];
            if (!personMap.containsKey(name)) {
                personMap.put(name, new Person());
            }
            switch (data) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName, department, salary);
                    personMap.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    personMap.get(name).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String birthday = tokens[3];
                    Parents parents = new Parents(parentName, birthday);
                    personMap.get(name).getParents().add(parents);
                    break;
                case "children":
                    String childrenName = tokens[2];
                    String childrenBirthday = tokens[3];
                    Children children = new Children(childrenName, childrenBirthday);
                    personMap.get(name).getChildren().add(children);
                    break;
                case "car":
                    String carModel = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);
                    Car car = new Car(carModel, carSpeed);
                    personMap.get(name).setCar(car);
                    break;
            }
            input = scanner.nextLine();
        }
        String searchPerson = scanner.nextLine();
        System.out.println(searchPerson);
        Person personData = personMap.get(searchPerson);
        System.out.println(personData);
    }
}