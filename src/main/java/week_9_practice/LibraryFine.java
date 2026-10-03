package week_9_practice;

import java.util.Scanner;

public class LibraryFine {
    static abstract class Item {
        String title;
        int days;
        Item(String title, int days) {
            this.title = title;
            this.days = days;
        }
        abstract double getFine();
    }
    static class Book extends Item {
        Book(String title, int days) {
            super(title, days);
        }
        public double getFine() {
            return 2 * days;
        }
    }
    static class Dvd extends Item {
        Dvd(String title, int days) {
            super(title, days);
        }
        public double getFine() {
            double f = 5 * days;
            if (f > 50) {
                return 50;
            }
            return f;
        }
    }
    static class Magazine extends Item {
        Magazine(String title, int days) {
            super(title, days);
        }
        public double getFine() {
            return 1 * days;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int days = sc.nextInt();
            Item it = null;
            if (type.equals("BOOK")) {
                it = new Book(title, days);
            } else if (type.equals("DVD")) {
                it = new Dvd(title, days);
            } else if (type.equals("MAGAZINE")) {
                it = new Magazine(title, days);
            }
            double fine = it.getFine();
            total = total + fine;
            System.out.printf("%s: %.2f%n", it.title, fine);
        }
        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}
