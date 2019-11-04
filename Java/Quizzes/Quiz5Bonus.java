package Quizzes;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz5Bonus {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n, m;

		System.out.print("PLease input n: ");
		n = Integer.parseInt(s.nextLine());

		System.out.print("PLease input m: ");
		m = Integer.parseInt(s.nextLine());

		double[][] mat = new double[n][m];

		for (int i = 0; i < n; i++) {
			System.out.print("Please input a space-separated row: ");
			mat[i] = Arrays.stream(s.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
		}

		s.close();

		for (int i = 0; i < mat.length; i++)
			for (int j = 0; j < i; j++) {
				double temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}

		System.out.println("\nTransposed Matrix");
		for (double[] d : mat)
			System.out.println(Arrays.toString(d));
	}
}
