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

        for(String key : pb.keySet()) {
            pb2.add(key.substring(0,minKey));
        }

        if(pb.size() != pb2.size()) {
            return false;
        }
        else {
            return true;
        }

    }
}
