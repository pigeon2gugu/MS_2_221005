package algorithms.algorithm_221129;

import java.util.*;

//기수 정렬
//각 숫자를 해당 숫자 번째 배열에 넣고 넣은 순서 대로 꺼내면 정렬이 되는 정렬 방식

//자리수 정렬
public class RadixSort2 {

    public static int[] getDigits(int[] arr) {
        Set<Integer> digits = new HashSet<>();

        for(int i : arr) {
            if(i == 0) {
                digits.add(1);
            } else {
                digits.add( (int)(Math.log10(i)) + 1);
            }
        }

        int[] digitsArr = new int[digits.size()];
        int cnt = 0;
        for(Integer i : digits) {
            digitsArr[cnt] = i;
            cnt++;
        }

        Arrays.sort(digitsArr);

        return digitsArr;

    }

    public static int[] sort(int[] arr, int digit) {
        Queue<Integer>[] queueArr = new Queue[10];

        int[] digits = getDigits(arr);

        for(int i = 0; i  < queueArr.length; i++) {
            queueArr[i] = new ArrayDeque<>();
        }

        for(int i : arr) {
            int divisor = (int) Math.pow(10, digit-1);
            queueArr[Math.floorDiv(i, divisor) % 10].add(i);

        }

        int cnt = 0;
        for (int i = 0; i < queueArr.length; i++) {
            while(!queueArr[i].isEmpty()){
                arr[cnt] = queueArr[i].poll();
                cnt ++;
            }
        }

        return arr;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 7, 7, 8, 13, 14, 16, 18, 203};
        int[] digits = getDigits(arr);

        System.out.println(Arrays.toString(getDigits(arr)));
        for(var digit : digits) {
            arr = sort(arr, digit);
            System.out.println(Arrays.toString(arr));
        }

    }
}
