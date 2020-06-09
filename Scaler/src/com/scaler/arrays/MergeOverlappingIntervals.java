package com.scaler.arrays;

/**
 * @author kavya k on 18-May-2020
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
