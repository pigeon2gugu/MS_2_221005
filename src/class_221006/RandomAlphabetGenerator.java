package class_221006;

public class RandomAlphabetGenerator implements AlphabetGenerator{

    @Override
    public char generate() {
        int r = (int) (Math.random()*26) + 65;
        return (char)r;
    }
}
