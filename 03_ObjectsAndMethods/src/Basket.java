public class Basket {

    private String items = "";
    private static int countBasket = 0;
    private static int totalPrice = 0;
    private static int countItem = 0;
    private static int totalWeight = 0;
    private int limit;

    public Basket() {

        this (1000000);
    }

    public Basket(int limit) {
        increaseCountBasket(1);
        items = "Список товаров:";
        this.limit = limit;
    }

    public static double getMiddlePrice(){
        return totalPrice / countBasket;
    }

    public static int getCountBasket() {

        return countBasket;
    }

    public static int getCountItem() {

        return countItem;
    }

    public static int getPrice(){

        return totalPrice;
    }

    public static int getWeight(){

        return totalWeight;
    }

    public static void increaseCountBasket(int countBasketAdd) {
        countBasket += countBasketAdd;
    }

    public static void increaseCountItem(int countItemAdd) {
        countItem += countItemAdd;
    }

    public static void increasePrice(int countItemAdd, int price) {
        totalPrice += countItemAdd * price;
    }

    public static void increaseWeight(int countItemAdd, int weight) {
        totalWeight += countItemAdd * weight;
    }

    public void add(String name, int price) {

        add(name, price, 0, 1);
    }

    public void add(String name, int price, int weight) {
        add(name, price, weight, 1);
    }

    public void add(String name, int price, int weight, int countItemAdd) {

        increaseCountItem(countItemAdd);
        increasePrice(countItemAdd, price);
        increaseWeight(countItemAdd, weight);
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + countItemAdd * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        if(weight == 0) {
            items = items + "\n" + name + " - " +
                    countItemAdd + " шт. - " + price * countItemAdd;
        }else {
            items = items + "\n" + name + " - " +
                    countItemAdd + " шт. - " + weight + " гр. - цена: " + price;
        }
    }

    public void clear(){
            items = "";
        }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
            System.out.println("Количество товаров: " + getCountItem());
            System.out.println("Общий вес: " + getWeight());
        }
    }

}
