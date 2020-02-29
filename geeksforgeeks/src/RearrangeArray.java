/*
 * @author kavya k on 23-Feb-2020
 /*

public class RearrangeArray {

    public static void main(String[] args)
    {
        RearrangeArray rearrange = new RearrangeArray();
        int arr[] = {3 ,2,0,1};
        int n = arr.length;

        System.out.println("Given Array is :");
        rearrange.printArr(arr, n);

        rearrange.rearrange(arr, n);

        System.out.println("Modified Array is :");
        rearrange.printArr(arr, n);
    }

    void printArr(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }

    void rearrange(int[] array , int N , int i){
        int index = i;
        int backUp = array[i];
        int origValue = array[array[i]];
        int assignalue = -(array[array[i]]+1);
        while(value!=array[array[value]]){
            int nextIndex = array[index];
            array[index] = value;
            value = array[value];
            index = nextIndex;
        }
        array[index] = backUp;
    }
}
*/
