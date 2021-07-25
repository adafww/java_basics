public abstract class Client {

    double bill = 0;

    public double getAmount() {

        return bill;
    }

    public void put(double amountToPut) {

        if (amountToPut > 0){

            bill += amountToPut;
        }
    }

    public void take(double amountToTake) {

        if (amountToTake <= bill){

            bill -= amountToTake;
        }
    }
}
