import LectureExamples.CircleExtend;
import LectureExamples.Point;

public class COMPENG2SH4 {
	public static void main(String[] args) {
		CircleExtend c = new CircleExtend(3.5, 65, 7);
		Point p = c;
		Point x = new Point();
		System.out.println(c.toString());
		System.out.println(p.toString());
		System.out.println(x.toString());
	}
}
