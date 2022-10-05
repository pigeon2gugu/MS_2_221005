package class_221005;
public class StatementMakerMain {

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 5;

        StringGenerator stringGenerator1 = new KoreanStringrGenerator();
        StringGenerator stringGenerator2 = new EnglishStringrGenerator();

        StatementMaker statementMaker1 = new StatementMaker(stringGenerator1, num1, num2);
        StatementMaker statementMaker2 = new StatementMaker(stringGenerator2, num1, num2);

        statementMaker1.run();
        statementMaker2.run();
    }


}

