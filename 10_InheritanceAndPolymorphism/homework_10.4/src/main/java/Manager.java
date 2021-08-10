
public class Manager extends Staff{

    private int identificationNumber = 10000 + (int) (Math.random() * 99999);
    private int salaryManager = 75000;
    private String nameManager;
    public final int salary = (int) (salaryManager + (115000 + (int) (Math.random() * 140000) * 0.05));

    public Manager(String name){

        this.nameManager = name;
    }

    @Override
    public int identificationNumber(){

        return identificationNumber;
    }

    @Override
    public String getPosition(){

        return "Manager";
    }

    @Override
    public int getMonthSalary() {

        return salary;
    }

    @Override
    public String getName(){

        return nameManager;
    }
}
