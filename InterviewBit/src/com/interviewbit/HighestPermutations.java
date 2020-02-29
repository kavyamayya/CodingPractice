package com.interviewbit;

/*
 * @author kavya k on 27-Feb-2020
 */
    import java.util.ArrayList;
import java.util.List;

    public class HighestPermutations {

        public static void main(String[] args) {
            int[] array = new int[] {10,1 ,2 ,4,3,2,1};
            //int[] array = new int[] {1 ,2 ,10,9,8};
            fillArray(array);

        }

        private static void fillArray(int[] array) {
            int length = array.length;
            int smallest = array[length-1];
            int index = length-1;
            int pointer=length-1;
            for(int i=length-2;i>0;i--) {
                if(array[i]<array[pointer]) {
                    while(array[i]>=array[index]){
                        index=index-1;
                        smallest = array[index];
                    }
                    array[index] = array[i];
                    array[i] = smallest;
                    break;
                }else {
                    pointer = pointer-1;
                }
            }
            swap(array,pointer);

            for (int value : array) System.out.print(value + " ");

            System.out.println();
        }

        private static void swap(int[] array,int pointer){
            int start = pointer;
            int end = array.length-1;
            while(start<end){
                int temp = array[start];
                array[start] = array[end];
                array[end]= temp;
                start++;
                end--;
            }
        }

    }
