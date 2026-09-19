package WEEK7_Practice;

class AttendanceSheet {
    private String[] names;
    private int count;

    AttendanceSheet(int n) {
        names = new String[n];
        count = 0;
    }

    void markPresent(String name) {
        if (isPresent(name)) {
            return;
        }
        if (count < names.length) {
            names[count] = name;
            count = count + 1;
        }
    }

    int getPresentCount() {
        return count;
    }

    boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (names[i].equals(name)) {
                return true;
            }
        }
        return false;
    }
}

public class M5 {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");
        System.out.println(sheet.getPresentCount());
        System.out.println(sheet.isPresent("Ben"));
        System.out.println(sheet.isPresent("Chen"));
    }
}
