package Structural_Design_Pattern.CompositePattern.Calculator;

public class Main {
    public static void main(String[] args) {

        // 2 * (1+7)
        ArithmeticExpression two = new Number(2);

        ArithmeticExpression one = new Number(1);

        ArithmeticExpression seven = new Number(7);

        ArithmeticExpression addExpression = new Expression(one, seven, Operation.ADD);

        ArithmeticExpression multiplyExpression = new Expression(addExpression, two, Operation.MULTIPLY);

        System.out.println(multiplyExpression.evaluate());
    }
}
