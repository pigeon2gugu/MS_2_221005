package class_221004;
import java.util.Scanner;

public class MoneyTeacher {
    public static void main(String[] args) {

        // 현금으로 돈을 받고 25000원을 거슬러 주어야 합니다.
        // 5만원짜리는 몇장 만원짜리는 몇장 5천원짜르는 몇장을 거슬러 주어야 할까요?

        int[] currencyType = new int[]{50000, 10000, 5000, 1000, 500, 100};

        int curr50000 = 50000;
        int curr10000 = 10000;
        int curr5000 = 5000;
        int curr1000 = 1000;
        int curr500 = 500;

        int refund = 25000; // 25000원이라면 만원 2장 5000원 1장

        System.out.printf("5만원권 %d개 나머지 : %d\n", refund/ curr50000, refund % curr50000);
        refund = refund % curr50000; //modulo(mod) 나머지 연산
        System.out.printf("1만원권 %d개 나머지 : %d\n", refund/ curr10000, refund % curr10000);
        refund = refund % curr10000;
        System.out.printf("5천원권 %d개 나머지 : %d\n", refund/ curr5000, refund % curr5000);
        refund = refund % curr5000;
        System.out.printf("1천원권 %d개 나머지 : %d\n", refund/ curr1000, refund % curr1000);
        refund = refund % curr1000;
        System.out.printf("5백원권 %d개 나머지 : %d\n", refund/ curr500, refund % curr500);
        refund = refund % curr500;
        System.out.printf("1백원권 %d개 나머지 : %d\n", refund/ 100, refund % 100);
        refund = refund % 100;
        System.out.printf("5십원권 %d개 나머지 : %d\n", refund/ 50, refund % 50);
        refund = refund % 50;

        // 50000 0장
        // 10000
        // 5000
        // 1000
        // 500
        // 의 개수를 출력하세요

    }
}
