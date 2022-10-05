public class SwapExercise {
    private int a = 10;
    private int b = 20;

    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        int temp = a;
        a = b;
        b= temp;

        System.out.printf("a : %d b : %d", a, b);
    }
}
