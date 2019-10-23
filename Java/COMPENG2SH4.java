import java.util.Arrays;

public class COMPENG2SH4 {
	public static void main(String[] args) {
		int[] c = {1, 2, 3, 4, 5};
		int[] d;
		d = c;
		System.out.println(d == c);
		System.out.println(Arrays.toString(c));
	}
}
