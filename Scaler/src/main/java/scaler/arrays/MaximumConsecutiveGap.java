package scaler.arrays;

import java.util.Arrays;

/**
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * Try to solve it in linear time/space.
 * Example:
 * Input : [1, 10, 5]
 * Output : 5
 * Return 0 if the array contains less than 2 elements.
 * You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 * You may also assume that the difference will not overflow.
 *
 * @author kavya k on 28-Feb-2020
 */
public class MaximumConsecutiveGap {
    public static void main(String[] args) {
        int[] A = new int[]{1, 1, 2};
        System.out.println(maximumGap(A));
    }

    public static int maximumGap(final int[] A) {
        //if the array s null or only one element is there in the array return 0
        if ((A == null) || (A.length < 2)) {
            return 0;
        }
        //finding the min and max of array
        int min = A[0];
        int max = A[0];
        int n = A.length;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }
        //find the size of the bucket
        int bucketSize = (max - min) / (n - 1);
        //if the bucket size is zero then the elements in the array are identical or there are more number
        //of repeating elements with less difference. eg;{1,1,2} then return max-min
        if (bucketSize == 0) {
            return max - min;
        }
        //find the total number of buckets
        int numOfBuckets = (int) Math.ceil((float) max / (float) bucketSize);
        //maxBucket and minBuckets are defined for storing maximum and minimum values in each bucket
        int maxBucket[] = new int[numOfBuckets];
        int minBucket[] = new int[numOfBuckets];
        //fill the min array with maximum possible value and max array with min possible value
        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        //iterating over elements and finding its bucket
        for (int i = 0; i < n; i++) {
            //find in which bucket the element belongs to
            int bucket = (int) Math.ceil((float) A[i] / (float) bucketSize) - 1;
            //check the min and max values in that bucket with the element and change the value of min or max if required
            if (maxBucket[bucket] == Integer.MIN_VALUE) {
                maxBucket[bucket] = A[i];
                minBucket[bucket] = A[i];
            } else {
                maxBucket[bucket] = Math.max(maxBucket[bucket], A[i]);
                minBucket[bucket] = Math.min(minBucket[bucket], A[i]);
            }
        }
        //check the consecutive gaps across the buckets and return the maximum gap among them.
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
