package class_221018.Algorithms_221018;

public class SquareStar {

    private int length = 0;

    public SquareStar(int n) {
        this.length = n;
    }

    void printStar() {
        for (int i = 0; i <this.length ; i++) {
            for(int j = 0; j<this.length; j++){
                System.out.printf("*");
            }
            System.out.println();
        }

    }

    void printStar2() {
        for (int i = 0; i <this.length ; i++) {
            System.out.println("*".repeat(this.length));
        }

    }


    public static void main(String[] args) {
        SquareStar ss = new SquareStar(5);
        ss.printStar2();
    }
}
