
public class Operator extends Staff{

    private int identificationNumber = 10000 + (int) (Math.random() * 99999);
    private int salaryOperator = 50000 + (int) (Math.random() * 80000);
    private String nameOperator;

    Operator(String name){

        this.nameOperator = name;
    }

    @Override
    public int identificationNumber(){

        return identificationNumber;
    }

    @Override
    public String getPosition(){

        return "Operator";
    }

    @Override
    public int getMonthSalary() {

        return salaryOperator;
    }

    @Override
    public String getName(){

        return this.nameOperator;
    }
}
