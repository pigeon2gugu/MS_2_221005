package class_221011.CodeUp;
import java.util.Scanner;

public class CodeUp1045 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long input1 = sc.nextLong();
        long input2 = sc.nextLong();

        long result1 = input1 + input2;
        long result2 = input1 - input2;
        long result3 = input1 * input2;
        long result4 = (int)(input1 / input2);
        long result5 = (int)(input1 % input2);
        String result6 = String.format("%.2f", ((float)input1/(float)input2));

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
    }
}
