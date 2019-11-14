import LectureExamples.NewCircle;
import LectureExamples.Rectangle;
import LectureExamples.Shape;

import java.util.Arrays;

public class COMPENG2SH4 {
	public static void main(String[] args) {
		Shape[] array = new Shape[]{new Rectangle(2.5, 3.0), new NewCircle(2, 2, 4.0)};

		System.out.println(Arrays.stream(array).mapToDouble(Shape::area).sum());
	}
}
