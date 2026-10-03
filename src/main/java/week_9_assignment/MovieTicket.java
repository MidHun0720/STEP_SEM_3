package week_9_assignment;

import java.util.Scanner;

public class MovieTicket {
    static abstract class Ticket {
        static double FEE = 20;
        int count;
        String seat;
        Ticket(String seat, int count) {
            this.seat = seat;
            this.count = count;
        }
        abstract double getPrice();
        double getAmount() {
            return count * getPrice() + count * FEE;
        }
    }
    static class Regular extends Ticket {
        Regular(int count) {
            super("REGULAR", count);
        }
        public double getPrice() {
            return 150;
        }
    }
    static class Premium extends Ticket {
        Premium(int count) {
            super("PREMIUM", count);
        }
        public double getPrice() {
            return 250;
        }
    }
    static class Recliner extends Ticket {
        Recliner(int count) {
            super("RECLINER", count);
        }
        public double getPrice() {
            return 400;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();
            Ticket t = null;
            if (seat.equals("REGULAR")) {
                t = new Regular(count);
            } else if (seat.equals("PREMIUM")) {
                t = new Premium(count);
            } else if (seat.equals("RECLINER")) {
                t = new Recliner(count);
            }
            double amt = t.getAmount();
            total = total + amt;
            System.out.printf("%s: %.2f%n", t.seat, amt);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
