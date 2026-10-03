package week_9_practice;

import java.util.Scanner;

public class TravelBooking {
    static abstract class Booking {
        static double FEE = 50;
        double km;
        String mode;
        Booking(String mode, double km) {
            this.mode = mode;
            this.km = km;
        }
        abstract double getFare();
        double getTotal() {
            return getFare() + FEE;
        }
    }
    static class Bus extends Booking {
        Bus(double km) {
            super("BUS", km);
        }
        public double getFare() {
            return 2 * km;
        }
    }
    static class Train extends Booking {
        Train(double km) {
            super("TRAIN", km);
        }
        public double getFare() {
            return 1.5 * km;
        }
    }
    static class Flight extends Booking {
        Flight(double km) {
            super("FLIGHT", km);
        }
        public double getFare() {
            return 2500 + 4 * km;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double km = sc.nextDouble();
            Booking b = null;
            if (mode.equals("BUS")) {
                b = new Bus(km);
            } else if (mode.equals("TRAIN")) {
                b = new Train(km);
            } else if (mode.equals("FLIGHT")) {
                b = new Flight(km);
            }
            System.out.printf("%s: %.2f%n", b.mode, b.getTotal());
        }
        sc.close();
    }
}
