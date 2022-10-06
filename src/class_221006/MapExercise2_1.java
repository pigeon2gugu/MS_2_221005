package class_221006;

import java.util.HashMap;

public class MapExercise2_1 {

    public boolean isAlphabet(char alpha) {
        if ((alpha >= 'A' && alpha <='Z') || (alpha >= 'a' && alpha <= 'z')) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        MapExercise2_1 isAlpha = new MapExercise2_1();

        String s1 = "aabbbbcdeefghhiijj".toUpperCase();
        HashMap<Character, Integer> alpha = new HashMap<>();

        for(char c = 'A'; c <'Z'; c++) {
            alpha.put(c,0);
        }

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            boolean isAlphabetB = isAlpha.isAlphabet(c);
            if(isAlphabetB) {
                alpha.put(c, alpha.get(c)+1);
            }
        }

        System.out.println(alpha);



    }
}
