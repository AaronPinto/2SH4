package Lab4;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Matrix {
	private int rows, cols;
	private int[][] matrix;

	public Matrix(int rows, int cols) {
		this.rows = rows <= 0 ? 3 : rows;
		this.cols = cols <= 0 ? 3 : cols;
		this.matrix = new int[this.rows][this.cols];
	}

	public Matrix(int[][] matrix) {
		this.rows = matrix.length;
		this.cols = matrix[0].length;
		this.matrix = new int[this.rows][this.cols];

		//Perform deep copy
		for (int i = 0; i < rows; i++)
			System.arraycopy(matrix[i], 0, this.matrix[i], 0, cols);
	}

	public int getRows() {
		return rows;
	}

	public int getElement(int i, int j) throws IndexOutOfBoundsException {
		if ((i < 0 || i >= this.rows) || (j < 0 || j >= this.cols))
			throw new IndexOutOfBoundsException("Invalid indexes");

		return this.matrix[i][j];
	}

	public boolean setElement(int x, int i, int j) {
		if ((i < 0 || i >= this.rows) || (j < 0 || j >= this.cols))
			return false;

		this.matrix[i][j] = x;
		return true;
	}

	public Matrix copy() {
		return new Matrix(this.matrix);
	}

	public void addTo(Matrix m) throws ArithmeticException {
		if (this.rows != m.rows || this.cols != m.cols)
			throw new ArithmeticException("Invalid operation");

		for (int i = 0; i < this.rows; i++)
			for (int j = 0; j < this.cols; j++)
				this.matrix[i][j] += m.getElement(i, j);
	}

	public Matrix subMatrix(int i, int j) throws ArithmeticException {
		if ((i < 0 || i >= this.rows) || (j < 0 || j >= this.cols))
			throw new ArithmeticException("Submatrix not defined");

		// For range from 0 to i, copy the kth int[] in this.matrix from 0 to j, assemble all copies into new int[][]
		return new Matrix(IntStream.range(0, i).mapToObj(k -> Arrays.copyOf(this.matrix[k], j)).toArray(int[][]::new));
	}

	public boolean isUpperTr() {
		for (int i = 1; i < this.rows; i++)
			for (int j = 0; j < i && j < this.cols; j++)
				if (this.matrix[i][j] != 0)
					return false;

		return true;
	}

	public boolean isSquare() {
		return this.rows == this.cols;
	}

	public static Matrix sum(Matrix[] matArray) throws ArithmeticException {
		Matrix s = new Matrix(matArray[0].rows, matArray[0].cols);

		for (Matrix m : matArray)
			s.addTo(m);

		return s;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();

		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.cols; j++)
				s.append(this.matrix[i][j]).append("  ");

			s.append("\n");
		}

		return s.toString();
	}
}
