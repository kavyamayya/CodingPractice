package scaler.arrays;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * Input: integer array
 * Output: Return the total water it is able to trap after raining.
 * <p>
 * Input 1:
 * A = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output 1:
 * 6
 *
 * @author kavya k on 29-Feb-2020
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] A = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(A));
    }

    public static int trap(final int[] A) {
        //find the the buildings with greater most height than the current building in left and right.If the current building
        //greater height than store 0 in the arrays
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        int maxLeft = 0;
        int maxRight = 0;
        int sumOfWater = 0;
        //for the left most traverse from left
        for (int i = 0; i < A.length; i++) {
            if (maxLeft < A[i]) {
                maxLeft = A[i];
                left[i] = 0;
            } else {
                left[i] = maxLeft;
            }
        }
        //for the right highest traverse from right
        for (int j = A.length - 1; j >= 0; j--) {
            if (maxRight < A[j]) {
                maxRight = A[j];
                right[j] = 0;
            } else {
                right[j] = maxRight;
            }
        }
        //if the minimum of leftmost and rightmost array is greater than the current height of the building then there
        //is a trapping of water.count that.
        for (int k = 0; k < A.length; k++) {
            int min = Math.min(left[k], right[k]);
            if (min > A[k]) {
                sumOfWater += (min - A[k]);
            }
        }
        return sumOfWater;
    }
}
