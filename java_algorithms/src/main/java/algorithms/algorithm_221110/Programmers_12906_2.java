package algorithms.algorithm_221110;
import java.util.ArrayList;
import java.util.Stack;


//같은 숫자는 싫어
//https://school.programmers.co.kr/learn/courses/30/lessons/12906
//스택 사용

public class Programmers_12906_2 {
    public class Solution {
        public int[] solution(int []arr) {

            Stack<Integer> answer = new Stack<>();
            answer.push(arr[0]);

            int cc = arr[0];

            for(int i = 0; i<arr.length; i++) {
                if(arr[i] != cc) {
                    answer.push(arr[i]);
                    cc = arr[i];
                }
            }
            int[] answer2 = new int[answer.size()];

            for(int i = 0; i<answer2.length; i++) {
                answer2[answer2.length-1-i] = answer.peek();
            }

            return answer2;

        }
    }
}
