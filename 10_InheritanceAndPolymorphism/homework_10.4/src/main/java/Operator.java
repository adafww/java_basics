
public class Operator extends Staff{

    private int salaryOperator = 50000 + (int) (Math.random() * 80000);

    @Override
    public String getPosition(){

        return "Operator";
    }

    @Override
    public int getMonthSalary() {

        return salaryOperator;
    }
}
