import java.time.LocalDate;
public class DepositAccount extends BankAccount {

    LocalDate lastIncome;
    LocalDate lastOutcome;

    @Override
    public void put(double amountToPut) {

        if (amountToPut > 0){

            bill += amountToPut;
            lastIncome = LocalDate.now();
        }
    }

    @Override
    boolean take(double amountToTake) {

        lastOutcome = LocalDate.now();
        lastOutcome.minusMonths(1);
        if (lastIncome.isBefore(lastOutcome) && amountToTake <= bill){

            bill -= amountToTake;
            return true;
        }else {

            return false;
        }
    }
}