package ru.skillbox;

public class Main {

    public static void main(String[] args) {

        Cargo cargo = new Cargo(
                100,
                150,
                230,
                500,
                "рп342е",
                "Парковая 10",
                true,
                false
        );
        System.out.println(cargo.getDimensions());
        System.out.println(cargo.getAll());
        cargo.setDeliveryAddress("Parkovaya 10");
        cargo.setWeight(400);
        cargo.setVolume(400,200, 120);
        System.out.println(cargo.getDimensions());
        System.out.println(cargo.getAll());
    }
}
