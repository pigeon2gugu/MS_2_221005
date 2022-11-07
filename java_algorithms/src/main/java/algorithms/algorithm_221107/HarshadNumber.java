package algorithms.algorithm_221107;

public class HarshadNumber {
    public int sumOfDigits(int num) {
        int len = (int) (Math.log(num));
        int sum = 0;

        for(int i = len-1; i >= 0; i --) {

            sum += (int) (num/Math.pow(10, i));
            num = (int) ((num%Math.pow(10, i)));

        }

        return sum;
    }

    public boolean solution(int x) {
        if(x%sumOfDigits(x) == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        HarshadNumber hn = new HarshadNumber();
        System.out.println(hn.sumOfDigits(123));
        System.out.println(hn.solution(18));
    }
}
