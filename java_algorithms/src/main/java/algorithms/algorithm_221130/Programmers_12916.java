package algorithms.algorithm_221130;

//p와 y의 개수
//https://school.programmers.co.kr/learn/courses/30/lessons/12916
public class Programmers_12916 {
    boolean solution(String s) {
        boolean answer = true;

        int cntP = 0;
        int cntY = 0;

/*        for(int i = 0 ; i < s.length(); i++) {
            if(s.charAt(i) == 'P' || s.charAt(i) == 'p') {
                cntP += 1;
            }

            if(s.charAt(i) == 'Y' || s.charAt(i) == 'y') {
                cntY += 1;
            }
        }*/

        for(int i = 0 ; i < s.length(); i++) {
            if ('P' == Character.toUpperCase(s.charAt(i))) {
                cntP++;
            }

            if ('Y' == Character.toUpperCase(s.charAt(i))) {
                cntY++;
            }
        }

        if(cntP != cntY) {
            answer = false;
        }

        return answer;
    }
}
