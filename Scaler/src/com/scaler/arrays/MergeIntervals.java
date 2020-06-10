package com.scaler.arrays;

import java.util.ArrayList;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Problem Constraints
 * 1 <= |intervals| <= 10^5
 *
 * Input Format
 * First argument is the vector of intervals second argument is the new interval to be merged
 *
 * Output Format
 * Return the vector of intervals after merging
 *
 * Example Input
 * Input 1:
 * Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
 *   Input 2:
 * Given intervals [1, 3], [6, 9] insert and merge [2, 6] .
 *
 * Example Output
 * Output 1:
 *  [ [1, 5], [6, 9] ]
 *   Output 2:
 *  [ [1, 9] ]
 *
 * Example Explanation
 * Explanation 1:
 * (2,6) does not completely merge the given intervals
 *   Explanation 2:
 *
 * (2,6) completely merges the given intervals
 *
 * @author kavya k on 18-May-2020
 */
public class MergeIntervals {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<>();
        int length = intervals.size();
        int start=Math.min(newInterval.start,newInterval.end);
        int end=Math.max(newInterval.start,newInterval.end);
        boolean overlapped=false;
        boolean noOverlapping = true;
        if(intervals.size() ==0 || (start<=intervals.get(0).start && end>=intervals.get(length-1).end)){
            result.add(new Interval(start,end));
            return result;
        }
        for(int i=0;i<intervals.size();i++){
            if(start<=intervals.get(i).end && end>=intervals.get(i).start){
                start = Math.min(intervals.get(i).start , start);
                end = Math.max(intervals.get(i).end , end);
                overlapped =true;
                noOverlapping = false;
            }else if(end<intervals.get(i).start && !overlapped && noOverlapping){
                result.add(new Interval(start,end));
                noOverlapping = false;
                result.add(intervals.get(i));
            }else{
                if(overlapped){
                    result.add(new Interval(start,end));
                    overlapped =false;
                }
                result.add(intervals.get(i));
            }
        }
        // System.out.println(start);
        //System.out.println(end);
        if(noOverlapping){
            result.add(new Interval(start,end));
        }
        if(!noOverlapping && end>=intervals.get(length-1).end){
            result.add(new Interval(start,end));
        }
        return result;
    }

    public class Interval {
      int start;
     int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
}
