package class_221005;
public class StatementMaker {

    private int num1;
    private int num2;

    private StringGenerator stringGenerator;


    public StatementMaker(StringGenerator stringGenerator, int num1, int num2) {
        this.stringGenerator = stringGenerator;
        this.num1 = num1;
        this.num2 = num2;
    }

    public void run() {

        System.out.println(stringGenerator.generate(num1)+"+"+stringGenerator.generate(num2)+"="+stringGenerator.generate(num1+num2));
    }


}

