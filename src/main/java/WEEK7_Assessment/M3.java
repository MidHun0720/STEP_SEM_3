package WEEK7_Assessment;

class PasswordChecker {
    private String password;

    PasswordChecker(String password) {
        this.password = password;
    }

    String getStrength() {
        int l = password.length();
        if (l < 6) {
            return "Weak";
        }
        if (l <= 9) {
            return "Medium";
        }
        return "Strong";
    }
}

public class M3 {
    public static void main(String[] args) {
        PasswordChecker pc = new PasswordChecker("abcd");
        System.out.println(pc.getStrength());
        PasswordChecker pc2 = new PasswordChecker("abcdefghij");
        System.out.println(pc2.getStrength());
    }
}
