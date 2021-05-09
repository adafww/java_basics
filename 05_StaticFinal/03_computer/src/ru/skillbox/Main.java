package ru.skillbox;

public class Main {

    public static void main(String[] args) {

        Computer vasyaslaptop = new Computer(
                "Asus",
                "506ii",
                new Processor(
                        2.9,
                        8,
                        "AMD Ryzen 7",
                        113),
                new RAM(
                        TypeRAM.DDR4,
                        16,
                        54),
                new HDD(
                        TypeHDD.SSD,
                        512,
                        87),
                new Display(
                        15.6,
                        TypeDisplay.IPS,
                        324),
                new Keyboard(
                        TypeKeyboard.MEMBRANE,
                        true,
                        437));

        Computer petyaslaptop = new Computer(
                "Huawei",
                "MateBook D 14",
                new Processor(
                        1.6,
                        4,
                        "Intel i5",
                        96),
                new RAM(
                        TypeRAM.DDR4,
                        8,
                        39),
                new HDD(
                        TypeHDD.SSD,
                        512,
                        88),
                new Display(
                        14,
                        TypeDisplay.IPS,
                        298),
                new Keyboard(
                        TypeKeyboard.MEMBRANE,
                        true,
                        414));

        Computer katyaslaptop = new Computer(
                "Acer",
                "Nitro 5",
                new Processor(
                        3,
                        8,
                        "AMD Ryzen 5",
                        112),
                new RAM(
                        TypeRAM.DDR4,
                        8,
                        30),
                new HDD(
                        TypeHDD.SSD,
                        256,
                        87),
                new Display(
                        15.6,
                        TypeDisplay.IPS,
                        302),
                new Keyboard(
                        TypeKeyboard.MEMBRANE,
                        false,
                        357));

        System.out.println(vasyaslaptop.toString());
        System.out.println(petyaslaptop.toString());
        System.out.println(katyaslaptop.toString());

    }




}
