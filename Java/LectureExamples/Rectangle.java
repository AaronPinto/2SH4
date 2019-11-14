package LectureExamples;

public class Rectangle implements Shape {
	private double length, width;

	public Rectangle(double l, double w) {
		this.length = l;
		this.width = w;
	}

	@Override
	public double area() {
		return this.length * this.width;
	}

	@Override
	public String getName() {
		return "Rectangle";
	}
}
