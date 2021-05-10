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

    public String toString(){
        return "Display:\n" +
               "   Diagonal - " + getDiagonal() + "\n" +
               "   Type (IPS, TN, VA) - " + getType() + "\n" +
               "   Weight(gr) - " + getWeightDisplay() + "\n";
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
