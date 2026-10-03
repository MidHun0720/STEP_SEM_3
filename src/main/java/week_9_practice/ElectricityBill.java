package week_9_practice;

import java.util.Scanner;

public class ElectricityBill {
    static abstract class Connection {
        double units;
        String type;
        Connection(String type, double units) {
            this.type = type;
            this.units = units;
        }
        abstract double getBill();
    }
    static class Home extends Connection {
        Home(double units) {
            super("HOME", units);
        }
        public double getBill() {
            if (units <= 100) {
                return units * 5;
            } else {
                return 100 * 5 + (units - 100) * 7;
            }
        }
    }
    static class Shop extends Connection {
        Shop(double units) {
            super("SHOP", units);
        }
        public double getBill() {
            return units * 8 + 100;
        }
    }
    static class Factory extends Connection {
        Factory(double units) {
            super("FACTORY", units);
        }
        public double getBill() {
            double b = units * 6;
            if (b < 1000) {
                return 1000;
            }
            return b;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();
            Connection c = null;
            if (type.equals("HOME")) {
                c = new Home(units);
            } else if (type.equals("SHOP")) {
                c = new Shop(units);
            } else if (type.equals("FACTORY")) {
                c = new Factory(units);
            }
            double bill = c.getBill();
            total = total + bill;
            System.out.printf("%s: %.2f%n", c.type, bill);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
