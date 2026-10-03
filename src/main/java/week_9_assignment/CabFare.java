package week_9_assignment;

import java.util.Scanner;

public class CabFare {
    static abstract class Cab {
        double km;
        String type;
        Cab(String type, double km) {
            this.type = type;
            this.km = km;
        }
        abstract double getRate();
        double getDayFare() {
            double f = km * getRate();
            if (f < 100) {
                return 100;
            }
            return f;
        }
    }
    static interface NightService {
        double withNight(double base);
    }
    static class Mini extends Cab {
        Mini(double km) {
            super("MINI", km);
        }
        public double getRate() {
            return 10;
        }
    }
    static class Sedan extends Cab implements NightService {
        Sedan(double km) {
            super("SEDAN", km);
        }
        public double getRate() {
            return 14;
        }
        public double withNight(double base) {
            return base * 1.2;
        }
    }
    static class Suv extends Cab implements NightService {
        Suv(double km) {
            super("SUV", km);
        }
        public double getRate() {
            return 18;
        }
        public double withNight(double base) {
            return base * 1.2;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String cab = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            Cab c = null;
            if (cab.equals("MINI")) {
                c = new Mini(km);
            } else if (cab.equals("SEDAN")) {
                c = new Sedan(km);
            } else if (cab.equals("SUV")) {
                c = new Suv(km);
            }
            if (time.equals("NIGHT")) {
                if (c instanceof NightService) {
                    double fare = ((NightService) c).withNight(c.getDayFare());
                    total = total + fare;
                    System.out.printf("%s: %.2f%n", c.type, fare);
                } else {
                    System.out.printf("%s: night service not available%n", c.type);
                }
            } else {
                double fare = c.getDayFare();
                total = total + fare;
                System.out.printf("%s: %.2f%n", c.type, fare);
            }
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
