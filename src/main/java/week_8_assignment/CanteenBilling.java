package week_8_assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CanteenBilling {
    static abstract class Customer {
        String type;
        double bill;
        Customer(String type, double bill) {
            this.type = type;
            this.bill = bill;
        }
        String getType() {
            return type;
        }
        abstract double calculateFinal();
    }
    static class Student extends Customer {
        Student(double bill) {
            super("STUDENT", bill);
        }
        double calculateFinal() {
            return bill * 0.90;
        }
    }
    static class Staff extends Customer {
        Staff(double bill) {
            super("STAFF", bill);
        }
        double calculateFinal() {
            return bill * 0.95;
        }
    }
    static class Guest extends Customer {
        Guest(double bill) {
            super("GUEST", bill);
        }
        double calculateFinal() {
            return bill + 10;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Customer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            while (line.isEmpty()) {
                line = sc.nextLine().trim();
            }
            String[] parts = line.split("\\s+");
            String type = parts[0];
            double amt = Double.parseDouble(parts[1]);
            if (type.equals("STUDENT")) {
                list.add(new Student(amt));
            } else if (type.equals("STAFF")) {
                list.add(new Staff(amt));
            } else {
                list.add(new Guest(amt));
            }
        }
        sc.close();
        double total = 0;
        for (Customer c : list) {
            double v = c.calculateFinal();
            total += v;
            System.out.printf("%s: %.2f%n", c.getType(), v);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
