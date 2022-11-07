package algorithms.algorithm_221107;

public class HarshadNumber {
    public int sumOfDigits(int num) {
        int len = (int) (Math.log(num));
        int sum = 0;
        int num1 = num;

        for(int i = len-1; i >= 0; i --) {

            sum += (int) (num1/Math.pow(10, i));
            num1 = (int) ((num1%Math.pow(10, i)));

        }

        return sum;
    }

    public static void main(String[] args) {
        HarshadNumber hn = new HarshadNumber();
        System.out.println(hn.sumOfDigits(123));
    }
}
