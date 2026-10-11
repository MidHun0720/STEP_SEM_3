package practice.problem2;

import java.util.Arrays;

public class AttendanceTracker {

    public static int[] attendanceSummary(int[] days) {
        int present = 0;
        int longest = 0;
        int current = 0;
        for (int d : days) {
            if (d == 1) {
                present++;
                current++;
                if (current > longest) {
                    longest = current;
                }
            } else {
                current = 0;
            }
        }
        return new int[]{present, longest};
    }

    public static void print(int[] days) {
        int[] r = attendanceSummary(days);
        System.out.println("days = " + Arrays.toString(days));
        System.out.println("Present: " + r[0] + ", Longest streak: " + r[1]);
    }

    public static void main(String[] args) {
        print(new int[]{1, 1, 0, 1, 1, 1, 0, 1});
        print(new int[]{0, 0, 0});
    }
}
