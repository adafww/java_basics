public class TopManager extends Staff {

    private int salaryTopManager = 115000;
    private final int LIMIT = 10000000;
    private int salaryFinal = 1231231231;
    private int budget = 5000000 + (int) (Math.random() * 15000000);

    public TopManager(int budgetStaff){

        if(budgetStaff > LIMIT){

            salaryFinal = (int) (salaryTopManager + salaryTopManager * 1.5);
        }else {

            salaryFinal = salaryTopManager;
        }
    }

    @Override
    public String getPosition(){

        return "TopManager";
    }

    @Override
    public int getMonthSalary() {

        return salaryFinal;
    }
}
