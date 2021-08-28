public class Manager extends Staff{

    private int sales = (int) (Math.random() * (140000 - 115000) + 115000);

    public int getSales(){

        return sales;
    }

    public Manager(int salary){

        super(salary);
    }

    @Override
    public int getMonthSalary() {

        return (int) (super.getMonthSalary() + 0.05 * sales);
    }
}
