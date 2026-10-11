package practice.problem3;

import java.util.Arrays;

public class RosterRotation {

    public static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        if (n == 0) {
            return names;
        }
        int shift = (int) (k % n);
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[(i + shift) % n] = names[i];
        }
        return res;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names, 2)));
        System.out.println(Arrays.toString(rotateRoster(names, 7)));
    }
}
