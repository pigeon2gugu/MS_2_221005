package class_221026;
import java.util.Scanner;

public class AlphaToNum {
    public int AlphabetToNumber(char alpha) {
        return  (int)(alpha);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char input = sc.nextLine().charAt(0);

        AlphaToNum atn = new AlphaToNum();
        System.out.println(atn.AlphabetToNumber(input));
    }
}
