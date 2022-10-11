package class_221011.Algorithms_221011;
import java.util.*;

public class Programmers_test {

    public class Solution {
        public int solution(int n) {

            int nn = n;
            int length = (int)(Math.log10(n)+1);
            int answer = 0;
            for(int i = 0 ; i<length+1; i++){
                answer += (int)(nn/(Math.pow(10,length-i)));
                nn -= (int)(nn/(Math.pow(10,length-i)))*(Math.pow(10,length-i));
            }

            return answer;
        }
    }
}
