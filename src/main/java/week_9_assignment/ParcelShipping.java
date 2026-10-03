package week_9_assignment;

import java.util.Scanner;

public class ParcelShipping {
    static abstract class Parcel {
        double weight;
        double value;
        String type;
        Parcel(String type, double weight, double value) {
            this.type = type;
            this.weight = weight;
            this.value = value;
        }
        abstract double getCharge();
    }
    static interface Insurable {
        double getInsurance();
    }
    static class Standard extends Parcel {
        Standard(double weight, double value) {
            super("STANDARD", weight, value);
        }
        public double getCharge() {
            return 40 + 10 * weight;
        }
    }
    static class Express extends Parcel implements Insurable {
        Express(double weight, double value) {
            super("EXPRESS", weight, value);
        }
        public double getCharge() {
            return 80 + 15 * weight;
        }
        public double getInsurance() {
            return value * 0.02;
        }
    }
    static class Fragile extends Parcel implements Insurable {
        Fragile(double weight, double value) {
            super("FRAGILE", weight, value);
        }
        public double getCharge() {
            return 40 + 10 * weight + 50;
        }
        public double getInsurance() {
            return value * 0.02;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grand = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double w = sc.nextDouble();
            double v = sc.nextDouble();
            Parcel p = null;
            if (type.equals("STANDARD")) {
                p = new Standard(w, v);
            } else if (type.equals("EXPRESS")) {
                p = new Express(w, v);
            } else if (type.equals("FRAGILE")) {
                p = new Fragile(w, v);
            }
            double charge = p.getCharge();
            double ins = 0;
            if (p instanceof Insurable) {
                ins = ((Insurable) p).getInsurance();
            }
            double tot = charge + ins;
            grand = grand + tot;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", p.type, charge, ins, tot);
        }
        System.out.printf("Grand Total: %.2f%n", grand);
        sc.close();
    }
}
