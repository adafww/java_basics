package ru.skillbox;

public class CPU {

    private final double frequency;
    private final int numberOfCPUСores;
    private final String vendorCPU;
    private final double weightCPU;

    public CPU(double frequency, int numberOfCPUСores, String vendorCPU, double weightCPU) {
        this.frequency = frequency;
        this.numberOfCPUСores = numberOfCPUСores;
        this.vendorCPU = vendorCPU;
        this.weightCPU = weightCPU;
    }

    public String toString(){
        return "CPU:\n" +
               "   Frequency(GHz) - " + getFrequency() + "\n" +
               "   Number Of CPU Сores - " + getNumberOfCPUСores() + "\n" +
               "   Vendor - " + getVendorCPU() + "\n" +
               "   Weight(gr) - " + getWeightCPU() + "\n";
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
