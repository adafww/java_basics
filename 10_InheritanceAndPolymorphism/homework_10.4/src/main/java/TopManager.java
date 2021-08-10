public class TopManager extends Staff {

    private int identificationNumber = 10000 + (int) (Math.random() * 99999);
    private int salaryTopManager = 115000;
    private final int LIMIT = 10000000;
    private int salaryFinal;
    private String nameTopManager;

    public TopManager(String name, int budgetStaff){

        this.nameTopManager = name;

        if(budgetStaff > LIMIT){

            salaryFinal = (int) (salaryTopManager + salaryTopManager * 1.5);
        }else {

            salaryFinal = salaryTopManager;
        }
    }

    @Override
    public int identificationNumber(){

        return identificationNumber;
    }

    @Override
    public String getPosition(){

        return "TopManager";
    }

    @Override
    public int getMonthSalary() {

        return salaryFinal;
    }

    @Override
    public String getName(){

        return this.nameTopManager;
    }
}
