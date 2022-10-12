package class_221012.Algorithms_221012;
import java.util.Scanner;

public class CodeUp_MaxValue1_1 {

    public int[] getMax(int[] arr) {
        int maxValue = arr[0];
        int maxIdx = 0;

        for(int i =0; i< arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
                maxIdx = i;
            }
        }

        int arr1[] = new int[]{maxValue, maxIdx};
        return arr1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[] = new int[9];

        CodeUp_MaxValue1_1 cmv = new CodeUp_MaxValue1_1();

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(String.valueOf(sc.nextLine()));
        }

        int[] result = cmv.getMax(arr);

        System.out.println(result[0]);
        System.out.println(result[1]+1);

    }
}
