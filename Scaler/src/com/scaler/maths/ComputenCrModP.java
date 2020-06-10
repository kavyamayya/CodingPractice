package com.scaler.maths;

/**
 * @author kavya k on 10-Jun-2020
 * Problem Description
 * Given three integers A, B and C, where A represents n, B represents r and C represents p and p is a prime number greater than equal to n, find and return the value of nCr % p where nCr % p = (n! / ((n-r)! * r!)) % p.
 * x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
 * NOTE: For this problem, we are considering 1 as a prime.
 * <p>
 * Problem Constraints
 * 1 <= A <= 10^6
 * 1 <= B <= A
 * A <= C <= 10^9+7
 * <p>
 * Input Format
 * The first argument given is the integer A ( = n).
 * The second argument given is the integer B ( = r).
 * The third argument given is the integer C ( = p).
 * <p>
 * Output Format
 * Return the value of nCr % p.
 * <p>
 * Example Input
 * Input 1:
 * A = 5
 * B = 2
 * C = 13
 * Input 2:
 * A = 6
 * B = 2
 * C = 13
 * <p>
 * Example Output
 * Output 1:
 * 10
 * Output 2:
 * 2
 * <p>
 * Example Explanation
 * Explanation 1:
 * nCr( n=5 and r=2) = 10.
 * p=13. Therefore, nCr%p = 10.
 */
public class ComputenCrModP {
    public int solve(int A, int B, int C) {
        long[] fact = findFactorial(A, C);
        int answer = (int) ((((fact[A] % C) * (findInverse(fact[A - B], C - 2, C) % C) % C) * (findInverse(fact[B], C - 2, C) % C)) % C);
        return answer;
    }

    public long[] findFactorial(int A, int prime) {
        long[] fact = new long[A + 1];
        fact[0] = 1;
        int count = 1;
        while (count <= A) {
            fact[count] = (fact[count - 1] * count) % prime;
            count++;
        }
        return fact;
    }

    public int findInverse(long val, int prime, int P) {
        long ans = 1;
        int count = prime;
        while (count > 0) {
            if (count % 2 == 1) {
                ans = (ans * val) % P;
            }
            val = (val * val) % P;
            count = count >> 1;
        }
        return (int) ans;
    }
}
