package categoryc.parta;

import java.util.Arrays;

public class Problem3EvenOddCounter {

    public static int[] count(int[] list) {
        int even = 0, odd = 0;
        for (int n : list) {
            if (n % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return new int[]{even, odd};
    }

    public static void main(String[] args) {
        int[] sample = {3, 8, 12, 5, 7, 10};
        int[] r = count(sample);
        System.out.println("Input: " + Arrays.toString(sample));
        System.out.println("Even: " + r[0]);
        System.out.println("Odd: " + r[1]);
    }
}
