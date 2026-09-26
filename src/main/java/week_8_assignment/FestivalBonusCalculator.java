package week_8_assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FestivalBonusCalculator {
    static abstract class Employee {
        String name;
        double salary;
        Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }
        String getName() {
            return name;
        }
        abstract double calculateBonus();
    }
    static class FullTime extends Employee {
        FullTime(String name, double salary) {
            super(name, salary);
        }
        double calculateBonus() {
            return salary * 0.10;
        }
    }
    static class PartTime extends Employee {
        PartTime(String name, double salary) {
            super(name, salary);
        }
        double calculateBonus() {
            return salary * 0.05;
        }
    }
    static class Intern extends Employee {
        Intern(String name, double salary) {
            super(name, salary);
        }
        double calculateBonus() {
            return 2000;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            while (line.isEmpty()) {
                line = sc.nextLine().trim();
            }
            String[] parts = line.split("\\s+");
            String type = parts[0];
            String name = parts[1];
            double sal = Double.parseDouble(parts[2]);
            if (type.equals("FULLTIME")) {
                list.add(new FullTime(name, sal));
            } else if (type.equals("PARTTIME")) {
                list.add(new PartTime(name, sal));
            } else {
                list.add(new Intern(name, sal));
            }
        }
        sc.close();
        double total = 0;
        for (Employee e : list) {
            double b = e.calculateBonus();
            total += b;
            System.out.printf("%s: %.2f%n", e.getName(), b);
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }
}
