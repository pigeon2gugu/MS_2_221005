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
public class PrintAtoZCombination4 {

   public static final String chars ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   public static void printAlphabet(String prefix, int depth) {
       if (prefix.length() > depth) return;
       System.out.println(prefix);

       for (int i = 0; i < chars.length(); i++) {
           printAlphabet(prefix + chars.charAt(i), depth);
       }
   }

   public static void main(String[] args) {
       printAlphabet("", 2);
   }
}
}*/
