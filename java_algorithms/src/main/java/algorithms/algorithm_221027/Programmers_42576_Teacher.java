package algorithms.algorithm_221027;

import java.util.HashMap;
import java.util.Map;

//https://school.programmers.co.kr/learn/courses/30/lessons/42576?language=java
//완주하지 못한 선수

//동명이인 처리
public class Programmers_42576_Teacher {

    public String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> ptp = new HashMap<>();

        //참가자 HashMap에 add. key : name, value : count. 동명이인의 경우 count로 더해줌
        for(String i : participant) {
            if(!ptp.containsKey(i))  {
                ptp.put(i, 0);
            }
            ptp.put(i,ptp.get(i)+1);
        }

        //완주자의 name이 HashMap에 key로 존재하면 count -1 해준다.
        for(String i : completion) {
            ptp.put(i, ptp.get(i)-1);
        }

        String answer = "";
        for(Map.Entry<String, Integer> e : ptp.entrySet()) {
            //HashMap의 value가 1이면 완주하지 못한 자가 있는 것
            if(e.getValue() == 1) {
                answer = e.getKey();
            }
        }

        return answer;
    }
}
