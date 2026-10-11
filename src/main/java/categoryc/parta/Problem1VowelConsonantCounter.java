package categoryc.parta;

import java.util.Scanner;

public class Problem1VowelConsonantCounter {

    public static int[] count(String word) {
        int vowels = 0, consonants = 0;
        for (char ch : word.toCharArray()) {
            if (!Character.isLetter(ch)) {
                continue;
            }
            char lower = Character.toLowerCase(ch);
            if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                vowels++;
            } else {
                consonants++;
            }
        }
        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {

        String sample = "Programming";
        int[] r = count(sample);
        System.out.println("Vowels: " + r[0]);
        System.out.println("Consonants: " + r[1]);

        if (args.length > 0) {
            int[] r2 = count(args[0]);
            System.out.println("Vowels: " + r2[0]);
            System.out.println("Consonants: " + r2[1]);
        } else if (System.console() != null) {
            System.out.print("Enter a word: ");
            try (Scanner sc = new Scanner(System.in)) {
                if (sc.hasNext()) {
                    int[] r3 = count(sc.next());
                    System.out.println("Vowels: " + r3[0]);
                    System.out.println("Consonants: " + r3[1]);
                }
            }
        }
    }
}
