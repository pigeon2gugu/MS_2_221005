package algorithms.algorithm_221125;

//재귀 사용 x
public class GreatestCommonDivisor_2 {

    public int gcd(int a,int b) {

        while(true) {

            if (a > b) {
                a = a-b;
            } else if (a < b) {
                b = b-a;
            } else if (a==b) {
                break;
            }
        }

        return a;
    }


    public static void main(String[] args) {

        int a = 5;
        int b = 10;

        GreatestCommonDivisor_2 gcdc = new GreatestCommonDivisor_2();
        System.out.println(gcdc.gcd(a,b));
    }
}
