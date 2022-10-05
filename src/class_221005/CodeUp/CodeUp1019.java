package class_221005.CodeUp;
import java.util.Scanner;

public class CodeUp1019 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String year = String.format("%04d", Integer.valueOf(input.split("\\.")[0]));
        String month = String.format("%02d", Integer.valueOf(input.split("\\.")[1]));
        String day = String.format("%02d", Integer.valueOf(input.split("\\.")[2]));

        System.out.println(year+"."+month+"."+day);
    }
}
