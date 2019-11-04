package Lab4;

import java.util.Arrays;

public class UpperTriangularMatrix {
	private int n;
	private int[] effMat;

	public UpperTriangularMatrix(int n) {
		this.n = n <= 0 ? 1 : n;
		this.effMat = new int[this.n * (this.n + 1) / 2];
	}

	public UpperTriangularMatrix(Matrix upTriM) throws IllegalArgumentException {
		if (!upTriM.isUpperTr())
			throw new IllegalArgumentException("Input matrix is not upper triangular");
		else if (!upTriM.isSquare())
			throw new IllegalArgumentException("Input matrix is not square");

		this.n = upTriM.getRows();
		this.effMat = new int[this.n * (this.n + 1) / 2];

		int count = 0;
		for (int i = 0; i < this.n; i++)
			for (int j = i; j < this.n; j++)
				this.effMat[count++] = upTriM.getElement(i, j);
	}

	/*
	Example upper triangular matrix
	1 3 5
	0 7 6
	0 0 9

	n = 3
    Total number of elements in 1d array = n(n + 1) / 2 = M = 6

	There is always 1 element in the last row (index n - 1), 2 elements in row n - 2, 3 elements in row n - 3 and
	so on. Therefore, in the last k rows, there are k(k + 1) / 2 elements, and therefore the last k rows take up
	the last k(k + 1) / 2 elements in the 1D array.

	1D representation for the example matrix
	1 3 5 7 6 9

	Given an index i, let's say = 3, there are M - 1 - i (2) elements at positions greater than i. Let's call the
	number of elements at positions greater than i, x. We now want to find the largest integer k such that k(k + 1)
	/ 2	<= x, because then with that value of k, we can get the row and column index of the element at index i in
	the 1D array, in the 2D array.

	k(k + 1) / 2 <= x
	k(k + 1) <= 2x
	(k + 1/2)^2 - 1/4 <= 2x
	(k + 1/2)^2 <= 2x + 1/4
	(k + 1/2)^2 <= 8x + 1
	k + 1/2 <= sqrt(8x + 1)
	k <= sqrt(8x + 1) - 1/2
	k <= 2sqrt(8x + 1) / 2 - 1/2
	k <= (sqrt(8x + 1) - 1) / 2 (integer division rounds down which is what we want)

	Lets call the largest value of k where the equation above is satisfied, K. Then we know that there are K rows
	out of a total n rows that come after the row index of the element in the matrix. Therefore we can get the
	row index as n - 1 - K. For the column index, we know that there are K(K + 1) / 2 elements out of x elements
	(remember that x represents the number of elements at positions greater than i in the 1D array, and therefore
	the number of non-zero elements in the matrix after that same element) that are after this row, so there are
	x - K(K + 1) / 2 elements in this row. This row has K + 1 elements in it, therefore n - 1 - (x - K(K + 1) / 2)
	will give us the column index of the element.

	To go from row and col index to 1D index, I'm not entirely sure how to derive it but I found 2 equations online.
	n(n + 1) / 2 - ((n - i)(n - i + 1) / 2) + j - i and i * n - i^2 / 2 + i / 2 + j - i. These are equivalent
	and	you can prove it by expanding and simplifying the left equation.
	 */

	private int getLargestK(int i) {
		int x = this.effMat.length - 1 - i;
		return (int) ((Math.sqrt(8 * x + 1) - 1) / 2);
	}

	private int get2DRowIndex(int i) {
		return this.n - 1 - this.getLargestK(i);
	}

	private int get2DColIndex(int i) {
		int x = this.effMat.length - 1 - i;
		int K = this.getLargestK(i);
		return this.n - 1 - (x - K * (K + 1) / 2);
	}

	private int get1DIndex(int i, int j) {
		return i * this.n - i * i / 2 + i / 2 + j - i;
	}

	public int getDim() {
		return this.n;
	}

	public int getElement(int i, int j) throws IndexOutOfBoundsException {
		if ((i < 0 || i >= this.n) || (j < 0 || j >= this.n))
			throw new IndexOutOfBoundsException("Invalid indexes");

		return j < i ? 0 : this.effMat[this.get1DIndex(i, j)];
	}

	public void setElement(int x, int i, int j) throws IndexOutOfBoundsException, IllegalArgumentException {
		if ((i < 0 || i >= this.n) || (j < 0 || j >= this.n))
			throw new IndexOutOfBoundsException("Invalid indexes");
		if (j < i) {
			if (x != 0)
				throw new IllegalArgumentException("Incorrect Argument");
			return;
		}

		this.effMat[this.get1DIndex(i, j)] = x;
	}

	public Matrix fullMatrix() {
		int[][] temp = new int[this.n][this.n];

		for (int i = 0; i < this.n; i++)
			for (int j = 0; j < this.n; j++)
				temp[i][j] = this.getElement(i, j);

		return new Matrix(temp);
	}

	public void print1DArray() {
		for (int value : this.effMat)
			System.out.print(value + "  ");
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();

		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.n; j++)
				s.append(this.getElement(i, j)).append("  ");

			s.append("\n");
		}

		return s.toString();
	}

	public int getDet() {
		int det = 1;

		for (int i = 0; i < this.n; i++)
			det *= this.getElement(i, i);

		return det;
	}

	// Use back substitution to solve, as its the fastest way to do so
	public double[] effSolve(double[] b) throws IllegalArgumentException {
		if (b.length != this.n)
			throw new IllegalArgumentException("The length of b is not the same as the number of rows of A");

		int detA = 1;

		for (int i = 0; i < this.n; i++)
			detA *= this.effMat[i * this.n - i * i / 2 + i / 2];

		if (detA == 0)
			throw new IllegalArgumentException("The determinant of A is 0");

		double[] x = new double[b.length];
		x[x.length - 1] = b[b.length - 1] / this.effMat[this.effMat.length - 1];

		double t;
		int k;
		for (int j = this.n - 2; j >= 0; j--) {
			t = 0.0;

			for (k = this.n - 1; k > j; k--)
				t += this.effMat[j * this.n - j * j / 2 + j / 2 + k - j] * x[k];

			x[j] = (b[j] - t) / this.effMat[j * this.n - j * j / 2 + j / 2];
		}

		return x;
	}

	public static void main(String[] args) {
		int[][] test = new int[][]{{1, 2, 3, 4}, {0, 5, 6, 7}, {0, 0, 8, 9}, {0, 0, 0, 10}};
		UpperTriangularMatrix u = new UpperTriangularMatrix(new Matrix(test));
		System.out.println(Arrays.toString(u.effSolve(new double[]{3.0, 2.5, 7.0, 1.5})));
	}
}
