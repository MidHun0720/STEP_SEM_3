package week_9_practice;

import java.util.Scanner;

public class GardenPlot {
    static abstract class Plot {
        String owner;
        String shape;
        Plot(String owner, String shape) {
            this.owner = owner;
            this.shape = shape;
        }
        abstract double getArea();
    }
    static class CirclePlot extends Plot {
        double radius;
        CirclePlot(String owner, double radius) {
            super(owner, "CIRCLE");
            this.radius = radius;
        }
        public double getArea() {
            return Math.PI * radius * radius;
        }
    }
    static class RectanglePlot extends Plot {
        double length;
        double width;
        RectanglePlot(String owner, double length, double width) {
            super(owner, "RECTANGLE");
            this.length = length;
            this.width = width;
        }
        public double getArea() {
            return length * width;
        }
    }
    static class TrianglePlot extends Plot {
        double base;
        double height;
        TrianglePlot(String owner, double base, double height) {
            super(owner, "TRIANGLE");
            this.base = base;
            this.height = height;
        }
        public double getArea() {
            return 0.5 * base * height;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();
            Plot p = null;
            if (shape.equals("CIRCLE")) {
                double r = sc.nextDouble();
                p = new CirclePlot(owner, r);
            } else if (shape.equals("RECTANGLE")) {
                double l = sc.nextDouble();
                double w = sc.nextDouble();
                p = new RectanglePlot(owner, l, w);
            } else if (shape.equals("TRIANGLE")) {
                double b = sc.nextDouble();
                double h = sc.nextDouble();
                p = new TrianglePlot(owner, b, h);
            }
            double area = p.getArea();
            total = total + area;
            System.out.printf("%s (%s): %.2f%n", p.owner, p.shape, area);
        }
        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}
