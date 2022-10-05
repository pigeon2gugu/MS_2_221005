package class_221004;
import java.util.Scanner;

public class Money {
    public static void main(String[] args) {

        System.out.print("액수를 입력 하세요");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        
        int[] arr1 = {50000, 10000, 5000, 1000, 500, 100};
        int[] arr2 = new int[arr1.length];

        for(int i =0; i<arr1.length; i++){
            if(input/arr1[i] >=1){
                arr2[i] = input/arr1[i];
                input -= arr1[i]*arr2[i];
                System.out.println();
                System.out.println(arr1[i]+" 원 "+arr2[i]+" 장");
            }
        }
    }
}
