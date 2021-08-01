public class IndividualBusinessman extends Client {

    @Override
    public void take(double amountToTake) {

        if (amountToTake < DELTAFIVE){

            super.take(amountToTake * DELTAONE);
        }

        if (amountToTake >= DELTAFIVE){

            super.take(amountToTake * DELTATWO);
        }
    }

    @Override
    public void put(double amountToPut) {

        if (amountToPut < DELTAFIVE){

            super.put(amountToPut * DELTATHREE);
        }

        if (amountToPut >= DELTAFIVE){

            super.put(amountToPut * DELTAFOUR);
        }
    }
}
