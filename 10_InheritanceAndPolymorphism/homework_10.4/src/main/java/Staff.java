public abstract class Staff implements Employee {

    private int salary;

    public Staff(int salary){

        this.salary = (int) ((Math.random() * salary) + salary);
    }

    @Override
    public int getMonthSalary(){

        return salary;
    }
}
