import java.util.*;

public class Company {

    HashMap<String, Staff> staff = new HashMap<>();

    int budget = 5000000 + (int) (Math.random() * 15000000);

    List<Employee> getTopSalaryStaff(int count){

        return new ArrayList<>();
    }

    List<Employee> getLowestSalaryStaff(int count){

        return new ArrayList<>();
    }

    public void hire(StaffEnum type){

        if(StaffEnum.MANAGER == type){

            String name = nameGenerator();

            staff.put(name, new Manager(name));
        }else if (StaffEnum.TOPMANAGER == type){

            String name = nameGenerator();

            staff.put(name, new TopManager(name, budget));

        }else if(StaffEnum.OPERATOR == type){

            String name = nameGenerator();

            staff.put(name, new Operator(name));
        }

    }

    public void hireAll(){

        int topManager = 10;
        int manager = 80;
        int operator = 180;

        for(int i = 0; i < manager; i++){

            String name = nameGenerator();

            staff.put(name, new Manager(name));
        }

        for(int i = 0; i < topManager; i++){

            String name = nameGenerator();

            staff.put(name, new TopManager(name, budget));
        }

        for(int i = 0; i < operator; i++){

            String name = nameGenerator();

            staff.put(name, new Operator(name));
        }
    }

    public void fire(String name){

        if(staff.containsKey(name)){

            staff.remove(name);
            System.out.println("Работник уволен");
        }else {

            System.out.println("Работник не найден");
        }
    }

    public void getStaffInfo(String name){

        if(staff.containsKey(name)){

            System.out.println("Name: " + name + "\n" + "Position: " + staff.get(name).getPosition() + "\n" + "Salary: " + staff.get(name).getMonthSalary());
        }else {

            System.out.println("Работник не найден");
        }

    }

    public void getIncome(){

        System.out.println("Доход компании: " + budget);

    }

    private String nameGenerator(){

        final int A = 0;
        final int B = 9;
        String[] staffFirstName = {"Alexey ", "Alexander ", "Roman ", "Dmitry ", "Michael ", "Pavel ", "Gregory ", "Sergey ", "Oleg ", "Denis "};
        String[] staffLastName = {"Vladimirov", "Ivanov", "Vasil'ev", "Sergeev", "Petrov", "Alexeev", "Antonov", "Travin", "Marinov", "Olegov"};

        return staffFirstName[A + (int) (Math.random() * B)] + staffLastName[A + (int) (Math.random() * B)];
    }
}
