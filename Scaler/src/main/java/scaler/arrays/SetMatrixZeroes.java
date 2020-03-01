package scaler.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kavya k on 29-Feb-2020
 */
public class SetMatrixZeroes {
    public static void main(String[] args){
        List<Integer> array1 = new ArrayList<Integer>(Arrays.asList(1,0,1));
        List<Integer> array2 = new ArrayList<Integer>(Arrays.asList(1,1,1));
        List<Integer> array3 = new ArrayList<Integer>(Arrays.asList(1,1,1));
        List<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
        //array.add(array1);

    }
    public void setZeroes(ArrayList<ArrayList<Integer>> A) {
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
    }
}
