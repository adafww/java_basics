package ru.skillbox;

public class Computer {

    private final String vendor;
    private final String name;
    private final Processor processor;
    private final RAM ram;
    private final HDD hdd;
    private final Display display;
    private final Keyboard keyboard;

    public Computer(
            String vendor,
            String name,
            Processor processor,
            RAM ram,
            HDD hdd,
            Display display,
            Keyboard keyboard
    ){
        this.vendor = vendor;
        this.name = name;
        this.processor = processor;
        this.ram = ram;
        this.hdd = hdd;
        this.display = display;
        this.keyboard = keyboard;
    }

    public double getComponentsWeight(){
        return processor.getWeightCPU() +
                ram.getWeightRAM() +
                hdd.getWeightHDD() +
                display.getWeightDisplay() +
                keyboard.getWeightKeyboard();
    }
    public String toString(){
        return  "Vendor: " + vendor + "\n" +
                "Name: " + name + "\n" +
                "Processor:\n" +
                "   Frequency(GHz) - " + processor.getFrequency() + "\n" +
                "   Number Of CPU Сores - " + processor.getNumberOfCPUСores() + "\n" +
                "   Vendor - " + processor.getVendorCPU() + "\n" +
                "   Weight(gr) - " + processor.getWeightCPU() + "\n" +
                "RAM:\n" +
                "   Type - " + ram.getType() + "\n" +
                "   Volume(GB) - " + ram.getVolumeRAM() + "\n" +
                "   Weight(gr) - " + ram.getWeightRAM() + "\n" +
                "HDD:\n" +
                "   Type — HDD, SSD - " + hdd.getType() + "\n" +
                "   Volume(GB) - " + hdd.getVolumeHDD() + "\n" +
                "   Weight(gr) - " + hdd.getWeightHDD() + "\n" +
                "Display:\n" +
                "   Diagonal - " + display.getDiagonal() + "\n" +
                "   Type (IPS, TN, VA) - " + display.getType() + "\n" +
                "   Weight(gr) - " + display.getWeightDisplay() + "\n" +
                "Keyboard:\n" +
                "   Type - " + keyboard.getType() + "\n" +
                "   Backlight - " + keyboard.isBacklight() + "\n" +
                "   Weight(gr) - " + keyboard.getWeightKeyboard() + "\n" +
                "ComponentsWeight(gr) - " + getComponentsWeight() + "\n";
    }
}
