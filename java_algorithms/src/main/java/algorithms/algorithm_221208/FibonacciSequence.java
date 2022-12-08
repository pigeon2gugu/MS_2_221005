package algorithms.algorithm_221208;

//DP (Dynamic Programming) 핵심 로직 피보나치 수열
public class FibonacciSequence {

    public static int fib(int num) {
        int[] memo = new int[num+1];
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i <= num; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[num];
    }

    public static void main(String[] args) {
        System.out.println(fib(40));
    }
}
