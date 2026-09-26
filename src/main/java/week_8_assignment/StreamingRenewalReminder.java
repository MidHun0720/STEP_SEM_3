package week_8_assignment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StreamingRenewalReminder {
    static abstract class Plan {
        String name;
        LocalDate start;
        Plan(String name, LocalDate start) {
            this.name = name;
            this.start = start;
        }
        String getName() {
            return name;
        }
        abstract int validityDays();
        LocalDate renewalDate() {
            return start.plusDays(validityDays());
        }
    }
    static class BasicPlan extends Plan {
        BasicPlan(String name, LocalDate start) {
            super(name, start);
        }
        int validityDays() {
            return 30;
        }
    }
    static class StandardPlan extends Plan {
        StandardPlan(String name, LocalDate start) {
            super(name, start);
        }
        int validityDays() {
            return 90;
        }
    }
    static class PremiumPlan extends Plan {
        PremiumPlan(String name, LocalDate start) {
            super(name, start);
        }
        int validityDays() {
            return 365;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Plan> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            while (line.isEmpty()) {
                line = sc.nextLine().trim();
            }
            String[] parts = line.split("\\s+");
            String type = parts[0];
            String name = parts[1];
            LocalDate d = LocalDate.parse(parts[2]);
            if (type.equals("BASIC")) {
                list.add(new BasicPlan(name, d));
            } else if (type.equals("STANDARD")) {
                list.add(new StandardPlan(name, d));
            } else {
                list.add(new PremiumPlan(name, d));
            }
        }
        sc.close();
        for (Plan p : list) {
            System.out.println(p.getName() + ": " + p.renewalDate());
        }
    }
}
