package algorithms.algoritm_221021;

import java.util.Arrays;
import java.util.Stack;

public class RightParenthesisStack {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < s.length(); i++) {
            if(s.charAt(i)== '(') {
                st.push(s.charAt(i));
            } else if (s.charAt(i)== ')') {
                if(st.empty()) return false;
                st.pop();
            }
        }

        return st.empty();
    }

    public static void main(String[] args) {
        RightParenthesisStack rightParenthesis = new RightParenthesisStack();
        System.out.println(rightParenthesis.solution(	")()(" ));

    }
}
