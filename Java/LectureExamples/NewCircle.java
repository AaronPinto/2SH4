package LectureExamples;

public class NewCircle extends Point implements Shape {
	private double radius;

	public NewCircle(int x, int y, double r) {
		super(x, y);
		this.radius = r > 0.0 ? r : -r;
	}

	@Override
	public double area() {
		return Math.PI * this.radius * this.radius;
	}

	@Override
	public String getName() {
		return "NewCircle";
	}
}
