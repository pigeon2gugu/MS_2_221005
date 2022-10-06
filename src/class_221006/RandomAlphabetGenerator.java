package class_221006;

public class RandomAlphabetGenerator implements AlphabetGenerator{

    @Override
    public int generate(int num) {
        return (int) (Math.random()*num);
    }
}
