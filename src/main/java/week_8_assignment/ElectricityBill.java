package week_8_assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElectricityBill {
    static abstract class Room {
        String type;
        int units;
        Room(String type, int units) {
            this.type = type;
            this.units = units;
        }
        String getType() {
            return type;
        }
        abstract double calculateBill();
    }
    static class SingleRoom extends Room {
        SingleRoom(int units) {
            super("SINGLE", units);
        }
        double calculateBill() {
            return 8.0 * units;
        }
    }
    static class SharedRoom extends Room {
        int occupants;
        SharedRoom(int units, int occupants) {
            super("SHARED", units);
            this.occupants = occupants;
        }
        double calculateBill() {
            return (6.0 * units) / occupants;
        }
    }
    static class AcRoom extends Room {
        AcRoom(int units) {
            super("AC", units);
        }
        double calculateBill() {
            return 10.0 * units + 200;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Room> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            while (line.isEmpty()) {
                line = sc.nextLine().trim();
            }
            String[] parts = line.split("\\s+");
            String type = parts[0];
            int u = Integer.parseInt(parts[1]);
            if (type.equals("SINGLE")) {
                list.add(new SingleRoom(u));
            } else if (type.equals("SHARED")) {
                int o = Integer.parseInt(parts[2]);
                list.add(new SharedRoom(u, o));
            } else {
                list.add(new AcRoom(u));
            }
        }
        sc.close();
        double total = 0;
        for (Room r : list) {
            double b = r.calculateBill();
            total += b;
            System.out.printf("%s: %.2f%n", r.getType(), b);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
