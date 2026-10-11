package categoryc.parta;

import java.util.Scanner;

public class Problem2WordReverserPalindrome {

    public static String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }

    public static boolean isPalindrome(String word) {
        return word.equals(reverse(word));
    }

    public static void check(String word) {
        String rev = reverse(word);
        if (isPalindrome(word)) {
            System.out.println(rev + " - palindrome");
        } else {
            System.out.println(rev + " - not a palindrome");
        }
    }

    public static void main(String[] args) {
        check("level");
        check("java");
        if (args.length > 0) {
            for (String a : args) {
                check(a);
            }
        } else if (System.console() != null) {
            System.out.print("Enter a word: ");
            try (Scanner sc = new Scanner(System.in)) {
                if (sc.hasNext()) {
                    check(sc.next());
                }
            }
        }
    }
}
