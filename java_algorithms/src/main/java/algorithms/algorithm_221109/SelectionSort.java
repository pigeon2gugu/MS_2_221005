package algorithms.algorithm_221109;

import java.util.Arrays;

interface StatementStrategy {
    boolean apply(int a, int b);
}
public class SelectionSort {

    public int[] selectionSort(int[] arr, StatementStrategy stmt) {
        for(int i = 0; i < arr.length; i ++) {
            int minIdx = i;
            for(int j = i; j < arr.length; j++) {
                if(stmt.apply(arr[minIdx], arr[j])) {
                    minIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }



    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 4, 9, 10, 223, 111, 23, 3, 39};
        SelectionSort ss = new SelectionSort();
        ss.selectionSort(arr, (a,b) -> a< b); //내림차순
        ss.selectionSort(arr, (a,b) -> a> b); //오름차순

    }
}
