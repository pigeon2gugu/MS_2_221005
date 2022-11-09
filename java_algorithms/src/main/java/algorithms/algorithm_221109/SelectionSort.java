package algorithms.algorithm_221109;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 4, 9, 10, 223, 111, 23, 3, 39};

        int minNum = arr[0];
        int minIdx = 0;


        //i = 0 에  최소값 넣기
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < minNum) {
                minNum = arr[i];
                minIdx = i;
                System.out.println(minNum);
            }
        }
        int temp = arr[0];
        arr[0] = arr[minIdx];
        arr[minIdx] = temp;

        System.out.println(Arrays.toString(arr));
    }
}
