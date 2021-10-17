package CarSalesman;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfEngines = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> engines = new HashMap<>();
        for (int i = 0; i < numberOfEngines; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);
            Engine engine = null;
            if (tokens.length == 2) {
                engine = new Engine(model, power);
            } else if (tokens.length == 4) {
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                engine = new Engine(model, power, displacement, efficiency);
            } else if (tokens.length == 3) {
                try {
                    int displacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(model, power, displacement);
                } catch (NumberFormatException exception) {
                    String efficiency = tokens[2];
                    engine = new Engine(model, power, efficiency);
                }
            }
            engines.put(model, engine);
        }
        List<Car> cars = new ArrayList<>();
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCars; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String model = tokens[0];
            String engineModel = tokens[1];
            Engine carEngine = engines.get(engineModel);
            Car car = null;
            if (tokens.length == 2) {
                car = new Car(model, carEngine);
            } else if (tokens.length == 4) {
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                car = new Car(model, carEngine, weight, color);
            } else {
                try {
                    int weight = Integer.parseInt(tokens[2]);
                    car = new Car(model, carEngine, weight);
                } catch (NumberFormatException exception) {
                    String color = tokens[2];
                    car = new Car(model, carEngine, color);
                }
            }
            cars.add(car);
        }
        cars.forEach(System.out::println);
    }
}
