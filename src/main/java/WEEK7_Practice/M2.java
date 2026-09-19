package WEEK7_Practice;

class Scorecard {
    private boolean[] results;
    private int count;

    Scorecard(int n) {
        results = new boolean[n];
        count = 0;
    }

    void recordAnswer(boolean r) {
        if (count < results.length) {
            results[count] = r;
            count = count + 1;
        }
    }

    int getScore() {
        int s = 0;
        for (int i = 0; i < count; i++) {
            if (results[i]) {
                s = s + 1;
            }
        }
        return s;
    }
}

public class M2 {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println(sc.getScore());
    }
}
