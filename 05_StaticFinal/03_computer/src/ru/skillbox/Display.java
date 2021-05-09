package ru.skillbox;

public class Display {

    private final double diagonal;
    private final TypeDisplay type;
    private final double weightDisplay;

    public Display(double diagonal, TypeDisplay type, double weightDisplay) {
        this.diagonal = diagonal;
        this.type = type;
        this.weightDisplay = weightDisplay;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public TypeDisplay getType() {
        return type;
    }

    public double getWeightDisplay() {
        return weightDisplay;
    }
}
