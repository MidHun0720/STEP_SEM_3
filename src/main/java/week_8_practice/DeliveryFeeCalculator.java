package week_8_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryFeeCalculator {
    static abstract class Delivery {
        String type;
        double weight;
        double distance;
        Delivery(String type, double weight, double distance) {
            this.type = type;
            this.weight = weight;
            this.distance = distance;
        }
        String getType() {
            return type;
        }
        abstract double calculateFee();
    }
    static class StandardDelivery extends Delivery {
        StandardDelivery(double weight, double distance) {
            super("STANDARD", weight, distance);
        }
        double calculateFee() {
            return 5 + 0.50 * weight + 0.10 * distance;
        }
    }
    static class ExpressDelivery extends Delivery {
        ExpressDelivery(double weight, double distance) {
            super("EXPRESS", weight, distance);
        }
        double calculateFee() {
            return 15 + 1.00 * weight + 0.20 * distance;
        }
    }
    static class InternationalDelivery extends Delivery {
        double customsFee;
        InternationalDelivery(double weight, double distance, double customsFee) {
            super("INTERNATIONAL", weight, distance);
            this.customsFee = customsFee;
        }
        double calculateFee() {
            return 25 + 2.00 * weight + 0.50 * distance + customsFee;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Delivery> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            while (line.isEmpty()) {
                line = sc.nextLine().trim();
            }
            String[] parts = line.split("\\s+");
            String type = parts[0];
            double w = Double.parseDouble(parts[1]);
            double d = Double.parseDouble(parts[2]);
            if (type.equals("STANDARD")) {
                list.add(new StandardDelivery(w, d));
            } else if (type.equals("EXPRESS")) {
                list.add(new ExpressDelivery(w, d));
            } else {
                double c = Double.parseDouble(parts[3]);
                list.add(new InternationalDelivery(w, d, c));
            }
        }
        sc.close();
        double total = 0;
        for (Delivery x : list) {
            double fee = x.calculateFee();
            total += fee;
            System.out.printf("%s: %.2f%n", x.getType(), fee);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
