package week_8_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaymentFeeCalculation {
    static abstract class Payment {
        String type;
        double amount;
        Payment(String type, double amount) {
            this.type = type;
            this.amount = amount;
        }
        String getType() {
            return type;
        }
        abstract double calculateFinalAmount();
    }
    static class CardPayment extends Payment {
        CardPayment(double amount) {
            super("CARD", amount);
        }
        double calculateFinalAmount() {
            return amount * 1.02;
        }
    }
    static class WalletPayment extends Payment {
        WalletPayment(double amount) {
            super("WALLET", amount);
        }
        double calculateFinalAmount() {
            return amount * 1.01;
        }
    }
    static class BankTransferPayment extends Payment {
        BankTransferPayment(double amount) {
            super("BANKTRANSFER", amount);
        }
        double calculateFinalAmount() {
            return amount;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Payment> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            while (line.isEmpty()) {
                line = sc.nextLine().trim();
            }
            String[] parts = line.split("\\s+");
            String type = parts[0];
            double amt = Double.parseDouble(parts[1]);
            if (type.equals("CARD")) {
                list.add(new CardPayment(amt));
            } else if (type.equals("WALLET")) {
                list.add(new WalletPayment(amt));
            } else {
                list.add(new BankTransferPayment(amt));
            }
        }
        sc.close();
        double total = 0;
        for (Payment p : list) {
            double val = p.calculateFinalAmount();
            total += val;
            System.out.printf("%s: %.2f%n", p.getType(), val);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
