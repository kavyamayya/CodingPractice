package com.scaler.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author kavya k on 18-May-2020
 *
 *Problem Description
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Problem Constraints
 * 1 <= Total number of intervals <= 100000.
 *
 * Input Format
 * First argument is a list of intervals.
 *
 * Output Format
 * Return the sorted list of intervals after merging all the overlapping intervals.
 *
 * Example Input
 * Input 1:
 * [1,3],[2,6],[8,10],[15,18]
 *
 * Example Output
 * Output 1:
 * [1,6],[8,10],[15,18]
 *
 * Example Explanation
 * Explanation 1:
 * Merge intervals [1,3] and [2,6] -> [1,6].
 * so, the required answer after merging is [1,6],[8,10],[15,18].
 * No more overlapping intervals present.
 *
 */
public class MergeOverlappingIntervals {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        Collections.sort(intervals ,new Comparator<Interval>(){
            public int compare(Interval s1, Interval s2) {
                if(s1.start == s2.start){
                    return s1.end-s2.end;
                }
                return s1.start-s2.start;
            }} );
        Interval current = new Interval(intervals.get(0).start , intervals.get(0).end);
        for(int i =1;i<intervals.size();i++){
            //System.out.println(current.start+" "+ current.end);
            //System.out.println(intervals.get(i).start+" "+ intervals.get(i).end);
            if(current.end>=intervals.get(i).start && current.start<=intervals.get(i).end){
                current.start = Math.min(intervals.get(i).start , current.start);
                current.end = Math.max(intervals.get(i).end , current.end);
            }else if(current.end < intervals.get(i).start){
                result.add(current);
                current = intervals.get(i);
            }else{
                result.add(intervals.get(i));
            }
        }
        result.add(current);
        return result;
    }

    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
}
