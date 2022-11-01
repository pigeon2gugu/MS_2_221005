package algorithms.algorithm_221101;

interface StatementStrategy {
    boolean compare(int a, int b);

}
public class TemplateCallbackPrime {
    boolean isPrime(int num, StatementStrategy stmt) {

        if(num == 2) {
            return false;
        }

        for (int i = 2; stmt.compare(i, num); i++) {
            if(num%i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TemplateCallbackPrime tcp = new TemplateCallbackPrime();

        boolean r = tcp.isPrime(17, (a,b) -> a* a  < b );

        System.out.println(tcp.isPrime(17, (a,b) -> a < b ));
        System.out.println(tcp.isPrime(17, (a,b) -> a < b/2 ));
        System.out.println(tcp.isPrime(17, (a,b) -> a* a < b ));

/*        boolean r = tcp.isPrime(13, new StatementStrategy() {
            @Override
            public boolean compare(int a, int b) {
                return a * a < b;
            }
        });*/

        System.out.println(r);
    }
}
