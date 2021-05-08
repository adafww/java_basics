package ru.skillbox;

public class Main {

    public static void main(String[] args) {

        ArithmeticCalculator vasyasCalculator = new ArithmeticCalculator(54, 85);

        vasyasCalculator.calculate(Operation.ADD);
        vasyasCalculator.calculate(Operation.SUBTRACT);
        vasyasCalculator.calculate(Operation.MULTIPLY);
    }
}
