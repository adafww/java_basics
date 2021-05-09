package ru.skillbox;

public class HDD {

    private final double volumeHDD;
    private final double weightHDD;
    private final TypeHDD type;

    public HDD(TypeHDD type, double volumeHDD, double weightHDD) {
        this.type = type;
        this.volumeHDD = volumeHDD;
        this.weightHDD = weightHDD;
    }

    public double getVolumeHDD() {
        return volumeHDD;
    }

    public double getWeightHDD() {
        return weightHDD;
    }

    public TypeHDD getType() {
        return type;
    }
}
