public class LegalPerson extends Client {

    @Override
    public void take(double amountToTake) {

        if (amountToTake <= bill){

            bill -= amountToTake * 1.01;
        }
    }
}
