package scaler.test.sudhir;

/**
 * @author kavya k on 02-Feb-2020
 */
public class SoManyProblems {

    public static void main(String[] args){
        //ith type of A[i] minutes
        int[] A = new int[]{1,2 ,3};
        //number of problems of ith type
        int[] B = new int[]{2,3,1};
        //gap in minutes
        int C = 10;
        System.out.println(findTheTime(A , B ,C));
    }

    private static String findTheTime(int[] A , int[] B , int C){
        int timeInMinutes = 0;
        for(int i=0;i<A.length;i++){
            timeInMinutes+=(A[i]*B[i])+(C*B[i]);
        }
        timeInMinutes-=C;
        System.out.println(timeInMinutes);
        int hours = timeInMinutes/60;
        int minutes = timeInMinutes%60;
        return hours +" hours " + minutes + " minutes ";
    }
}
