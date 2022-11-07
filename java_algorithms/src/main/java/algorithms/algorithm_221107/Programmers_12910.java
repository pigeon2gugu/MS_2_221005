package algorithms.algorithm_221107;
import java.util.PriorityQueue;
//나누어 떨어지는 숫자 배열
//https://school.programmers.co.kr/learn/courses/30/lessons/12910

public class Programmers_12910 {
    public int[] solution(int[] arr, int divisor) {

        PriorityQueue<Integer> pqAns = new PriorityQueue<>();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i]%divisor == 0) {
                pqAns.add(arr[i]);
            }
        }

        if(pqAns.size() == 0) {
            int[] answer = {-1};
            return answer;
        }

        int[] answer = new int[pqAns.size()];
        for(int i = 0; i < answer.length; i ++) {
            answer[i] = pqAns.poll();
        }

        return answer;
    }
}
