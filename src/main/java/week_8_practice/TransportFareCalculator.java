package week_8_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransportFareCalculator {
    static abstract class Transport {
        String type;
        double distance;
        Transport(String type, double distance) {
            this.type = type;
            this.distance = distance;
        }
        String getType() {
            return type;
        }
        abstract double calculateFare();
    }
    static class Bus extends Transport {
        Bus(double distance) {
            super("BUS", distance);
        }
        double calculateFare() {
            double fare = 2 + 0.10 * distance;
            if (fare > 10) {
                fare = 10;
            }
            return fare;
        }
    }
    static class Train extends Transport {
        Train(double distance) {
            super("TRAIN", distance);
        }
        double calculateFare() {
            return 3 + 0.15 * distance;
        }
    }
    static class Metro extends Transport {
        double factor;
        Metro(double distance, double factor) {
            super("METRO", distance);
            this.factor = factor;
        }
        double calculateFare() {
            return (1.50 + 0.20 * distance) * factor;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Transport> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            while (line.isEmpty()) {
                line = sc.nextLine().trim();
            }
            String[] parts = line.split("\\s+");
            String type = parts[0];
            double d = Double.parseDouble(parts[1]);
            if (type.equals("BUS")) {
                list.add(new Bus(d));
            } else if (type.equals("TRAIN")) {
                list.add(new Train(d));
            } else {
                double f = Double.parseDouble(parts[2]);
                list.add(new Metro(d, f));
            }
        }
        sc.close();
        double total = 0;
        for (Transport t : list) {
            double fare = t.calculateFare();
            total += fare;
            System.out.printf("%s: %.2f%n", t.getType(), fare);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
