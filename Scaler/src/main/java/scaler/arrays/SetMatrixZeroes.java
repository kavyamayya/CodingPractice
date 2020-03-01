package scaler.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.
 * Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.
 * Input:
 * The first and the only argument of input contains a 2-d integer matrix, A, of size M x N.
 * Output:
 * Return a 2-d matrix that satisfies the given conditions.
 * Constraints:
 * 1 <= N, M <= 1000
 * 0 <= A[i][j] <= 1
 * <p>
 * Examples:
 * Input 1:
 * [   [1, 0, 1],
 * [1, 1, 1],
 * [1, 1, 1]   ]
 * <p>
 * Output 1:
 * [   [0, 0, 0],
 * [1, 0, 1],
 * [1, 0, 1]   ]
 *
 * @author kavya k on 29-Feb-2020
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        ArrayList<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1, 0, 1));
        ArrayList<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1, 1, 1));
        ArrayList<Integer> array3 = new ArrayList<Integer>(Arrays.asList(1, 1, 1));
        ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
        array.add(array1);
        array.add(array2);
        array.add(array3);
        setZeroes(array);
    }

    public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int m = a.size();
        int n = a.get(0).size();
        boolean firstRow = false;
        boolean firstColumn = false;
        //set the first row or column to zero if the element 0 is occurred.if the row or column of the zero element is
        //first set firstRow or firstColumn flag
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a.get(i).get(j) == 0) {
                    if (j != 0) {
                        a.get(0).set(j, 0);
                    } else {
                        firstColumn = true;
                    }
                    if (i != 0) {
                        a.get(i).set(0, 0);
                    } else {
                        firstRow = true;
                    }
                }
            }
        }
        //iterate over the first row or column and set -1 for the entire row or column to avoid the repeated iteration
        //over the same row column if we set it 0 before only.
        for (int j = 0; j < n; j++) {
            if (a.get(0).get(j) == 0) {
                for (int i = 1; i < m; i++) {
                    if (a.get(i).get(j) != 0) {
                        a.get(i).set(j, -1);
                    }
                }
            }
        }
        for (int j = 0; j < m; j++) {
            if (a.get(j).get(0) == 0) {
                for (int i = 1; i < n; i++) {
                    if (a.get(j).get(i) != 0) {
                        a.get(j).set(i, -1);
                    }
                }
            }
        }
        //set 0 in the place of -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a.get(i).get(j) == -1) {
                    a.get(i).set(j, 0);
                }
            }
        }
        //now check firstRow or firstColumn flag
        if (firstRow) {
            for (int i = 0; i < n; i++) {
                a.get(0).set(i, 0);
            }
        }
        if (firstColumn) {
            for (int i = 0; i < m; i++) {
                a.get(i).set(0, 0);
            }
        }
    }

    //another method
   /* public void setZeroes(ArrayList<ArrayList<Integer>> A) {
        int m, n;

        if (A == null)
            return;

        m = A.size();
        n = A.get(0).size();

        if (n == 0)
            return;

        for (int i = 0; i < m; i++) {
            boolean zero = false;
            for (int j = 0; j < n; j++) {
                if (A.get(i).get(j) == 0)
                    zero = true;
            }

            if (zero)
                clearRow(A, i, m, n, 2);

        }

        for (int i = 0; i < n; i++) {
            boolean zero = false;
            for (int j = 0; j < m; j++) {
                if (A.get(j).get(i) == 0)
                    zero = true;
            }

            if (zero)
                clearCol(A, i, m, n, 2);

        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A.get(i).get(j) == 2)
                    A.get(i).set(j, 0);
            }
        }

    }


    public void clearRow(ArrayList<ArrayList<Integer>> A, int row, int m, int n, int value) {

        for (int i = 0; i < n; i++) {
            if (A.get(row).get(i) == 1)
                A.get(row).set(i, value);
        }
    }

    public void clearCol(ArrayList<ArrayList<Integer>> A, int col, int m, int n, int value) {
        for (int i = 0; i < m; i++) {
            if (A.get(i).get(col) == 1)
                A.get(i).set(col, value);
        }
    }*/
}