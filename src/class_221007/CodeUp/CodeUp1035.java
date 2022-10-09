package class_221007.CodeUp;

import java.util.Scanner;


public class CodeUp1035 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String int16 = Integer.toOctalString(Integer.parseInt(input, 16));

        System.out.println(int16);
    }
}
