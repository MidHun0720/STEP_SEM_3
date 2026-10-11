package categoryc.parta;

public class Problem10ResultCard {

    static class Student {
        String name;
        int[] marks;

        Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        double average() {
            int sum = 0;
            for (int m : marks) {
                sum += m;
            }
            return (double) sum / marks.length;
        }

        String grade() {
            double avg = average();
            if (avg >= 90) {
                return "A";
            } else if (avg >= 75) {
                return "B";
            } else if (avg >= 60) {
                return "C";
            } else if (avg >= 40) {
                return "D";
            } else {
                return "F";
            }
        }

        void printCard() {
            System.out.printf("%s: Average %.1f, Grade %s%n",
                    name.toUpperCase(), average(), grade());
        }
    }

    public static void main(String[] args) {
        new Student("Asha", new int[]{80, 90, 70}).printCard();
        new Student("Ravi", new int[]{60, 55, 50}).printCard();
    }
}
