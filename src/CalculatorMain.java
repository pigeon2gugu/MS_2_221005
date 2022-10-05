public class CalculatorMain {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        int a = 10;
        int b = 20;

        calculator.plus(a, b);
        calculator.minus(a, b);
        calculator.multiple(a, b);
        calculator.divide(a, b);

    }
}

