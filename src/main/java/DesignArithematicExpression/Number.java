package DesignArithematicExpression;

public class Number implements ArithmeticExpression{
    private int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public int evaluate() {
        return this.number;
    }
}
