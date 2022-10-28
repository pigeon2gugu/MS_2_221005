package algorithms.algorithm_221028;

import java.util.*;

public class Programmers_42577 {
    public boolean solution(String[] phone_book) {

        HashMap<String, Integer> pb = new HashMap<>();

        for(String phoneb : phone_book) {
            pb.put(phoneb, phoneb.length());
        }

        Integer minKey = Collections.min(pb.values());

        HashSet<String> pb2 = new HashSet<>();

        //전화번호의 최소길이로 탐색하는 것은 잘못된 풀이 방법이었다.
        //일일히 탐색 필요.

        for(String key : pb.keySet()) {
            for(int j =1; j <key.length(); j++) {
                if(pb.containsKey(key.substring(0,j))) {
                    return false;
                }
            }
        }

        return true;


    }
}
