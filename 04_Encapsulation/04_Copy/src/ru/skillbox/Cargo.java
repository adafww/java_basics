package ru.skillbox;

public class Cargo {

    private final String registrationNumber, deliveryAddress;
    private final boolean overturn, fragile;
    private final Dimensions dimensions;

    public Cargo(

            Dimensions dimensions,
            String registrationNumber,
            String deliveryAddress,
            boolean overturn,
            boolean fragile) {

        this.registrationNumber = registrationNumber;
        this.deliveryAddress = deliveryAddress;
        this.overturn = overturn;
        this.fragile = fragile;
        this.dimensions = dimensions;

    }

    public Cargo setDeliveryAddress(String deliveryAddress)
    {
        return new Cargo(
                dimensions,
                registrationNumber,
                deliveryAddress,
                overturn,
                fragile);
    }

    public Cargo setVolume(double width, double height, double length)
    {
        return new Cargo(
                new Dimensions(width, height, length, dimensions.getWeight()),
                registrationNumber,
                deliveryAddress,
                overturn,
                fragile
        );
    }

    public Cargo setWeight(double weight)
    {
        return new Cargo(
                new Dimensions(dimensions.getWidth(), dimensions.getHeight(), dimensions.getLength(), weight),
                registrationNumber,
                deliveryAddress,
                overturn,
                fragile
        );
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public String getAll(){
        return
                "Dimensions: " + dimensions.toString() + "\n" +
                "RegistrationNumber: " + registrationNumber + "\n" +
                "DeliveryAddress: " + deliveryAddress + "\n" +
                "Overturn: " + overturn + "\n" +
                "Fragile: " + fragile;
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
