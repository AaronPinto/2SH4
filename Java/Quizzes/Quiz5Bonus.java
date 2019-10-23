package Quizzes;

import java.util.Arrays;

public class Quiz5Bonus {
	public static void main(String[] args) {
		double[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

		System.out.println("Original Matrix");
		for (double[] d : mat)
			System.out.println(Arrays.toString(d));

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
