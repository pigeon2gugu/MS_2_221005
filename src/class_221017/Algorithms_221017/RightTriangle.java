package class_221017.Algorithms_221017;

public class RightTriangle {

    private String letter;
    public RightTriangle(String n) {
        this.letter = n;
    }

    void printStar(int n) {
        for(int i = 0; i <n; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.printf(this.letter);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        RightTriangle rt = new RightTriangle("!");
        rt.printStar(10);
    }
}
