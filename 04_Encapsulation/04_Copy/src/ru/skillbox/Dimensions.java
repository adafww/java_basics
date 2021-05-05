package ru.skillbox;

public class Dimensions {

    private final double width, height, length, weight;

    public Dimensions(double width, double height, double length, double weight) {
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
    }

    public double getVolume(){
        return width * height * length;
    }

    public String toString(){
        return
                "Width: " + width + " " +
                "Height: " + height + " " +
                "Length: " + length + " " +
                "Weight: " + getWeight() + " " +
                "Volume: " + getVolume();
    }

    public double getWeight() { return weight; }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }
}
