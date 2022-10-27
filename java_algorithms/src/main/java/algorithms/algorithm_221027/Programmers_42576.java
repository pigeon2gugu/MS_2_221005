package algorithms.algorithm_221027;

import java.util.HashMap;
import java.util.Map;

//https://school.programmers.co.kr/learn/courses/30/lessons/42576?language=java
//완주하지 못한 선수

public class Programmers_42576 {

    public String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> ptp = new HashMap<>();

        //참가자 HashMap에 add. key : name, value : count 중복 이름의 경우 count를 늘려줌
        for(String i : participant) {
            if(ptp.get(i) == null)  {
                ptp.put(i, 1);
            }
            else {
                ptp.put(i, ptp.get(i)+1);
            }
        }

        //완주자 또한 같은 HashMap에 add하여 count를 늘려준다.
        for(String i : completion) {
            if(ptp.get(i) == null)  {
                ptp.put(i, 1);
            }
            else {
                ptp.put(i, ptp.get(i)+1);
            }
        }

        String answer = "";
        for(Map.Entry<String, Integer> e : ptp.entrySet()) {
            //HashMap의 value가 홀수이면 완주하지 못한 자가 있는 것
            if(e.getValue()%2 == 1) {
                answer = e.getKey();
            }
        }

        return answer;
    }
}
