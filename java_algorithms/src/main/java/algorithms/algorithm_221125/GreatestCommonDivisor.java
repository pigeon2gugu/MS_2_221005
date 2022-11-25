package algorithms.algorithm_221125;

public class GreatestCommonDivisor {
    public int gcd(int a,int b) {
        if(a == b) {
            return a;
        } else if (a > b) {
            return gcd(a-b, b);
        } else if (a < b) {
            return gcd(a, b-a);
        }
        return 1;
    }

    public static void main(String[] args) {
        GreatestCommonDivisor gcdc = new GreatestCommonDivisor();
        System.out.println(gcdc.gcd(10,5));
    }
}
