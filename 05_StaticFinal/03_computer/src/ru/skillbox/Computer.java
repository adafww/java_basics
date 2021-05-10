package ru.skillbox;

public class Computer {

    private final String vendor;
    private final String name;
    private final CPU cpu;
    private final RAM ram;
    private final HDD hdd;
    private final Display display;
    private final Keyboard keyboard;

    public Computer(
            String vendor,
            String name,
            CPU cpu,
            RAM ram,
            HDD hdd,
            Display display,
            Keyboard keyboard
    ){
        this.vendor = vendor;
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
        this.display = display;
        this.keyboard = keyboard;
    }

    public double getComponentsWeight(){
        return cpu.getWeightCPU() +
                ram.getWeightRAM() +
                hdd.getWeightHDD() +
                display.getWeightDisplay() +
                keyboard.getWeightKeyboard();
    }
    public String toString(){
        return  "Vendor: " + vendor + "\n" +
                "Name: " + name + "\n" +
                cpu.toString() +
                ram.toString() +
                hdd.toString() +
                display.toString() +
                keyboard.toString() +
                "ComponentsWeight(gr) - " + getComponentsWeight() + "\n";
    }
}
