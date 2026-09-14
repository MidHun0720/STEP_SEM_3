package STEP_WEEK6_PRACTICE;

class MessWallet {
    private double balance;

    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            this.balance = 0;
            System.out.println("Warning: Negative opening balance not allowed. Starting at 0.");
        } else {
            this.balance = openingBalance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: amount must be greater than 0");
        } else {
            balance += amount;
        }
    }

    public void deduct(double amount) {
        if (amount > balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else if (amount <= 0) {
            System.out.println("Deduct rejected: amount must be positive");
        } else {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class M2 {
    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        System.out.println("Balance after top-up: " + wallet.getBalance());
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());

        System.out.println("--- Additional checks ---");
        MessWallet wallet2 = new MessWallet(-100);
        System.out.println("Balance with negative opening: " + wallet2.getBalance());
        wallet2.topUp(-50);
        wallet2.topUp(100);
        System.out.println("Balance after valid top-up: " + wallet2.getBalance());
        wallet2.deduct(50);
        System.out.println("Balance after deduct 50: " + wallet2.getBalance());
    }
}
