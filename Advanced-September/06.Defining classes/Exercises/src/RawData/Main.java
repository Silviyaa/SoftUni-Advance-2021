package RawData;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Car> carList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        Car car;
        Engine engine;
        Cargo cargo;
        Tire tire1;
        Tire tire2;
        Tire tire3;
        Tire tire4;
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int speed = Integer.parseInt(tokens[1]);
            int power = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tire1c = Double.parseDouble(tokens[5]);
            int tireAge1c = Integer.parseInt(tokens[6]);
            double tire2c = Double.parseDouble(tokens[7]);
            int tireAge2c = Integer.parseInt(tokens[8]);
            double tire3c = Double.parseDouble(tokens[9]);
            int tireAge3c = Integer.parseInt(tokens[10]);
            double tire4c = Double.parseDouble(tokens[11]);
            int tireAge4c = Integer.parseInt(tokens[12]);
            engine = new Engine(speed, power);
            cargo = new Cargo(cargoWeight, cargoType);
            tire1 = new Tire(tire1c, tireAge1c);
            tire2 = new Tire(tire2c, tireAge2c);
            tire3 = new Tire(tire3c, tireAge3c);
            tire4 = new Tire(tire4c, tireAge4c);
            car = new Car(model, engine, cargo, tire1, tire2, tire3, tire4);
            carList.add(car);
        }
        String command = scanner.nextLine();
        ArrayList<String> output = new ArrayList<>();
        if (command.equals("fragile")) {
            carList.forEach(cars -> {
                if (cars.getCargo().getType().equals("fragile")) {
                    for (Tire allTires : cars.getTires()) {
                        if (allTires.getPressure() < 1) {
                            output.add(cars.getModel());
                            break;
                        }
                    }
                }
            });
        } else {
            carList.forEach(cars -> {
                if (cars.getCargo().getType().equals("flamable") && cars.getEngine().getEnginePower() > 250) {
                    output.add(cars.getModel());
                }
            });
        }
        output.forEach(System.out::println);
    }
}
