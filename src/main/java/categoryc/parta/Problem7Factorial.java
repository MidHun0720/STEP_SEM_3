package categoryc.parta;

public class Problem7Factorial {

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(factorial(0));
        if (args.length > 0) {
            System.out.println(factorial(Integer.parseInt(args[0])));
        }
    }
}
