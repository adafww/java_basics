public abstract class Client {

    private double bill = 0;
    protected final static double DELTAONE = 1.01;
    protected final static double DELTATWO = 1.005;
    protected final static double DELTATHREE = 0.99;
    protected final static double DELTAFOUR = 0.995;
    protected final static double DELTAFIVE = 1000;

    protected double getAmount() {

        return bill;
    }

    public void getInfo() {

        System.out.println("На счету: " + getAmount());
    }

    protected void put(double amountToPut) {

        if (amountToPut > 0){

            bill += amountToPut;
        }
    }

    protected void take(double amountToTake) {

        if (amountToTake <= bill){

            bill -= amountToTake;
        }
    }
}
