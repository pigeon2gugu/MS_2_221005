package algorithms.algorithm_221115;

import java.util.ArrayList;
import java.util.List;

//재귀 이용
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = new int[] {20, 18, 5, 19, 5, 25, 40, 50};

        int idx = (int)(arr.length/2);
        int pivot = arr[idx];

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> middle = new ArrayList<>();

        middle.add(pivot);

        for(int i = 0; i<arr.length; i++) {
            if(i == idx) {
                continue;
            }
            if(arr[i] <= pivot) {
                left.add(arr[i]);
            } else {
                right.add(arr[i]);
            }
        }

        System.out.println(left);
        System.out.println(middle);
        System.out.println(right);
    }

}
