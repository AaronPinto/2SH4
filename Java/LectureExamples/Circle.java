package LectureExamples;

public class Circle {
    private double radius;
    private Point centre;

    public Circle(double radius, int x, int y) {
        this.radius = radius;
        this.centre = new Point(x, y);
    }

    public Circle(double radius) {
        this.radius = radius;
        this.centre = new Point(0, 0);
    }

    public double getRadius() {
        return radius;
    }

    public int getX() {
        return this.centre.getX();
    }

    public int getY() {
        return this.centre.getY();
    }

    public Point getCentre() {
        return new Point(this.getX(), this.getY());
    }

    public boolean isTangTo(Circle c) {
        double distBetweenCentres = Math.pow(this.getX() - c.getX(), 2) + Math.pow(this.getY() - c.getY(), 2);
        return distBetweenCentres == Math.pow(this.radius - c.getRadius(), 2) ||
            distBetweenCentres == Math.pow(this.radius + c.getRadius(), 2);
    }
}
