package com.scaler.maths;

/**
 * @author kavya k on 10-Jun-2020
 * Problem Description
 * You are given A lines and B circles. Find the maximum number of intersection points that these A lines and B circles can have with each other.
 *
 * Problem Constraints
 * 0 <= A,B <= 10000
 *
 * Input Format
 * First argument is an integer A denoting the number of lines.
 * Second argument is an integer B denoting the number of circles.
 *
 * Output Format
 * Return an integer denoting the maximum number of intersection points.
 *
 * Example Input
 * Input 1:
 * A = 2
 * B = 2
 *
 * Example Output
 * output 1:
 * 11
 *
 * Example Explanation
 * Explanaton 1:
 * Two circles can intersect at 2 points.
 * Two lines can intersect at only 1 point.
 * Two lines and two circles can intersect at 8 points.
 * So, total maximum number of intersection points are 11.
 */
public class MaximumIntersectionPoints {
    public int getIntersection(int A, int B) {
        if(A == 1 && B==1){
            return 2;
        }
        int li= A*(A-1)/2;
        // System.out.println(li);
        int ci=B*(B-1)/2*2;
        // System.out.println(ci);
        int cli = 2*B*A;
        // System.out.println(cli);
        return ci+li+cli;
    }
}
