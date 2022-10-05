package class_221004;
import java.util.Scanner;

public class OddEvenTeacher {

    private String getEvenOdd(int num) {
        if (num % 2 == 0) {
            return "짝수";
        }
        else {
            return "홀수";
        }
    }

    public void printEvenOddStatement(int first, int second) {
        System.out.printf("%s+%s=%s", getEvenOdd(first), getEvenOdd(second), getEvenOdd(first+second));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input1 = sc.nextInt();
        int input2 = sc.nextInt();
        OddEvenTeacher main = new OddEvenTeacher();
        main.printEvenOddStatement(input1, input2);

    }
}
