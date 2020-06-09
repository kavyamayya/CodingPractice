package com.scaler.arrays;

/**
 * Implement the next permutation, which rearranges numbers into the numerically next greater permutation of
 * numbers for a given array A of size N. If such arrangement is not possible, it must be rearranged as the
 * lowest possible order i.e., sorted in an ascending order.
 * 1. The replacement must be in-place, do **not** allocate extra memory.
 * 2. DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION.
 * Input:
 * The first and the only argument of input has an array of integers, A.
 * Output:
 * Return an array of integers, representing the next permutation of the given array.
 * Constraints:
 * 1 <= N <= 5e5
 * 1 <= A[i] <= 1e9
 * Examples:
 * Input 1: A = [1, 2, 3]
 * Output 1: [1, 3, 2]
 * Input 2: A = [3, 2, 1]
 * Output 2: [1, 2, 3]
 * Input 3: A = [1, 1, 5]
 * Output 3: [1, 5, 1]
 * Input 4: A = [20, 50, 113]
 * Output 4: [20, 113, 50]
 *
 * @author kavya k on 01-Mar-2020
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] array = new int[]{20, 50, 113};
        nextPermutation(array);
    }

    //next permutation will be obtained from the following steps.
    // 1) traverse from the right.Need to exchange the lowest value from the right
    // with the decreasing sequence element. If the lowest value in the right is less than or equal to the decreasing sequence
    //element then go for the second lowest value from the right.if it is greater than the decreasing sequence element
    //exchange both and sort by swapping the remaining elements in the sub array which is after the decreasing sequence element.
    // if there is not decreasing sequence element then sort the whole array by swapping.
    public static int[] nextPermutation(int[] array) {
        int length = array.length;
        int smallest = array[length - 1];
        int index = length - 1;
        int pointer = length - 1;
        for (int i = length - 2; i > 0 && length > 2; i--) {
            if (array[i] < array[pointer]) {
                while (array[i] >= array[index]) {
                    index = index - 1;
                    smallest = array[index];
                }
                array[index] = array[i];
                array[i] = smallest;
                break;
            } else {
                pointer = pointer - 1;
            }
        }
        if (length < 3) {
            pointer = 0;
        }
        swap(array, pointer);
        return array;
    }

    private static void swap(int[] array, int pointer) {
        int start = pointer;
        int end = array.length - 1;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
