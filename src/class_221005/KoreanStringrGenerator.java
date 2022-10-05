package class_221005;

public class KoreanStringrGenerator implements StringGenerator {

    @Override
    public String generate(int num) {
        if(num%2 == 0) {
            return "짝수";
        } else {
            return "홀수";
        }
    }
}
