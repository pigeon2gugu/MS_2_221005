package algorithms.algorithm_221028;

//프로그래머스 해쉬 - 폰켓몬 (level 1)
//https://school.programmers.co.kr/learn/courses/30/lessons/1845

import java.util.HashSet;

public class Programmers_1845 {
    public int solution(int[] nums) {
        int answer = 0;

        HashSet<Integer> pokemon = new HashSet<>(); //중복 포켓몬 제거를 위한 Set
        int selecttLen = nums.length/2; //최대 픽업 가능 포켓몬 종류 수

        for(int num : nums) {
            pokemon.add(num);
        }

        answer = selecttLen;

        if(pokemon.size() < selecttLen) {
            answer = pokemon.size();
        }

        return answer;
    }
}
