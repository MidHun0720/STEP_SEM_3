package week_9_assignment;

import java.util.Scanner;

public class CollegeFee {
    static abstract class Student {
        String name;
        Student(String name) {
            this.name = name;
        }
        abstract double getTuition();
        abstract boolean usesBus();
        double getTotal() {
            double t = getTuition();
            if (usesBus()) {
                t = t + 12000;
            }
            return t;
        }
    }
    static class DayScholar extends Student {
        DayScholar(String name) {
            super(name);
        }
        public double getTuition() {
            return 40000;
        }
        public boolean usesBus() {
            return true;
        }
    }
    static class Hosteller extends Student {
        Hosteller(String name) {
            super(name);
        }
        public double getTuition() {
            return 40000 + 60000;
        }
        public boolean usesBus() {
            return false;
        }
    }
    static class Scholar extends Student {
        Scholar(String name) {
            super(name);
        }
        public double getTuition() {
            return 20000;
        }
        public boolean usesBus() {
            return true;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Student s = null;
            if (type.equals("DAY_SCHOLAR")) {
                s = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                s = new Hosteller(name);
            } else if (type.equals("SCHOLAR")) {
                s = new Scholar(name);
            }
            double fee = s.getTotal();
            total = total + fee;
            System.out.printf("%s: %.2f%n", s.name, fee);
        }
        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
