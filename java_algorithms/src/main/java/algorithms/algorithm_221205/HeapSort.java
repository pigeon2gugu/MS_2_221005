package algorithms.algorithm_221205;

import java.util.Arrays;

public class HeapSort {

    public static void change(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static int[] heap(int[] arr) {

        int idx = arr.length -1;

        while(idx > 0) {

           if (arr[ (int) Math.floor( (double) (idx -1)/2)] < arr[idx]) {
               int temp = arr[(int) Math.floor( (double) (idx -1)/2)];
               arr[(int) Math.floor( (double) (idx -1)/2)] = arr[idx];
               arr[idx] = temp;
            }

            idx -= 1;
        }

        System.out.println(Arrays.toString(arr));

        return arr;
    }

    public static void main(String[] args) {
        int [] arr = {6, 7, 5, 8};
        heap(arr);
    }
}
