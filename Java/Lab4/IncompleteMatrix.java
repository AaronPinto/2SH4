// public class Matrix {
// 	private int[][] matrixData;    // integer array to store integer data
// 	private int rowsNum;    // number of rows
// 	private int colsNum;    // number of columns
//
// 	public Matrix(int row, int col) //constructor1
// 	{
// 		/* constructs a row-by-col matrix with all elements equal to 0;
// 		if row<=0 then the number of rows of the matrix is set to 3;
// 		likewise, if col<=0 the number of columns of the matrix is set to 3. */
//
//
// 	}//end first constructor
//
//
// 	public Matrix(int[][] table) // constructor2
// 	{
// 		/* constructs a matrix out of the two dimensional array table,
// 		   with the same number of rows, columns, and the same element in each
// 		 position as array table. */
//
// 		rowsNum = table.length;
// 		colsNum = table[0].length;
// 		matrixData = new int[rowsNum][colsNum]; // allocates memory for the 2D array
// 		//loop to fill the array with values:
// 		for (int i = 0; i < rowsNum; i++)
// 			for (int j = 0; j < colsNum; j++)
// 				matrixData[i][j] = table[i][j];
//
// 	}//end second constructor
//
//
// 	public int getElement(int i, int j) throws IndexOutOfBoundsException {
// 		/* if i and j are valid indices of this matrix,
// 		   then the element on row i and column j of this matrix
// 		   is returned; otherwise it throws an exception with message "Invalid indexes".*/
//
// 		if ( /*condition for valid indexes*/) {
// 			/*return the required element*/
// 		} else {
// 			throw new IndexOutOfBoundsException("Invalid indexes.");
// 		}
//
// 	}//end getElement
//
// 	public boolean setElement(int x, int i, int j) {
// 	      	  /* if i and j are valid indexes of this matrix, then the element on  row i and
//                        column j of this matrix is assigned the value  x and true is returned;
//                        otherwise false is returned and no change in the matrix is performed */
// 	}//end setElement
//
// 	public Matrix copy() { /* returns a deep copy of this Matrix */
// 		return new ...;
// 	}//end copy
//
// 	public void addTo(Matrix m) throws ArithmeticException {
// 		/*adds Matrix m to this Matrix; it throws an exception message "Invalid operation"
// 		  if the matrix addition is not defined*/
//
// 		if ( /*condition for addition to be defined*/) {
// 			//add matrices here
//
// 		} else {
// 			throw new ArithmeticException("Invalid operation");
// 		}
//
// 	}
//
// 	public Matrix subMatrix(int i, int j) throws ArithmeticException {
//     /*  returns a new Matrix object, which represents a submatrix of this Matrix,
//     	formed out of rows 0 through i and columns 0 through j;
//     	 the method should first check if values i and j are within the required range,
//     	 and throw an exception if any of them is not. The exception detail message should read: "Submatrix not
//     	 defined".
//     	 Note: The new object should be constructed in such a way that changes in the new matrix do not affect
//     	    this Matrix. */
//
// 	}
//
//
// 	public String toString() {
// 		/* returns a string representing the matrix,
// 		   with each row on a line, and the elements in each row being separated by 2 blank spaces. */
//
// 		String output = new String(); // creates an empty string
// 		for (int i = 0; i < rowsNum; i++) {
// 			for (int j = 0; j < colsNum; j++) {
// 				output += matrixData[i][j] + "  ";
// 			}
// 			output += "\n";
// 		}
// 		return output;
//
// 	}//end toString
//
// 	// write the remaining methods
//
//
// }//end class
