package class_221005;
public class CalculatorRandom {

    private int a;
    private int b;

    public int getRandomNum() {
        return (int) (Math.random() * 10);
    }

    public CalculatorRandom(int a) {
        this.a = a;
        this.b = getRandomNum();
    }

    public void plus() {
        System.out.println(a + b);
    }

    public void minus() {
        System.out.println(a - b);
    }

    public void multiple() {
        System.out.println(a * b);
    }


    public void divide() {

        if(b == 0) {
            System.out.println("랜덤하게 생성된 숫자가 0입니다.");
        } else {
            float result = (float)a/b;
            System.out.println(result);
        }

    }

    /*
    public void divide() {
        try {
            double result = (double) a / b;
            if(Double.isFinite(result) || Double.isNaN((result))){
            throw new ArithmeticException();
        }
            System.out.println(result);
        }  catch (ArithmeticException e) {
                System.out.printf("랜덤하게 생성된 숫자가 0입니다.");
        }

    }
    */

}

