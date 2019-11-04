// Lecture
class Point {
	private int x, y;
	private static int count = 0;

	Point(int x, int y) {
		set(x, y);
		Point.count++;
	}

	void set(int x, int y) {
		this.x = x;
		this.y = y;
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}

	static int getCount() {
		return count;
	}

	void scale(int scalingFactor) {
		this.x *= scalingFactor;
		this.y *= scalingFactor;
	}

	double distanceTo(Point p) {
		return Math.hypot(p.x - this.x, p.y - this.y);
	}
}
