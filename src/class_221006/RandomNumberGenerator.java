package class_221006;

public class RandomNumberGenerator implements NumberGenerator{

    @Override
    public int generate(int num) {
        return (int) (Math.random()*100);
    }
}
