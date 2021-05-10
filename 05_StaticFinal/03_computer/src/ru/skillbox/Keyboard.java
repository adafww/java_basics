package ru.skillbox;

public class Keyboard {

    private final TypeKeyboard type;
    private final boolean Backlight;
    private final double weightKeyboard;

    public Keyboard(TypeKeyboard type, boolean backlight, double weightKeyboard) {
        this.type = type;
        Backlight = backlight;
        this.weightKeyboard = weightKeyboard;
    }

    public String toString(){
        return "Keyboard:\n" +
               "   Type - " + getType() + "\n" +
               "   Backlight - " + isBacklight() + "\n" +
               "   Weight(gr) - " + getWeightKeyboard() + "\n";
    }

    public TypeKeyboard getType() {
        return type;
    }

    public boolean isBacklight() {
        return Backlight;
    }

    public double getWeightKeyboard() {
        return weightKeyboard;
    }
}
