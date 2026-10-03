package week_9_assignment;

import java.util.Scanner;

public class ApplianceEnergy {
    static abstract class Appliance {
        double hours;
        String type;
        Appliance(String type, double hours) {
            this.type = type;
            this.hours = hours;
        }
        abstract double getPower();
        double getUnits() {
            return getPower() * hours / 1000;
        }
    }
    static interface SaverCapable {
        double getSaverUnits(double base);
    }
    static class Fridge extends Appliance {
        Fridge(double hours) {
            super("FRIDGE", hours);
        }
        public double getPower() {
            return 150;
        }
    }
    static class Ac extends Appliance implements SaverCapable {
        Ac(double hours) {
            super("AC", hours);
        }
        public double getPower() {
            return 1500;
        }
        public double getSaverUnits(double base) {
            return base * 0.75;
        }
    }
    static class Tv extends Appliance {
        Tv(double hours) {
            super("TV", hours);
        }
        public double getPower() {
            return 100;
        }
    }
    static class Washer extends Appliance implements SaverCapable {
        Washer(double hours) {
            super("WASHER", hours);
        }
        public double getPower() {
            return 500;
        }
        public double getSaverUnits(double base) {
            return base * 0.75;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            while (line.equals("")) {
                line = sc.nextLine().trim();
            }
            String[] parts = line.split(" ");
            String name = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saver = parts.length > 2;
            Appliance a = null;
            if (name.equals("FRIDGE")) {
                a = new Fridge(hours);
            } else if (name.equals("AC")) {
                a = new Ac(hours);
            } else if (name.equals("TV")) {
                a = new Tv(hours);
            } else if (name.equals("WASHER")) {
                a = new Washer(hours);
            }
            if (saver) {
                if (a instanceof SaverCapable) {
                    double units = ((SaverCapable) a).getSaverUnits(a.getUnits());
                    double cost = units * 8;
                    total = total + cost;
                    System.out.printf("%s: Units=%.2f Cost=%.2f%n", a.type, units, cost);
                } else {
                    System.out.printf("%s: saver mode not supported%n", a.type);
                }
            } else {
                double units = a.getUnits();
                double cost = units * 8;
                total = total + cost;
                System.out.printf("%s: Units=%.2f Cost=%.2f%n", a.type, units, cost);
            }
        }
        System.out.printf("Total Cost: %.2f%n", total);
        sc.close();
    }
}
