package algorithms.algorithm_221024;
//https://school.programmers.co.kr/learn/courses/30/lessons/42748?language=java
//정렬 알고리즘

import java.util.Arrays;

public class Programmers_42748 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int  idx = 0;

        for(int[] command: commands) {
            int[] slicedArr = Arrays.copyOfRange(array, command[0]-1, command[1]); //범위로 array copy
            Arrays.sort(slicedArr); //array 정렬
            answer[idx++]=slicedArr[command[2]-1]; //해당 index 꺼내기
        }

        return answer;
    }
}
