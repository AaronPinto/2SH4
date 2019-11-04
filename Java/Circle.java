public class Circle {
	private double radius;
	private Point centre;

	Circle(double radius, int x, int y) {
		this.radius = radius;
		this.centre = new Point(x, y);
	}

	Circle(double radius) {
		this.radius = radius;
		this.centre = new Point(0, 0);
	}

	double getRadius() {
		return radius;
	}

	int getX() {
		return this.centre.getX();
	}

	int getY() {
		return this.centre.getY();
	}

	Point getCentre() {
		return new Point(this.getX(), this.getY());
	}

	boolean isTangTo(Circle c) {
		double distBetweenCentres = Math.pow(this.getX() - c.getX(), 2) + Math.pow(this.getY() - c.getY(), 2);
		return distBetweenCentres == Math.pow(this.radius - c.getRadius(), 2) ||
			distBetweenCentres == Math.pow(this.radius + c.getRadius(), 2);
	}

	public static void main(String[] args) {

	}
}
