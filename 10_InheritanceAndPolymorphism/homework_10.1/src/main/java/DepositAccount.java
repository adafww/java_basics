import java.time.LocalDate;
public class DepositAccount extends BankAccount {

    LocalDate lastIncome;
    LocalDate lastOutcome;

    public void put(double amountToPut) {

        if (amountToPut > 0){

            bill += amountToPut;
            lastIncome = LocalDate.now();
        }

    }

    public void take(double amountToTake) {

        lastOutcome = LocalDate.now();
        lastOutcome.minusMonths(1);
        if (lastIncome.isBefore(lastOutcome) && amountToTake <= bill){

            bill -= amountToTake;
        }
    }
}