package class_221018.Algorithms_221018;

public class RectangleStar {

    private int width = 0;
    private int height = 0;

    public RectangleStar(int x, int y) {
        this.width = x;
        this.height = y;
    }

    void printStar() {
        for (int i = 0; i <this.height ; i++) {
            for(int j = 0; j<this.width; j++){
                System.out.printf("*");
            }
            System.out.println();
        }

    }

    void printStar2() {
        for (int i = 0; i <this.height ; i++) {
            System.out.println("*".repeat(this.width));
        }

    }


    public static void main(String[] args) {
        RectangleStar ss = new RectangleStar(3,4);
        ss.printStar();
    }
}
