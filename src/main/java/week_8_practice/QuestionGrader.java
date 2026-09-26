package week_8_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuestionGrader {
    static abstract class Question {
        String type;
        double points;
        Question(String type, double points) {
            this.type = type;
            this.points = points;
        }
        String getType() {
            return type;
        }
        abstract double evaluate();
    }
    static class McqQuestion extends Question {
        String correct;
        String student;
        McqQuestion(String correct, String student, double points) {
            super("MCQ", points);
            this.correct = correct;
            this.student = student;
        }
        double evaluate() {
            if (correct.equals(student)) {
                return points;
            }
            return 0;
        }
    }
    static class TfQuestion extends Question {
        String correct;
        String student;
        TfQuestion(String correct, String student, double points) {
            super("TF", points);
            this.correct = correct;
            this.student = student;
        }
        double evaluate() {
            if (correct.equals(student)) {
                return points;
            }
            return 0;
        }
    }
    static class EssayQuestion extends Question {
        String correct;
        String student;
        EssayQuestion(String correct, String student, double points) {
            super("ESSAY", points);
            this.correct = correct;
            this.student = student;
        }
        double evaluate() {
            String[] keys = correct.split(",");
            String low = student.toLowerCase();
            int count = 0;
            for (String k : keys) {
                String key = k.trim().toLowerCase();
                if (!key.isEmpty() && low.contains(key)) {
                    count++;
                }
            }
            if (count >= 2) {
                return points * 0.75;
            } else if (count == 1) {
                return points * 0.50;
            } else {
                return 0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Question> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("\"([^\"]*)\"");
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            while (line.trim().isEmpty()) {
                line = sc.nextLine();
            }
            String type = line.trim().split("\\s+")[0];
            Matcher m = pattern.matcher(line);
            List<String> quoted = new ArrayList<>();
            while (m.find()) {
                quoted.add(m.group(1));
            }
            String last = line.trim().substring(line.trim().lastIndexOf(" ") + 1);
            double pts = Double.parseDouble(last);
            String correct = quoted.get(1);
            String student = quoted.get(2);
            if (type.equals("MCQ")) {
                list.add(new McqQuestion(correct, student, pts));
            } else if (type.equals("TF")) {
                list.add(new TfQuestion(correct, student, pts));
            } else {
                list.add(new EssayQuestion(correct, student, pts));
            }
        }
        sc.close();
        double total = 0;
        for (Question q : list) {
            double s = q.evaluate();
            total += s;
            System.out.printf("%s: %.2f%n", q.getType(), s);
        }
        System.out.printf("Total Score: %.2f%n", total);
    }
}
