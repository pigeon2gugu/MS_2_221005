package algorithms.algoritm_221021;

import java.util.Arrays;

public class RightParenthesis {
    boolean solution(String s) {

        System.out.println(s.indexOf("()"));


        while (s.indexOf("()") >=0) {
            s = s.replace("()", "");
        }

        return s.length() == 0;
    }

    public static void main(String[] args) {
        RightParenthesis rightParenthesis = new RightParenthesis();
        System.out.println(rightParenthesis.solution("(())"));
    }
}
