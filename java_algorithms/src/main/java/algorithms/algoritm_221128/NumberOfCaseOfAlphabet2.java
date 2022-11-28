package algorithms.algoritm_221128;


//재귀 사용
public class NumberOfCaseOfAlphabet2 {

    //1단계
    public void solution1(char c) {
        if (c > 'Z') return;
        System.out.println(c);
        solution1((char) (c+1));
    }


    //2단계
    public static void solution2(int len, String prefix) {

        if (prefix.length() > len-1 ) {
            System.out.println(prefix);
            return;
        }

        for(char i = 'A'; i <= 'Z'; i++) {
            solution2(len, prefix+i);
        }


    }

    public static void main(String[] args) {
        NumberOfCaseOfAlphabet2 nca = new NumberOfCaseOfAlphabet2();
        nca.solution1('A');
        nca.solution2(3,"");
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
