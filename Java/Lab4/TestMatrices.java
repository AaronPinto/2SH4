package Lab4;

import java.util.Arrays;

/**
 * @author sorina (a previous prof for this class) - aaron
 */
public class TestMatrices {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //============================================================
        // Matrix
        //============================================================
        //------------------------------------------------------------
        // constructor
        //------------------------------------------------------------
        // test constructor1; invalid inputs
        Matrix a = new Matrix(-1, 2);
        System.out.println("Test constructor1--invalid inputs: (-1,2)");
        System.out.println(a.toString());
        System.out.println();

        // test constructor1; invalid inputs
        Matrix b = new Matrix(1, 0);
        System.out.println("Test constructor1--invalid inputs: (1,0)");
        System.out.println(b.toString());
        System.out.println();

        // test constructor1; valid inputs
        Matrix d = new Matrix(3, 4);
        System.out.println("Test constructor1--valid inputs: (3,4)");
        System.out.println(d.toString());
        System.out.println();

        //test constructor2;
        int[][] temp = {{1, 1, 1, 1, 1}, {2, 2, 2, 8, 2}, {0, 0, 1, 7, 1}, {0, 0, 0, 1, 1}};
        Matrix f = new Matrix(temp);
        System.out.println("Test constructor2-- 4-by-5 array");
        System.out.println(f.toString());
        System.out.println();

        //------------------------------------------------------------
        //test getElement(); Indices begin with 0
        //------------------------------------------------------------
        try {
            System.out.println("Test getElement(1,3), Note that Indices begin with 0");
            System.out.println(f.getElement(1, 3));

            System.out.println("Test getElement(10,2), invalid indexes");
            System.out.println(f.getElement(10, 2));    // invalid indexes
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
        System.out.println();

        //------------------------------------------------------------
        // YTW: test Matrix.setElement()
        //------------------------------------------------------------
        try {
            System.out.println("Test setElement(-99,1,3), Note that Indices begin with 0");
            System.out.println(f.setElement(-99, 1, 3));
            System.out.println("Test getElement(1,3), Note that Indices begin with 0");
            System.out.println(f.getElement(1, 3));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
        System.out.println();

        //------------------------------------------------------------
        //test subMatrix()
        //------------------------------------------------------------
        try {
            System.out.println("Test subMatrix(), valid inputs: (2,3)");
            Matrix y = f.subMatrix(2, 3);
            System.out.println(y.toString());
            System.out.println();

            System.out.println("Test subMatrix(), invalid inputs: (3,6)");
            System.out.println(f.subMatrix(3, 6));
        } catch (ArithmeticException e) {
            System.out.println(e);
            System.out.println();
        }

        //------------------------------------------------------------
        //test isUpperTr()
        //------------------------------------------------------------
        System.out.println("Test isUpperTr(), return true");
        int[][] temp1 = {{1, 2, 3, 4}, {0, 5, 6, 7}, {0, 0, 8, 0}};
        Matrix v = new Matrix(temp1);
        System.out.println(v.toString());
        System.out.println(v.isUpperTr());
        System.out.println();

        System.out.println("Test isUpperTr(), return false");
        int[][] temp2 = {{2, 0, 0, 0}, {0, 9, 6, 8}, {5, 0, 4, 4}, {0, 0, 0, 9}};
        Matrix n = new Matrix(temp2);
        System.out.println(n.toString());
        System.out.println(n.isUpperTr());
        System.out.println();

        int[][] temp3 = {{2, 0, 0, 0, 4}, {0, 2, 1, 1, 4}, {0, 0, 2, 1, 4}, {0, 0, 0, 2, 6}};
        Matrix p = new Matrix(temp3);
        System.out.println(p.toString());


        //------------------------------------------------------------
        // test addTo()
        //------------------------------------------------------------
        System.out.println("Test addTo() -- invalid operation");
        int[][] temp4 = {{3, 4, 5}, {1, 2, 3}, {0, 0, 0}, {1, 2, 1}};
        Matrix m = new Matrix(temp4);
        try {
            m.addTo(p);
            System.out.println(m);
        } catch (ArithmeticException e) {
            System.out.println(e);
            System.out.println();
        }

        System.out.println("Test addTo() -- valid operation");
        int[][] temp5 = {{0, 0, 0}, {1, 2, 3}, {0, 0, 0}, {1, 2, 1}};
        Matrix m1 = new Matrix(temp5);
        try {
            m.addTo(m1);
            System.out.println(m);
        } catch (ArithmeticException e) {
            System.out.println(e);
            System.out.println();
        }

        //------------------------------------------------------------
        // test sum()
        //------------------------------------------------------------
        System.out.println("Test sum() -- invalid operation");
        Matrix[] arr = new Matrix[4];
        for (int i = 0; i < 4; i++)
            arr[i] = new Matrix(2, 3);
        arr[2] = new Matrix(3, 3);
        try {
            System.out.println(Matrix.sum(arr).toString());
        } catch (ArithmeticException e) {
            System.out.println(e);
            System.out.println();
        }

        System.out.println("Test sum() -- valid operation");
        Matrix[] arr2 = new Matrix[3];
        int[][] temp10 = {{1, -1, 2}, {1, 0, -2}};
        int[][] temp11 = {{1, 0, 1}, {0, 1, 2}};
        arr2[0] = new Matrix(temp10);
        arr2[1] = new Matrix(temp10);
        arr2[2] = new Matrix(temp11);
        try {
            System.out.println(Matrix.sum(arr2).toString());
        } catch (ArithmeticException e) {
            System.out.println(e);
            System.out.println();
        }

        //============================================================
        //test class UpperTriangularMatrix
        //============================================================
        //------------------------------------------------------------
        // constructor
        //------------------------------------------------------------
        // test constructor1; invalid input
        UpperTriangularMatrix m11 = new UpperTriangularMatrix(-3);  // m1
        System.out.println("Test costructor1--invalid input");
        System.out.println(m11.toString());

        // test constructor1; valid input
        UpperTriangularMatrix m2 = new UpperTriangularMatrix(4);
        System.out.println("Test costructor1--valid input");
        System.out.println(m2.toString());
        m2.print1DArray();
        System.out.println();

        //test constructor2 - valid input;
        UpperTriangularMatrix m3 = null, m4;
        int[][] temp12 = {{1, 1, 1, 1, 1}, {0, 2, 2, 2, 2}, {0, 0, 3, 3, 3}, {0, 0, 0, 4, 4}, {0, 0, 0, 0, 5}};
        Matrix mm1 = new Matrix(temp12);
        try {
            m3 = new UpperTriangularMatrix(mm1);
            System.out.println("\nTest costructor2");
            System.out.println(m3.toString());
            m3.print1DArray();

            //test constructor2 - invalid input;
            int[][] temp13 = {{9, 0, 0}, {8, 7, 0,}, {6, 5, 4}};
            mm1 = new Matrix(temp13);
            System.out.println("\nTest costructor2");

            m4 = new UpperTriangularMatrix(mm1); // temp13
            System.out.println(m4.toString());
            m4.print1DArray();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println();
        }// end try-catch

        int[][] temp15 = {{1, 2, 3, 4, 5, 6}, {0, 7, 8, 9, 9, 9}, {0, 0, 3, 3, 3, 3}, {0, 0, 0, 4, 4, 4}, {0, 0, 0, 0,5, 5}, {0, 0, 0, 0, 0, 7}};
        mm1 = new Matrix(temp15);
        m4 = new UpperTriangularMatrix(mm1);

        //------------------------------------------------------------
        //test getDim()
        //------------------------------------------------------------
        System.out.println("\n\nTest getDim()");
        System.out.println(m3.getDim());
        System.out.println(m4.getDim());
        System.out.println();

        //------------------------------------------------------------
        //test getElement()
        //------------------------------------------------------------
        try {
            System.out.println("Test getElement() - valid positions");
            for (int i = 0; i < m3.getDim(); i++) {
                for (int j = 0; j < m3.getDim(); j++)
                    System.out.print(m3.getElement(i, j) + "  ");
                System.out.println();
            }// end for i
            System.out.println();

            System.out.println("Test getElement() - invalid position ");
            System.out.println(m3.getElement(6, 4));    // invalid indexes
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
        System.out.println();

        //------------------------------------------------------------
        //test setElement()
        //------------------------------------------------------------
        try {
            System.out.println("Test setElement() - valid positions");
            m3.setElement(7, 1, 3);
            System.out.print(m3);
            System.out.println();
            m4.setElement(9, 4, 4);
            System.out.print(m4);

            System.out.println("Test setElement() - invalid position ");
            m3.setElement(-1, 4, 7);
            System.out.print(m3);    // invalid indexes

        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Pay attention! This is an upper triangular matrix!");
        }
        System.out.println();

        try {
            System.out.println("Test setElement() - attempt to put a non-zero value in the lower part ");
            m3.setElement(-2, 3, 0);
            System.out.print(m3);    // invalid argument
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Pay attention! This is an upper triangular matrix!");
        }
        System.out.println();

        //------------------------------------------------------------
        //test fullMatrix()
        //------------------------------------------------------------
        System.out.println("Test fullMatrix()");
        mm1 = new Matrix(temp12);
        m3 = new UpperTriangularMatrix(mm1);
        System.out.print(m3.fullMatrix().toString());
        System.out.println();

        int[][] temp14 = {{9, 9, 9}, {0, 8, 8}, {0, 0, 7}};
        mm1 = new Matrix(temp14);
        m4 = new UpperTriangularMatrix(mm1);
        System.out.print(m4.fullMatrix().toString());
        System.out.println();

        //------------------------------------------------------------
        // test getDet()
        //------------------------------------------------------------
        System.out.println("Test m4.getDet() -- valid operation");
        try {
            System.out.println(m4.getDet() + "\n");
        } catch (ArithmeticException e) {
            System.out.println(e);
            System.out.println();
        }

        //------------------------------------------------------------
        // test effSolve()
        //------------------------------------------------------------
        System.out.println("Test effSolve() -- invalid operation");
        double[] bb1 = {2, 3, 4, 5};
        try {
            System.out.println(Arrays.toString(m4.effSolve(bb1)) + "\n");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println();
        }

        System.out.println("Test effSolve() -- valid operation");
        double[] bb2 = {2, 3, 4};
        try {
            System.out.println(Arrays.toString(m4.effSolve(bb2)) + "\n");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println();
        }

        System.out.println("Test effSolve() -- invalid operation");
        m4.setElement(0, 0, 0);
        try {
            System.out.println(Arrays.toString(m4.effSolve(bb2)) + "\n");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println();
        }
    } //end main
}
