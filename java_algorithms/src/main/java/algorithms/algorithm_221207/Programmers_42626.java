package algorithms.algorithm_221207;

import java.util.PriorityQueue;


//더 맵게 (Heap)
//https://school.programmers.co.kr/learn/courses/30/lessons/42626

public class Programmers_42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<>();
        int mixFoodScoville = 0;

        for(int i = 0; i < scoville.length; i ++) {
            priorityQueueLowest.add(scoville[i]);
        }

        while(priorityQueueLowest.size() > 1) {

            mixFoodScoville = priorityQueueLowest.poll() + priorityQueueLowest.poll()*2;
            priorityQueueLowest.add(mixFoodScoville);
            answer += 1;

            if (priorityQueueLowest.peek() >= K) {
                return answer;
            }

        }

        return -1;


    }
}
