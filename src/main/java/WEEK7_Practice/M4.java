package WEEK7_Practice;

class Locker {
    private String code;
    final int number;

    Locker(int number, String code) {
        this.number = number;
        this.code = code;
    }

    void changeCode(String oldCode, String newCode) {
        if (code.equals(oldCode)) {
            code = newCode;
            System.out.println("success");
        } else {
            System.out.println("rejected");
        }
    }
}

public class M4 {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
    }
}
