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

    public static long fib2(int n, long[] memo) {
        if(n == 0) throw new IllegalArgumentException("n은 1이상 이어야 한다.");
        if (n <=2 ) return 1;

        if(memo[n] == 0){
            memo[n] = fib2(n - 1, memo) + fib2(n - 2, memo);
        }
        return memo[n];
    }


    public static void main(String[] args) {
        System.out.println(fib(5));

        int n = 5;
        var r = (fib2(n, new long[n + 1]));
        System.out.println(r);
    }
}
