package class_221011.Algorithms_221011;

import java.util.*;

public class CodeUp_NumberOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        int nn = (int)(Math.log10(input)+1);

        System.out.println(nn);
    }
}