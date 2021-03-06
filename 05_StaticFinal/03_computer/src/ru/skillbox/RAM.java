package ru.skillbox;

public class RAM {

    private final double volumeRAM;
    private final double weightRAM;
    private final TypeRAM type;

    public RAM(TypeRAM type, double volumeRAM, double weightRAM) {
        this.type = type;
        this.volumeRAM = volumeRAM;
        this.weightRAM = weightRAM;
    }

    public String toString(){
        return "RAM:\n" +
               "   Type - " + getType() + "\n" +
               "   Volume(GB) - " + getVolumeRAM() + "\n" +
               "   Weight(gr) - " + getWeightRAM() + "\n";
    }

    public double getVolumeRAM() {
        return volumeRAM;
    }

    public double getWeightRAM() {
        return weightRAM;
    }

    public TypeRAM getType() {
        return type;
    }
}
