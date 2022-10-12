package class_221012.Algorithms_221012;

import java.util.Scanner;

public class CodeUp_MaxValue2 {

    public int[] getMax(int[][] arr) {

        int maxValue = arr[0][0];
        int maxIdx = 0;
        int maxIdx2 = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > maxValue) {
                    maxValue = arr[i][j];
                    maxIdx = i;
                    maxIdx2 = j;
                }
            }
        }

        int arr1[] = new int[]{maxValue, maxIdx, maxIdx2};
        return arr1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CodeUp_MaxValue2 cmv = new CodeUp_MaxValue2();

        int arr[][] = new int[9][9];


        for (int i = 0; i < arr.length; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(input.split(" ")[j]));
            }
        }

        int[] result = cmv.getMax(arr);

        System.out.println(result[0]);
        System.out.println(result[1] + 1);
        System.out.println(result[2] + 1);

    }
}
