package algorithms.algorithm_221116;

import java.util.Arrays;

//array이용
//이전 로직은 공간 복잡도가 높음
//GarbageCollection문제 → List를 만들고 merge. GC문제가 생길 수 있음.
public class QuickSort_2 {

    public static void main(String[] args) {
        int[] arr = new int[] {20, 18, 5, 19, 40, 50, 5, 25 };
        int pivot = arr[arr.length/2];
        int leftIdx = 0;
        int rightIdx = arr.length-1;

        while(true) {
            while (arr[leftIdx] < pivot) {
                leftIdx += 1;
            }

            while (arr[rightIdx] > pivot) {
                rightIdx -= 1;
            }

            if (leftIdx <= rightIdx) {
                int temp = arr[leftIdx];
                arr[leftIdx] = arr[rightIdx];
                arr[rightIdx] = temp;
                leftIdx += 1;
                rightIdx -= 1;
            } else {
                break;
            }
        }

        int[] leftArr = new int[leftIdx];
        int[] rightArr = new int[arr.length-leftIdx];

        for(int i = 0; i < leftIdx; i++) {
            leftArr[i] = arr[i];
        }

        for(int i = 0 ; i < rightArr.length; i++){
            rightArr[i] = arr[i+leftIdx];
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(leftArr));
        System.out.println(Arrays.toString(rightArr));
    }


}
