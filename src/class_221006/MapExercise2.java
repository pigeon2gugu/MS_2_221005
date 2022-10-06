package class_221006;

import java.util.HashMap;

public class MapExercise2 {
    public static void main(String[] args) {
        String repoAdr = "https://github.com/pigeon2gugu/like-lion-2";

        HashMap<Character, Integer> alphabetCnt = new HashMap<>();

        for(int i=0; i<26; i++) {
            int cnt = 0;
            for(int j=0; j<repoAdr.length(); j++) {
                if((char)(i+65) == repoAdr.charAt(j) || (char)(i+97) == repoAdr.charAt(j)){
                    cnt += 1;
                    alphabetCnt.put((char)(i+65),cnt);
                }
            }
        }
        System.out.println(alphabetCnt);
    }
}
