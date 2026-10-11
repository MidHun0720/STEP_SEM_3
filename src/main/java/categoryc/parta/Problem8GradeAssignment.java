package categoryc.parta;

public class Problem8GradeAssignment {

    public static String grade(int marks) {
        if (marks >= 90) {
            return "A";
        } else if (marks >= 75) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 40) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        int[] samples = {72, 95, 35};
        for (int m : samples) {
            System.out.println("Grade " + grade(m));
        }
        if (args.length > 0) {
            System.out.println("Grade " + grade(Integer.parseInt(args[0])));
        }
    }
}
