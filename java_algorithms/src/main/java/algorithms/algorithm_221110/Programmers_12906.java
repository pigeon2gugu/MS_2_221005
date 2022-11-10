package algorithms.algorithm_221110;
import java.util.ArrayList;


//같은 숫자는 싫어
//https://school.programmers.co.kr/learn/courses/30/lessons/12906
public class Programmers_12906 {
    public class Solution {
        public ArrayList<Integer> solution(int []arr) {

            ArrayList<Integer> answer = new ArrayList<Integer>();
            int cc = arr[0];
            int cnt = 0;
            for(int i = 0; i<arr.length; i++) {
                if(arr[i] == cc && cnt == 0) {
                    answer.add(arr[i]);
                    cnt++;
                }

                if(arr[i] != cc) {
                    answer.add(arr[i]);
                    cnt = 1;
                    cc = arr[i];
                }
            }

            return answer;
        }
    }
}
