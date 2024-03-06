package com.practice.ood.LowLevelDesign.arithematic;

public class Client {
    // 2 * (1+7)
    /*
     *       *
     *  2        +
     *         1     7
     *
     * */
    public static void main(String[] args) {
        ArithmeticExpression two = new Number(2);
        ArithmeticExpression one = new Number(1);
        ArithmeticExpression seven  = new Number(7);
        ArithmeticExpression addExpression = new Expression(one,seven,Operation.ADD);
        ArithmeticExpression parentExpression = new Expression(two,addExpression,Operation.MULTIPLY);
        System.out.println(parentExpression.evaluate());
    }
}
