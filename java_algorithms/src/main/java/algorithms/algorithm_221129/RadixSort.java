package algorithms.algorithm_221129;

import java.util.Arrays;

//기수 정렬
//각 숫자를 해당 숫자 번째 배열에 넣고 넣은 순서 대로 꺼내면 정렬이 되는 정렬 방식
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 4, 5, 9, 1, 0};
        int[] redixArr = new int[10];
        Arrays.fill(redixArr, -1);

        for (int i : arr) {
            redixArr[i] = i;
        }

        System.out.println(Arrays.toString(redixArr));

        int cnt = 0;
        for(int i : redixArr) {
            if(i > -1) {
                arr[cnt] = i;
                cnt ++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
