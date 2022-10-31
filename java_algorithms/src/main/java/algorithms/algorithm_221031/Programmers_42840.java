package algorithms.algorithm_221031;
//프로그래머스 완전탐색 - 모의고사 (lv 1)
//https://school.programmers.co.kr/learn/courses/30/lessons/42840

import java.util.*;

public class Programmers_42840 {

    class Solution {
        public ArrayList<Integer> solution(int[] answers) {

            ArrayList<Integer> a = new ArrayList<Integer>();

            int[] std1Ans = {1, 2, 3, 4, 5};
            int[] std2Ans = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] std3Ans = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

            Map<Integer, Integer> stdScore = new HashMap<>();
            stdScore.put(1, 0);
            stdScore.put(2, 0);
            stdScore.put(3, 0);

            for(int i = 0; i < answers.length; i++) {
                if(std1Ans[i%5] == answers[i]) {
                    stdScore.put(1, stdScore.get(1) + 1);
                }
                if(std2Ans[i%8] == answers[i]) {
                    stdScore.put(2, stdScore.get(2) + 1);
                }
                if(std3Ans[i%10] == answers[i]) {
                    stdScore.put(3, stdScore.get(3) + 1);
                }
            }

            int maxScore = Collections.max(stdScore.values());

            for(int i = 1 ; i <= 3; i++) {
                if (stdScore.get(i) == maxScore) {
                    a.add(i);
                }
            }

            return a;
        }
    }

}
