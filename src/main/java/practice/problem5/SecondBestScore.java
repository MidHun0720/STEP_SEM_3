package practice.problem5;

import java.util.Arrays;

public class SecondBestScore {

    public static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;
        for (int s : scores) {
            if (s > highest) {
                second = highest;
                highest = s;
            } else if (s < highest && s > second) {
                second = s;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        int[] a = {45, 78, 92, 78, 60};
        int[] b = {50, 50, 50};
        System.out.println(Arrays.toString(a) + " -> " + secondHighest(a));
        System.out.println(Arrays.toString(b) + " -> " + secondHighest(b));
    }
}
