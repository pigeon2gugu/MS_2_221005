package class_221005;
public class CalculatorRandom2Main {

    public static void main(String[] args) {

        NumberGenerator numberGenerator = new SpecificNumberGenerator();
        CalculatorRandom2 calculatorRandom2 = new CalculatorRandom2(numberGenerator, 10);
        calculatorRandom2.plus(30);

        calculatorRandom2 = new CalculatorRandom2(new RandomNumberGenerator());
        calculatorRandom2.plus(30);


    }

}

