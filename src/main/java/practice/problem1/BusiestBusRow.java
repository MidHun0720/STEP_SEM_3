package practice.problem1;

import java.util.Arrays;

public class BusiestBusRow {

    public static int[] busiestRow(int[][] grid) {
        int bestRow = 0;
        int bestTotal = -1;
        for (int i = 0; i < grid.length; i++) {
            int total = 0;
            for (int v : grid[i]) {
                total += v;
            }
            if (total > bestTotal) {
                bestTotal = total;
                bestRow = i;
            }
        }
        return new int[]{bestRow, bestTotal};
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 0, 1}, {3, 3, 1}, {1, 1, 1}};
        System.out.println("Grid: " + Arrays.deepToString(grid));
        int[] ans = busiestRow(grid);
        System.out.println("Row " + ans[0] + ", Total " + ans[1]);

    }
}
