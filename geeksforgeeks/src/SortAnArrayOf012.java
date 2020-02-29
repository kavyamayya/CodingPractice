import java.util.Arrays;

/**
 * @author kavya k on 06-Feb-2020
 */
public class SortAnArrayOf012 {

    public static void main(String[] args){
        int N = 84;
        int[] array = new int[]{1,0,1,2,1,1,0,0,1,2,1,2,1,2,1,0,0,1,1,2,2,0,0,2,2,2,1,1,1,2,0,0,0,2,0,1,1,1,1,0,0,0,2,2,1,2,2,2,0,2,1,1,2,2,0,2,2,1,1,0,0,2,0,2,2,1,0,1,2,0,0,0,0,2,0,2,2,0,2,1,0,0,2,2
        };
        System.out.println(Arrays.toString(sortArray(array, N)));
    }

    private static int[] sortArray(int[] array , int N){
        int r=N-1;
        int l=0;
        int c=0;
        while(l-r != 0 && c!=N-1){
            if(array[c]==0){
                while(array[l] ==0){
                    l++;
                }
                array[c] = array[l];
                array[l] = 0;
                l++;
                c++;
            }else if(array[c] == 2){
                while(array[r] ==2){
                    r--;
                }
                array[c] = array[r];
                array[r] = 2;
                r--;
                c++;
            }else{
                if(c!=N-1 && array[c]>array[c+1]) {
                    System.out.println("c :" +c);
                    array[c] = array[c + 1];
                    array[l + 1] = 1;
                    l++;

                }
                c++;
            }
            for(int i=0;i<N;i++){
                System.out.print(array[i]+" ");
            }
            System.out.println();
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
}
