package LectureExamples;

public class CircleExtend extends Point {
    protected double radius;

    public CircleExtend(double radius, int x, int y) {
        super(x, y);
        this.radius = radius;
    }

    public CircleExtend(double radius) {
        this.radius = radius;
    }

    public void setRadius(double r) {
        this.radius = r >= 0 ? r : 0.0;
    }

    public double getRadius() {
        return radius;
    }

    public double area() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public String toString() {
        return "Centre = " + super.toString() + "; Radius = " + this.radius;
    }
}
