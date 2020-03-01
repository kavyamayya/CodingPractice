package scaler.arrays;

/**
 * Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.
 * Input:The first and the only argument contains an integer, A.
 * output: Return a 2-d matrix of size A x A satisfying the spiral order.
 * Constraints:
 * 1 <= A <= 1000
 * Examples:
 * Input 1:
 * A = 3
 * <p>
 * Output 1:
 * [   [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]   ]
 * <p>
 * Input 2:
 * 4
 * <p>
 * Output 2:
 * [   [1, 2, 3, 4],
 * [12, 13, 14, 5],
 * [11, 16, 15, 6],
 * [10, 9, 8, 7]   ]
 *
 * @author kavya k on 29-Feb-2020
 */
public class SpiralOrderMatrix {
    public static void main(String[] args) {
        int A = 3;
        generateMatrix(A);
    }

    public static int[][] generateMatrix(int A) {
        int[][] array = new int[A][A];
        int rowStart = 0, columnStart = 0, rowEnd = A - 1, columnEnd = A - 1;
        int count = 0;
        int maxCount = A * A;
        while (maxCount > count) {
            for (int j = columnStart; j <= columnEnd && maxCount > count; j++) {
                array[rowStart][j] = ++count;
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd && maxCount > count; i++) {
                array[i][columnEnd] = ++count;
            }
            columnEnd--;
            for (int i = columnEnd; i >= columnStart && maxCount > count; i--) {
                array[rowEnd][i] = ++count;
            }
            rowEnd--;
            for (int i = rowEnd; i >= rowStart && maxCount > count; i--) {
                array[i][columnStart] = ++count;
            }
            columnStart++;
        }
        return array;
    }
}
