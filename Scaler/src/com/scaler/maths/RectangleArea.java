package com.scaler.maths;

/**
 * @author kavya k on 10-Jun-2020
 * Problem Description
 * Given eight integers A, B, C, D, E, F, G and H which represent two rectangles in a 2D plane.
 * For the first rectangle it's bottom left corner is (A, B) and top right corner is (C, D) and for the second rectangle
 * it's bottom left corner is (E, F) and top right corner is (G, H).
 * Find and return the overlapping area of the two rectangles.
 * <p>
 * Problem Constraints
 * -104 <= A <= C <= 10^4
 * -104 <= B <= D <= 10^4
 * -104 <= E <= G <= 10^4
 * -104 <= F <= H <= 10^4
 * <p>
 * Input Format
 * The eight arguments given are the integers A, B, C, D, E, F, G and H.
 * <p>
 * Output Format
 * Return the overlapping area of the two rectangles.
 * <p>
 * Example Input
 * Input 1:
 * A = 0   B = 0
 * C = 4   D = 4
 * E = 2   F = 2
 * G = 6   H = 6
 * Input 2:
 * A = 0   B = 0
 * C = 4   D = 4
 * E = 2   F = 2
 * G = 3   H = 3
 * <p>
 * Example Output
 * Output 1:
 * 4
 * Output 2:
 * 1
 */
public class RectangleArea {
    public int solve(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (C <= E || G <= A || H <= B || D <= F) {
            return 0;
        }
        int x = Math.min(G, C) - Math.max(A, E);
        int y = Math.min(D, H) - Math.max(B, F);
        return x * y;
    }
}
