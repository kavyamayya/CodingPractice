package com.interviewbit;

import java.util.Arrays;

/**
 * @author kavya k on 28-Feb-2020
 */
public class MaximumConsecutiveGap {
    public static void main(String[] args) {
        int[] A = new int[]{1,1,2};
        System.out.println(maximumGap(A));
    }

    public static int maximumGap(final int[] A) {
        if (A.length < 2) {
            return 0;
        }
        int min = A[0];
        int max = A[0];
        int n = A.length;
        for (int value : A) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        }
        System.out.println("max :" + max + " min :" + min);
        int bucketSize = (max - min) / (n - 1);
        System.out.println(" bucket size " + bucketSize);
        if (bucketSize == 0) {
            return max - min;
        }
        int numOfBuckets = (int) Math.ceil((float) max / (float) bucketSize);
        System.out.println(" numOfBuckets " + numOfBuckets);
        int[] maxBucket = new int[numOfBuckets];
        int[] minBucket = new int[numOfBuckets];
        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        //iterating over elements and finding its bucket
        for (int value : A) {
            int bucket = (int) Math.ceil((float) value / (float) bucketSize) - 1;
            if (maxBucket[bucket] == Integer.MIN_VALUE) {
                maxBucket[bucket] = value;
                minBucket[bucket] = value;
            } else {
                maxBucket[bucket] = Math.max(maxBucket[bucket], value);
                minBucket[bucket] = Math.min(minBucket[bucket], value);
            }
        }

        int previousMax = maxBucket[0];
        int maxGap = 0;
        for (int i = 1; i < numOfBuckets; i++) {
            if (minBucket[i] == Integer.MAX_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, minBucket[i] - previousMax);
            previousMax = maxBucket[i];
        }
        return maxGap;
    }
}
