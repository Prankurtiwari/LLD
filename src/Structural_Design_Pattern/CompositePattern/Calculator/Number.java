package Structural_Design_Pattern.CompositePattern.Calculator;

public class Number implements ArithmeticExpression {

    int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public int evaluate() {
        System.out.println("Number is : " + number);
        return number;
    }
}
