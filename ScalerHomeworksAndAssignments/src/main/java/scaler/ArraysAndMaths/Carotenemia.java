package scaler.ArraysAndMaths;

/**
 * You are given an Array of boxes A, where each box consists of oranges. You really love oranges,
 * and you want to eat atleast B oranges. You start from the 0th index of the array, and keep eating oranges
 * until you eat B oranges. If oranges from a box at ith index get depleted, you start eating from the (i+1)th box.
 * Determine index of the box where you finish eating B number of oranges. If you don't eat B oranges even after
 * eating from all the boxes, return -1.
 * Input:
 * A: Array of integers.
 * B: Integer
 * <p>
 * Output:Integer
 * <p>
 * Constraints
 * 1 <= size(A) <= 10^5
 * 1 <= Integers in A <= 10^4
 * 1 <= B <= 10^9
 * <p>
 * Example:
 * A: [1, 3, 2, 4]
 * B: 5
 * Output: 2
 * <p>
 * You eat 1 orange from box 0.
 * You eat 3 oranges from box 1, hence a total of 4 oranges.
 * You eat 1 orange from box 2, hence a total of 5 oranges, and you stop.
 *
 * @author kavya k on 29-Feb-2020
 */
public class Carotenemia {

    public static void main(String[] args) {
        int[] A = new int[]{1, 3, 2, 4};
        int B = 5;
        System.out.println(solve(A, B));
    }

    public static int solve(int[] A, int B) {
        int sum = 0;
        int index;
        for (index = 0; index < A.length; index++) {
            sum += A[index];
            if (sum >= B) {
                return index;
            }
        }
        return -1;
    }
}