package categoryc.parta;

public class Problem9LeapYear {

    public static boolean isLeap(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    public static void check(int year) {
        System.out.println(isLeap(year) ? "Leap year" : "Not a leap year");
    }

    public static void main(String[] args) {
        check(2024);
        check(1900);
        check(2000);
        if (args.length > 0) {
            check(Integer.parseInt(args[0]));
        }
    }
}
