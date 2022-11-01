package algorithms.algorithm_221101;

public class Programmers_12921 {
    public boolean solution(int n) {
        if(n == 2) {
            return false;
        }
        for(int i = 2; i < n; i ++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {

        Programmers_12921 pm = new Programmers_12921();
        System.out.println(pm.solution(13));
        System.out.println(pm.solution(17));
        System.out.println(pm.solution(19));
        System.out.println(pm.solution(2));
    }
}
