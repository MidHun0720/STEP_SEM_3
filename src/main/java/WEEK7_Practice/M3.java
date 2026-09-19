package WEEK7_Practice;

class NameTag {
    final String first;
    final String last;

    NameTag(String full) {
        String[] p = full.split(" ");
        first = p[0];
        last = p[1];
    }

    String getNickname() {
        return first + " " + last.charAt(0) + ".";
    }
}

public class M3 {
    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname());
    }
}
