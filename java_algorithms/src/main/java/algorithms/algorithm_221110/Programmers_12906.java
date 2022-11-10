package algorithms.algorithm_221110;
import java.util.ArrayList;


//같은 숫자는 싫어
//https://school.programmers.co.kr/learn/courses/30/lessons/12906
public class Programmers_12906 {
    public class Solution {
        public ArrayList<Integer> solution(int []arr) {

            ArrayList<Integer> answer = new ArrayList<Integer>();
            answer.add(arr[0]);

            int cc = arr[0];
            for(int i = 0; i<arr.length; i++) {
                if(arr[i] != cc) {
                    answer.add(arr[i]);
                    cc = arr[i];
                }
            }

            return answer;

        }
    }
}
