package ru.skillbox;

public class Phone {

    private String brand;
    private String model;
    private boolean support5g;

    public Phone(String brand, String model, boolean support5g) {
        this.brand = brand;
        this.model = model;
        this.support5g = support5g;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isSupport5g() {
        return support5g;
    }

    public void setSupport5g(boolean support5g) {
        this.support5g = support5g;
    }
}
