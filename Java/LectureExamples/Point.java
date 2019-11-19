package LectureExamples;

public class Point {
    protected int x, y;
    private static int count = 0;

    public Point() {
        setPoint(0, 0);
        Point.count++;
    }

    public Point(int x, int y) {
        setPoint(x, y);
        Point.count++;
    }

    public void setPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static int getCount() {
        return count;
    }

    public void scale(int scalingFactor) {
        this.x *= scalingFactor;
        this.y *= scalingFactor;
    }

    public double distanceTo(Point p) {
        return Math.hypot(p.x - this.x, p.y - this.y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
