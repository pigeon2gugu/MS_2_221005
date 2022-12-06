package algorithms.algorithm_221205;

import java.util.Arrays;

public class HeapSort2 {


    public static int[] child(int a) {
        int[] children = {2*a+1, 2*a+2};
        return children;
    }

    public static int[] heap(int[] arr, int parentIdx) {

        int leftIdx = parentIdx * 2 + 1;
        int rightIdx = parentIdx * 2 + 2;

        int greaterIdx = parentIdx;

        if (leftIdx < arr.length && arr[leftIdx] > arr[greaterIdx]) {
            greaterIdx = leftIdx;
        }

        if (rightIdx < arr.length && arr[rightIdx] > arr[greaterIdx]) {
            greaterIdx = rightIdx;
        }

        if(parentIdx != greaterIdx)  {
            int temp = arr[parentIdx];
            arr[parentIdx] = arr[greaterIdx];
            arr[greaterIdx] = temp;
            heap(arr, greaterIdx);
        }

        return arr;
    }



    public static void main(String[] args) {
        int[] arr = new int[]{6, 5, 7, 8};
        arr = new int[]{5, 8, 4, 7, 3, 2, 9, 6, 7};
        for (int j = (arr.length-2)/2; j >= 0 ; j--) {
            arr = heap(arr, j);
            System.out.println(Arrays.toString(arr));
        }
    }
}
