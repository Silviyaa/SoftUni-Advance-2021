package CompanyRoster;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfEmployees = Integer.parseInt(scanner.nextLine());
        Map<String, Department> departments = new HashMap<>();
        for (int i = 0; i < numberOfEmployees; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            Employee employee = null;
            if (tokens.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (tokens.length == 5) {
                try {
                    int age = Integer.parseInt(tokens[4]);
                    employee = new Employee(name, salary, position, department, age);
                } catch (NumberFormatException exception) {
                    String email = tokens[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            }
            departments.putIfAbsent(department, new Department(department));
            departments.get(department).getEmployees().add(employee);
        }
        Department highestDepartment = departments.entrySet().stream()
                .max(Comparator.comparing(entry -> entry.getValue().averageSalary()))
                .get().getValue();
        System.out.println("Highest Average Salary: " + highestDepartment.getName());
        highestDepartment.getEmployees().stream().
                sorted((e1,e2)->Double.compare(e2.getSalary(), e1.getSalary())).forEach(System.out::println);

    }
}
