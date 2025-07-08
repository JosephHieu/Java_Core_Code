package Chuong2;

public class Main {

    public static void main(String[] args) {

        System.out.println(power(2, 4));
    }

    static int power(int a, int n) {
        int s = 1;
        for (int i = 0; i < n; i++) {
            s = s * a;
        }
        return s;
    }

    static double BruceForceClosestPair(Point[] points) {

        int n = points.length;
        double d = Double.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double distance = Math.sqrt(Math.pow(points[i].x - points[j].x, 2) + (Math.pow(points[i].y - points[j].y, 2)));
                d = Math.min(d, distance);
            }
        }
        return d;
    }
}

class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
