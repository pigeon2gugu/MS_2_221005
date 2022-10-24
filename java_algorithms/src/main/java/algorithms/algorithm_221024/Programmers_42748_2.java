package algorithms.algorithm_221024;
//https://school.programmers.co.kr/learn/courses/30/lessons/42748?language=java
//정렬 알고리즘
//priority queue 사용

import java.util.PriorityQueue;

public class Programmers_42748_2 {

    public int getKthNum (int[] command, int[] arr) {
        int frIdx = command[0]; //from index
        int toInx = command[1]; //to index
        int nth = command[2]; //pick index
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = frIdx-1; i < toInx; i++)  {
            pq.add(arr[i]); //heap구조로 정렬되기 때문에  생각한 우선순위가 아닐 수 있음.
        }

        for (int i = 0; i < nth; i++) {
            result = pq.poll(); // stack의 pop과 비슷 이 때 우선순위로 poll이 됨
        }
        return result;
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            answer[i] = getKthNum(commands[i], array);
        }

        return answer;
    }

    public static void main(String[] args) {
        Programmers_42748_2 pg = new Programmers_42748_2();
        int[] arrT = {1, 5, 2, 6, 3, 7, 4};
        int[][] comT = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        pg.solution(arrT, comT);
    }
}
