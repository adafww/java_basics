public class CardAccount extends BankAccount {

    @Override
    public boolean take(double amountToTake) {

        if (amountToTake <= bill){

            bill -= amountToTake * 1.01;
            return true;
        }else {

            return false;
        }
    }
}