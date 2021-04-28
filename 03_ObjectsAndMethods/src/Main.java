public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.add("bread", 45,  100, 2);
        basket.print("Корзина");
        basket.clear();
        basket.print("Чистка корзины");
    }
}
