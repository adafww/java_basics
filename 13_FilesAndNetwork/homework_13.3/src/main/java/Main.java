import java.text.DecimalFormat;

public class Main {
    private static final String DATA_FILE = "src/main/resources/movementList.csv";

    public static void main(String[] args) {
        Movements movements = new Movements(DATA_FILE);
        System.out.println("Сумма расходов: " + new DecimalFormat("#0.00").format(movements.getExpenseSum()));
        System.out.println("Сумма доходов: " + new DecimalFormat("#0.00").format(movements.getIncomeSum()));
        movements.getOrgExp();
    }
}
