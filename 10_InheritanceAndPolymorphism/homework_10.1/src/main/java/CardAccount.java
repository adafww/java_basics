public class CardAccount extends BankAccount {

    @Override
    public boolean take(double amountToTake) {

        return super.take(amountToTake * 1.01);

    }
}