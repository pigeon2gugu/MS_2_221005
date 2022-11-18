package algorithms.algorithm_221118;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/12926
//시저 암호
public class Programmers_12926 {
    public String solution(String s, int n) {
        String[] temp = s.split(" ");
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i + 1).equals(" ")) {
                answer += " ";
            } else if (65 <= s.charAt(i) && s.charAt(i) <= 90) {
                answer += (char) ((s.charAt(i) + n - 65) % 26 + 65);
            } else if (97 <= s.charAt(i) && s.charAt(i) <= 122) {
                answer += (char) ((s.charAt(i) + n - 97) % 26 + 97);
            }

        }

        return answer;
    }

}
