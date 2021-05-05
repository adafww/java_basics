package ru.skillbox;

public class Cargo {

    private final double volume;
    private final double width;
    private final double height;
    private final double length;
    private final double weight;
    private final String registrationNumber;
    private final String deliveryAddress;
    private final boolean overturn;
    private final boolean fragile;

    public Cargo(
            double width,
            double height,
            double length,
            double weight,
            String registrationNumber,
            String deliveryAddress,
            boolean overturn,
            boolean fragile
    ) {
        this.weight = weight;
        this.registrationNumber = registrationNumber;
        this.deliveryAddress = deliveryAddress;
        this.overturn = overturn;
        this.fragile = fragile;
        Dimensions dimensions = new Dimensions(width, height, length);
        this.volume = dimensions.getVolume();
        this.width = dimensions.getWidth();
        this.height = dimensions.getHeight();
        this.length = dimensions.getLength();
    }

    public Cargo setDeliveryAddress(String deliveryAddress)
    {
        return new Cargo(
                width,
                height,
                length,
                weight,
                registrationNumber,
                deliveryAddress,
                overturn,
                fragile);
    }

    public Cargo setVolume(double width, double height, double length)
    {
        return new Cargo(
                width,
                height,
                length,
                weight,
                registrationNumber,
                deliveryAddress,
                overturn,
                fragile
        );
    }

    public Cargo setWeight(double weight)
    {
        return new Cargo(
                width,
                height,
                length,
                weight,
                registrationNumber,
                deliveryAddress,
                overturn,
                fragile
        );
    }

    public double getDimensions() {
        return volume;
    }

    public String getAll(){
        return
                "Width: " + width + "\n" +
                "Height: " + height + "\n" +
                "Length: " + length + "\n" +
                "Weight: " + weight + "\n" +
                "RegistrationNumber: " + registrationNumber + "\n" +
                "DeliveryAddress: " + deliveryAddress + "\n" +
                "Overturn: " + overturn + "\n" +
                "Fragile: " + fragile;
    }

    public double getWeight() {
        return weight;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public boolean isOverturn() {
        return overturn;
    }

    public boolean isFragile() {
        return fragile;
    }

}
