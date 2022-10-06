package CodeUp;

import java.util.Scanner;

public class CodeUp1027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String year = (input.split("\\.")[0]);
        String month = (input.split("\\.")[1]);
        String day = (input.split("\\.")[2]);

        System.out.println(day+"-"+month+"-"+year);
    }


}
