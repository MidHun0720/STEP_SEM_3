package WEEK7_Assessment;

class TrafficLight {
    private String color;
    final String id;

    TrafficLight(String id) {
        this.id = id;
        color = "RED";
    }

    void next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else {
            color = "RED";
        }
    }

    String getColor() {
        return color;
    }
}

public class M4 {
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println(t.getColor());
        t.next();
        System.out.println(t.getColor());
        t.next();
        System.out.println(t.getColor());
        t.next();
        System.out.println(t.getColor());
    }
}
