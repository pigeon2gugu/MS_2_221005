package class_221011.CodeUp;
import java.util.Scanner;

public class CodeUp1046 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long input1 = sc.nextLong();
        long input2 = sc.nextLong();
        long input3 = sc.nextLong();

        long result1 = input1 + input2 + input3;
        String result2 = String.format("%.1f", ((float)(result1)/(float)3));

        System.out.println(result1);
        System.out.println(result2);

    }
}
