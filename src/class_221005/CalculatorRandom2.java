package class_221005;
public class CalculatorRandom2 {
    // NumberGenerator 사용
    NumberGenerator numberGenerator;
    private int baseNum = 10;

    public CalculatorRandom2(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    //method overloading, baseNum 수정
    public CalculatorRandom2(NumberGenerator numberGenerator, int baseNum) {
        this.numberGenerator = numberGenerator;
        this.baseNum = baseNum;
    }

    public void plus(int num) {
        System.out.println(num + numberGenerator.generate(baseNum));
    }

}

