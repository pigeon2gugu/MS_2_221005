package class_221006;

import java.util.HashSet;
import java.util.Set;

//랜덤 넘버 50개 생성 후 중복되는 넘버 제거
public class SetExerciseWithoutDuplicateAlphabet {
    public static void main(String[] args) {

        Set<Character> noDuplicateAlphabet = new HashSet<>();

        RandomAlphabetGenerator randomAlphabetGenerator = new RandomAlphabetGenerator();

        for(int i = 0 ; i <50; i++) {
            char ch = randomAlphabetGenerator.generate();
            noDuplicateAlphabet.add(ch);
        }

        System.out.println(noDuplicateAlphabet);
        System.out.println(noDuplicateAlphabet.size());
    }
}
