import java.util.*;

public class Company {

    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees(){

        return new ArrayList<>(employees);
    }

    public void hire(Employee employee){

        employee.setCompany(this);
        employees.add(employee);
    }

    public void hireAll(List<Employee> employees){

        for (Employee e : employees){

            hire(e);
        }
    }

    public void fire(Employee employee){

        employee.setCompany(null);
        employees.remove(employee);
    }

    public List<Employee> getTopSalaryStaff(int count){

        return getList(count, Comparator.reverseOrder());
    }
    public List<Employee> getLowestSalaryStaff(int count){

        return getList(count, Comparator.naturalOrder());
    }

    private List<Employee> getList(int count, Comparator<Employee> cmp){

        if(count <= 0){

            System.out.println("Ошибка");
            return Collections.emptyList();
        }
        if (count > employees.size()){

            count = employees.size();
        }
        employees.sort(cmp);
        return new ArrayList<>(employees.subList(0, count));
    }

    public int getIncome(){

        int income = 0;
        for(Employee e : employees){

            if(e instanceof Manager){

                income += ((Manager) e).getSales();
            }
        }
        return income;
    }
}
