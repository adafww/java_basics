public class LegalPerson extends Client {

    @Override
    public void take(double amountToTake) {

        super.take(amountToTake * DELTAONE);
    }
}
