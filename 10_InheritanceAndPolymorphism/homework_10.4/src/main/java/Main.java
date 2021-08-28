import java.util.*;

public class Main {

    public static void main(String[] args) {

        Company company = new Company();

        for (int i = 0; i < 180; i++){

            company.hire(new Operator(30000));
        }

        List<Employee> workers = new ArrayList<>();

        for (int i = 0; i < 80; i++){

            workers.add(new Manager(40000));
            if(i % 8 == 0){

                workers.add(new TopManager(50000, company));
            }
        }

        company.hireAll(workers);

        printEmpl(company);

        System.out.println("");

        List<Employee> employees = company.getEmployees();

        for (int i = 0; i < 135; i++){

            company.fire(employees.get(i));
        }

        printEmpl(company);
    }

    private static void printEmpl(Company company) {

        List<Employee> topSalaryStaff = company.getTopSalaryStaff(10);

        for (Employee e : topSalaryStaff){

            System.out.println(e.getMonthSalary());
        }

        System.out.println("");

        List<Employee> lowestSalaryStaff = company.getLowestSalaryStaff(10);

        for (Employee e : lowestSalaryStaff){

            System.out.println(e.getMonthSalary());
        }
    }
}
