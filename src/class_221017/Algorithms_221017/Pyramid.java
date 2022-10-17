package class_221017.Algorithms_221017;

public class Pyramid {

    private String letter = "*";

    public Pyramid() {

    }
    public Pyramid(String n) {
        this.letter = n;
    }

    void printStar(int n) {
        for(int i = 0; i <n; i++) {
            for (int j = n-i-1; j >0 ; j--) {
                System.out.printf(" ");
            }
            for(int j = 0; j < 2*i+1; j++) {
                System.out.printf(this.letter);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Pyramid rt = new Pyramid("*");
        rt.printStar(4);
    }
}
