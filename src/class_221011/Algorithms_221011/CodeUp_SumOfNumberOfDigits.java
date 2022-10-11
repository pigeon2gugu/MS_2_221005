package class_221011.Algorithms_221011;

import java.util.Scanner;

public class CodeUp_SumOfNumberOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        int origin = input;
        int length = (int)(Math.log10(input)+1);
        int nod = 0;

        do {
            nod = 0;
            for(int i = 0; i<length+1; i++) {
                nod += (int) (origin / Math.pow(10, length - i));
                origin = (int) (origin % Math.pow(10, length - i));
            }
            origin = nod;
            length = (int)(Math.log10(nod)+1);
            System.out.println(length);
        } while((int)(Math.log10(origin)+1) > 1);

        System.out.println(nod);
    }
}