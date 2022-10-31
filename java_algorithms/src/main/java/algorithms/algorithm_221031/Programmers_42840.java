package algorithms.algorithm_221031;
//프로그래머스 완전탐색 - 모의고사 (lv 1)
//https://school.programmers.co.kr/learn/courses/30/lessons/42840

public class Programmers_42840 {
    class Solution {
        public int[] solution(int[] answers) {
            int[] answer = {};

            int[] std1Ans = {1, 2, 3, 4, 5};
            int[] std2Ans = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] std3Ans = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

            int std1Score = 0 ;
            int std2Score = 0 ;
            int std3Score = 0;

            for(int i = 0; i < answers.length; i++) {
                if(std1Ans[i/5 + (i)%5] == answer[i]) {
                    std1Score += 1;
                }
            }

            System.out.println(std1Score);

            return answer;
        }
    }

}
