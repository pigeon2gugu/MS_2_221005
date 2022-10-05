package class_221005.CodeUp;
import java.util.Scanner;

public class CodeUp1020 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String birth = input.split("-")[0];
        String info = input.split("-")[1];

        System.out.println(birth+info);
    }
}
