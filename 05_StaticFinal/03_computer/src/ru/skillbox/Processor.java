package ru.skillbox;

public class Processor {

    private final double frequency;
    private final int numberOfCPUСores;
    private final String vendorCPU;
    private final double weightCPU;

    public Processor(double frequency, int numberOfCPUСores, String vendorCPU, double weightCPU) {
        this.frequency = frequency;
        this.numberOfCPUСores = numberOfCPUСores;
        this.vendorCPU = vendorCPU;
        this.weightCPU = weightCPU;
    }

    public double getFrequency() {
        return frequency;
    }

    public int getNumberOfCPUСores() {
        return numberOfCPUСores;
    }

    public String getVendorCPU() {
        return vendorCPU;
    }

    public double getWeightCPU() {
        return weightCPU;
    }
}
