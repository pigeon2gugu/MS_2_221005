package class_221005;
public class CalculatorRandom2 {
    // NumberGenerator 사용
    NumberGenerator numberGenerator;

    public CalculatorRandom2(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void plus() {
        System.out.println(10 + numberGenerator.generate(10));
    }

}

