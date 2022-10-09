package class_221006.CodeUp;

import java.util.Scanner;

public class CodeUp1025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        for(int i =0; i<input.length(); i++) {
            int a1 = Integer.parseInt(String.valueOf(input.charAt(i))) * (int)Math.pow(10, input.length() - i -1);
            System.out.println("["+a1+"]");
        }
    }


}
