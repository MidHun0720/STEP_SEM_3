package categoryc.parta;

public class Problem5DigitSumReversal {

    public static int digitSum(int n) {
        int sum = 0;
        n = Math.abs(n);
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static int reverse(int n) {
        int rev = 0;
        n = Math.abs(n);
        while (n > 0) {
            rev = rev * 10 + (n % 10);
            n /= 10;
        }
        return rev;
    }

    public static void process(int n) {
        System.out.println("Sum of digits: " + digitSum(n));
        System.out.println("Reverse: " + reverse(n));
    }

    public static void main(String[] args) {
        int sample = 4721;
        System.out.println("Input: " + sample);
        process(sample);
        if (args.length > 0) {
            process(Integer.parseInt(args[0]));
        }
    }
}
