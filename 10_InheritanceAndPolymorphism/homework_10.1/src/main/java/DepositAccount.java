import java.time.LocalDate;
public class DepositAccount extends BankAccount {

    LocalDate lastIncome;
    LocalDate lastOutcome;

    @Override
    boolean put(double amountToPut) {

        if (amountToPut > 0){

            bill += amountToPut;
            lastIncome = LocalDate.now();
            return true;
        } else {

            return false;
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