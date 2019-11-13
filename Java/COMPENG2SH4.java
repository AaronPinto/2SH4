import LectureExamples.MySub;
import LectureExamples.MySuper;

public class COMPENG2SH4 {
	public static void main(String[] args) {
		MySub p = new MySub();
		MySuper q = p;

		System.out.println(MySub.staticToString());
		System.out.println(MySuper.staticToString());

		System.out.println(p.instanceToString());
		System.out.println(q.instanceToString());
	}
}
