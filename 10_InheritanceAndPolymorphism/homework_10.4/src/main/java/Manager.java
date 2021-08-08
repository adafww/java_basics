
public class Manager extends Staff{

    private int salaryManager = 75000;
    public final int salary = (int) (salaryManager + (115000 + (int) (Math.random() * 140000) * 0.05));
    @Override
    public String getPosition(){

        return "Manager";
    }

    @Override
    public int getMonthSalary() {

        return salary;
    }
}
