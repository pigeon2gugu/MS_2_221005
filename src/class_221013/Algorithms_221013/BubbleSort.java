package class_221013.Algorithms_221013;

import java.util.Arrays;

public class BubbleSort {

    public int[] sort(int [] arr) {
        for(int i = 1; i < arr.length; i++) {
            if(arr[0] > arr[i]) {
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{7, 2, 3, 9, 28, 11};
        // 오름차순 또는 내림차순을 정렬하는 알고리즘

        BubbleSort bubbleSort = new BubbleSort();

        int[] arrSort = bubbleSort.sort(arr);

        for(int i = 0; i< arrSort.length; i++) {
            System.out.print(arrSort[i] + " ");
        }


    }
}
