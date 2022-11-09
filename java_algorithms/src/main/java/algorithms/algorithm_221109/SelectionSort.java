package algorithms.algorithm_221109;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

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

    public int[] selectionSort2(int[] arr, BiFunction<Integer, Integer, Boolean> stmt) {
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
        ss.selectionSort2(arr, (a,b) -> a< b); //내림차순
        ss.selectionSort2(arr, (a,b) -> a> b); //오름차순

        //Fuction<input type, return type>
        //integer배열을 input으로 받아, boolean return.
        Function<Integer[], Boolean> fn = arr1 -> arr1[0] > arr1[1];
        System.out.println(fn.apply(new Integer[]{10, 20}));

        BiFunction<Integer, Integer, Boolean> biFunction = (a, b) -> a > b;


    }
}
