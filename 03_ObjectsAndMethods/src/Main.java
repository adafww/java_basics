public class Main {

    public static void main(String[] args) {
        System.out.println("====Первое задание====");
        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.add("bread", 45,  100, 2);
        basket.print("Корзина");
        basket.clear();
        basket.print("Чистка корзины");
        System.out.println("====Второе задание====");
        Arithmetic arithmetic = new Arithmetic();
        arithmetic.addition(4,6);
        arithmetic.subtraction(4,6);
        arithmetic.multiplication (4,6);
        arithmetic.middle (4,6);
        arithmetic.max(24,6);
        arithmetic.min(24,6);
        System.out.println("====Третье задание====");
        Printer printer = new Printer();
        printer.append("Текст");
        printer.append("Три записи", "Дневник");
        printer.append("Три записи", "Дневник", 2);
        printer.print();
        printer.getDocumentCount();
        printer.getPagesCount();
        printer.append("Три записи", "Дневник", 3);
        printer.getDocumentCount();
        printer.getPagesCount();
        printer.getTotalPageCount();
        printer.print();
        printer.getDocumentCount();
        printer.getPagesCount();
        printer.getTotalPageCount();
        printer.clear();
        printer.print();

    }

}
