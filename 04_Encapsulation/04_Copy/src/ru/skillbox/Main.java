package ru.skillbox;

public class Main {

    public static void main(String[] args) {

        System.out.println("====new====");
        Cargo cargo = new Cargo(
                new Dimensions(100,140,200, 500),
                "рп342е",
                "Парковая 10",
                true,
                false
        );
        System.out.println(cargo.getAll());
        System.out.println("====new(copy)====");
        Cargo changedCargo = cargo
        .setDeliveryAddress("Parkovaya 10")
        .setWeight(400)
        .setVolume(400,200, 120);
        System.out.println(changedCargo.getAll());
    }
}
