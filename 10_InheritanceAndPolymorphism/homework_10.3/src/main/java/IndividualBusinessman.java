public class IndividualBusinessman extends Client {

    @Override
    public void take(double amountToTake) {

        if (amountToTake <= bill && amountToTake < 1000){

            bill -= amountToTake * 1.01;
        }

        if (amountToTake <= bill && amountToTake >= 1000){

            bill -= amountToTake * 1.005;
        }
    }

    @Override
    public void put(double amountToPut) {

        if (amountToPut > 0 && amountToPut < 1000){

            bill += amountToPut * 0.99;
        }

        if (amountToPut > 0 && amountToPut >= 1000){

            bill += amountToPut * 0.995;
        }
    }
}
