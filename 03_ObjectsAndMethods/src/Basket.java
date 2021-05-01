public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int totalWeight = 0;
    private int limit;

    public Basket() {

        this (1000000);
    }

    public Basket(int limit) {
        increaseCount(0);
        items = "Список товаров:";
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items += items;
        this.totalPrice = totalPrice;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count1) { Basket.count += count1; }

    public void add(String name, int price) {
        add(name, price, 0, 1);
    }

    public void add(String name, int price, int weight) { add(name, price, weight, 1); }

    public void add(String name, int price, int weight, int count1) {

        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count1 * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        if(weight == 0) {
            items = items + "\n" + name + " - " +
                    count1 + " шт. - " + price * count;
        }else {
            items = items + "\n" + name + " - " +
                    count1 + " шт. - " + weight + " гр. - " + price;
            totalPrice = totalPrice + count * price;
            totalWeight = totalWeight + count * weight;
        }
    }

    public void clear(){
            items = "";
        }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
            System.out.println(getCount());
        } else {
            System.out.println(items);
            System.out.println("Общий вес: " + totalWeight);
        }
    }

}
