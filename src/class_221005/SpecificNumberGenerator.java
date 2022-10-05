package class_221005;

public class SpecificNumberGenerator implements NumberGenerator {
    @Override
    public int generate(int num) {
        return 2000 * num;
    }
}
