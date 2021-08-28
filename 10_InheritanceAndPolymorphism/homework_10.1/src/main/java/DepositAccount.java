import java.time.LocalDate;
public class DepositAccount extends BankAccount {

    private LocalDate lastIncome;
    private LocalDate lastOutcome;

    @Override
    boolean put(double amountToPut) {
        if (amountToPut > 0){
            setBill(getBill() + amountToPut);
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
        if (lastIncome.isBefore(lastOutcome) && amountToTake <= getBill()){
            setBill(getBill() - amountToTake);
            return true;
        }else {
            return false;
        }
    }
}