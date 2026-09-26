package week_8_practice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LibraryDueDateCalculator {
    static abstract class LibraryItem {
        String title;
        LibraryItem(String title) {
            this.title = title;
        }
        String getTitle() {
            return title;
        }
        abstract int getLoanDays();
        LocalDate getDueDate(LocalDate current) {
            return current.plusDays(getLoanDays());
        }
    }
    static class Book extends LibraryItem {
        Book(String title) {
            super(title);
        }
        int getLoanDays() {
            return 14;
        }
    }
    static class Dvd extends LibraryItem {
        Dvd(String title) {
            super(title);
        }
        int getLoanDays() {
            return 7;
        }
    }
    static class Magazine extends LibraryItem {
        Magazine(String title) {
            super(title);
        }
        int getLoanDays() {
            return 3;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<LibraryItem> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("\"([^\"]*)\"");
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            while (line.trim().isEmpty()) {
                line = sc.nextLine();
            }
            String type = line.trim().split("\\s+")[0];
            Matcher m = pattern.matcher(line);
            String title = "";
            if (m.find()) {
                title = m.group(1);
            }
            if (type.equals("BOOK")) {
                list.add(new Book(title));
            } else if (type.equals("DVD")) {
                list.add(new Dvd(title));
            } else {
                list.add(new Magazine(title));
            }
        }
        sc.close();
        LocalDate current = LocalDate.of(2023, 10, 26);
        for (LibraryItem item : list) {
            System.out.println(item.getTitle() + ": " + item.getDueDate(current));
        }
    }
}
