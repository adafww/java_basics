package ru.skillbox;

public class Product {

    private final String name;

    private final int barCode;
    private int price;
    public Product(String name, int barCode) {
        this.name = name;
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public int getBarCode() {
        return barCode;
    }

    public int getPrice() {
        return price;
    }

}
