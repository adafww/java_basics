public class TopManager extends Staff {

    private static final int MIN_INCOME = 10000000;
    private static final double MULTI = 1.5;
    private Company company;

    public TopManager(int salary, Company company){

        super(salary);
        setCompany(company);
    }
    @Override
    public int getMonthSalary() {

        int salary = super.getMonthSalary();
        if(company.getIncome() > MIN_INCOME){

            return (int) (salary + salary * MULTI);
        }
        return salary;
    }

    @Override
    public void setCompany(Company company) {

        this.company = company;
    }
}
