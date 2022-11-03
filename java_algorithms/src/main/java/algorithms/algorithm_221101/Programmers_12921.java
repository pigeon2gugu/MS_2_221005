package algorithms.algorithm_221101;

public class Programmers_12921 {

    @FunctionalInterface
    public interface solutionHow {
        int toNum();
    }
    public boolean solution1(int n) {

        for(int i = 2; i < n; i ++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }

    //나누기2 미만까지 탐색
    public boolean solution2(int n) {

        for(int i = 2; i < n/2; i ++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }

    //제곱근 이하까지
    public boolean solution3(int n) {

        for(int i = 2; i <= Math.sqrt(n); i ++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        Programmers_12921 pm = new Programmers_12921();

        System.out.println("solution1 result");
        System.out.println(pm.solution1(13));
        System.out.println(pm.solution1(17));
        System.out.println(pm.solution1(19));
        System.out.println(pm.solution1(2));

        System.out.println("solution2 result");
        System.out.println(pm.solution2(13));
        System.out.println(pm.solution2(17));
        System.out.println(pm.solution2(19));
        System.out.println(pm.solution2(2));

        System.out.println("solution3 result");
        System.out.println(pm.solution3(13));
        System.out.println(pm.solution3(17));
        System.out.println(pm.solution3(19));
        System.out.println(pm.solution3(2));

    }
}
