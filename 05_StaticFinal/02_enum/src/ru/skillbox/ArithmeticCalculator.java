package ru.skillbox;

public class ArithmeticCalculator {

    private double a, b, result;

    public ArithmeticCalculator(double a, double b){
        this.a = a;
        this.b = b;
    }

    public void calculate(Operation type){

        if (type == Operation.ADD) {
            result = a + b;
        }

        if (type == Operation.SUBTRACT) {
            result = a - b;
        }

        if (type == Operation.MULTIPLY) {
            result = a * b;
        }
        System.out.println("Result(" + type.toString() + "): " + result);
    }
}
