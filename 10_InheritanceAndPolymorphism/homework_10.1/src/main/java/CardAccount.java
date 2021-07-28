public class CardAccount extends BankAccount {

    @Override
    public boolean take(double amountToTake) {

        if (amountToTake * 1.01 <= bill){

            bill -= amountToTake * 1.01;
            return true;
        }else {

            return false;
        }
    }
}