package algorithms.alogorithm_221201;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;


//명예의 전당
//https://school.programmers.co.kr/learn/courses/30/lessons/138477
//우선순위 큐 이용
public class Programmers_138477 {

    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> top = new PriorityQueue<>();
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < score.length; i++) {
            if(i < k) {
                top.add(score[i]);

            } else if(score[i] > top.peek() ) {
                top.poll();
                top.add(score[i]);

            }
            answer.add(top.peek());

        }

        //k가 score.length보다 클 경우. (테스트 9, 11 runtime error해결)
        if(k > score.length) {
            for(int i = k; i < score.length; i++) {
                answer.add(top.peek());
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
