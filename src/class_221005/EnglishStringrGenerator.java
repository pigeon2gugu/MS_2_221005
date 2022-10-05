package class_221005;

public class EnglishStringrGenerator implements StringGenerator {

    @Override
    public String generate(int num) {
        if(num%2 == 0) {
            return "Even";
        } else {
            return "Odd";
        }
    }
}
