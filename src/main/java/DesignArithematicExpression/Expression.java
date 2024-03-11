package DesignArithematicExpression;

public class Expression implements ArithmeticExpression{

    ArithmeticExpression a;
    ArithmeticExpression b;
    Operation operation;
    public Expression(ArithmeticExpression a, ArithmeticExpression b, Operation op) {
        this.a = a;
        this.b = b;
        this.operation = op;
    }

    @Override
    public int evaluate() {
        int result = 0;
        switch (this.operation){
            case ADD:
                result = this.a.evaluate() + this.b.evaluate();
                break;
            case DIVIDE:
                result = this.a.evaluate() / this.b.evaluate();
                break;
            case SUBTRACT:
                result = this.a.evaluate() - this.b.evaluate();
                break;
            case MULTIPLY:
                result = this.a.evaluate() * this.b.evaluate();
                break;
        }
        return result;
    }
}
