package class_221005.CodeUp;
import java.util.Scanner;

public class CodeUp1017 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String hour = input.split(":")[0];
        String minute = input.split(":")[1];

        System.out.println(hour+":"+minute);
    }
}
