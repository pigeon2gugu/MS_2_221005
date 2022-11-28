package algorithms.algoritm_221128;


public class NumberOfCaseOfAlphabet {

    //1단계
    public void solution1() {
        for(int i = 0; i < 26; i ++) {
            Character alpha = (char) (i+65);
            System.out.println(alpha);
        }
    }


    //2단계
    public void solution2() {
        for(int i = 0; i < 26; i ++) {
            Character alpha = (char) (i+'A');
            for(int j = 0; j<26; j++) {
                Character alpha2 = (char) (j+'A');
                String alphaMerge = String.valueOf(alpha) + String.valueOf(alpha2);
                System.out.println(alphaMerge);
            }
        }
    }

    public static void main(String[] args) {
        NumberOfCaseOfAlphabet nca = new NumberOfCaseOfAlphabet();
        nca.solution1();
        nca.solution2();
    }

}

/*
public class CombinationOfAlphabet {
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        for (int i = 0; i < 26; i++) {
            System.out.println(alphabet.charAt(i));
        }
    }
}*/
