package scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kavya k on 24-Mar-2020
 */
public class recursion {

    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3));
        subsets(list);

    }
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        findSubset(A , result , 0,new ArrayList<Integer>());
        return result;
    }

    public static void findSubset(ArrayList<Integer> A , ArrayList<ArrayList<Integer>> result ,
                                  int currentIndex, ArrayList<Integer> tempArray){
        result.add(new ArrayList<Integer>(tempArray));
        for(int i=currentIndex;i<A.size();i++){
            tempArray.add(A.get(i));
            findSubset(A , result , i+1,tempArray);
            tempArray.remove(A.get(i));
        }
    }
}
