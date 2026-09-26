package week_8_assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingChargeCalculator {
    static abstract class Vehicle {
        String type;
        int hours;
        Vehicle(String type, int hours) {
            this.type = type;
            this.hours = hours;
        }
        String getType() {
            return type;
        }
        abstract double calculateCharge();
    }
    static class Bike extends Vehicle {
        Bike(int hours) {
            super("BIKE", hours);
        }
        double calculateCharge() {
            return 10.0 * hours;
        }
    }
    static class Car extends Vehicle {
        Car(int hours) {
            super("CAR", hours);
        }
        double calculateCharge() {
            return 30 + 20.0 * (hours - 1);
        }
    }
    static class Truck extends Vehicle {
        Truck(int hours) {
            super("TRUCK", hours);
        }
        double calculateCharge() {
            double c = 50.0 * hours;
            if (c < 100) {
                c = 100;
            }
            return c;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Vehicle> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            while (line.isEmpty()) {
                line = sc.nextLine().trim();
            }
            String[] parts = line.split("\\s+");
            String type = parts[0];
            int h = Integer.parseInt(parts[1]);
            if (type.equals("BIKE")) {
                list.add(new Bike(h));
            } else if (type.equals("CAR")) {
                list.add(new Car(h));
            } else {
                list.add(new Truck(h));
            }
        }
        sc.close();
        double total = 0;
        for (Vehicle v : list) {
            double c = v.calculateCharge();
            total += c;
            System.out.printf("%s: %.2f%n", v.getType(), c);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
