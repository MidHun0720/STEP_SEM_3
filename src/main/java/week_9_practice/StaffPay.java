package week_9_practice;

import java.util.Scanner;

public class StaffPay {
    static abstract class Staff {
        String name;
        Staff(String name) {
            this.name = name;
        }
        abstract double getPay();
    }
    static class FullTime extends Staff {
        double salary;
        FullTime(String name, double salary) {
            super(name);
            this.salary = salary;
        }
        public double getPay() {
            return salary;
        }
    }
    static class Hourly extends Staff {
        double hours;
        double rate;
        Hourly(String name, double hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }
        public double getPay() {
            if (hours <= 40) {
                return hours * rate;
            } else {
                return 40 * rate + (hours - 40) * rate * 1.5;
            }
        }
    }
    static class Intern extends Staff {
        double stipend;
        Intern(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }
        public double getPay() {
            return stipend;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Staff s = null;
            if (type.equals("FULLTIME")) {
                double sal = sc.nextDouble();
                s = new FullTime(name, sal);
            } else if (type.equals("HOURLY")) {
                double h = sc.nextDouble();
                double r = sc.nextDouble();
                s = new Hourly(name, h, r);
            } else if (type.equals("INTERN")) {
                double st = sc.nextDouble();
                s = new Intern(name, st);
            }
            double pay = s.getPay();
            total = total + pay;
            System.out.printf("%s: %.2f%n", s.name, pay);
        }
        System.out.printf("Total Payroll: %.2f%n", total);
        sc.close();
    }
}
