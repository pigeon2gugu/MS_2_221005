package class_221006;

import java.util.HashSet;
import java.util.Set;

//랜덤 넘버 50개 생성 후 중복되는 넘버 제거
public class SetExerciseWithoutDuplicateNumber {
    public static void main(String[] args) {

        Set<Integer> noDuplicateNumber = new HashSet<>();

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        for(int i = 0 ; i <50; i++) {
            int r = randomNumberGenerator.generate(10);
            noDuplicateNumber.add(r);
        }

        System.out.println(noDuplicateNumber);
        System.out.println(noDuplicateNumber.size());
    }
}
