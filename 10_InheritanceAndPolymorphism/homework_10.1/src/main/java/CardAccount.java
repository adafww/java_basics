public class CardAccount extends BankAccount {

    public void take(double amountToTake) {

        if (amountToTake <= bill){

            bill -= amountToTake * 1.01;
        }
    }
}