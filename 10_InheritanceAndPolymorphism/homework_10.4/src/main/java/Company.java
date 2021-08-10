import java.util.*;

public class Company {

    private TreeSet<Staff> staff = new TreeSet<>();

    private final int budget = 5000000 + (int) (Math.random() * 15000000);

    private Comparator comparatorTopSalaryStaff = new TopSalaryStaff();
    private Comparator comparatorLowestSalaryStaff = new LowestSalaryStaff();
    private Comparator comparatorIdStaff = new IdStaff();

    List<Staff> getTopSalaryStaff(int count){

        ArrayList<Staff> staffToList = new ArrayList<>(staff);

        Collections.sort(staffToList, comparatorTopSalaryStaff);

        staffToList.subList(count, staffToList.size()).clear();

        return new ArrayList<>(staffToList);
    }

    List<Staff> getLowestSalaryStaff(int count){

        ArrayList<Staff> staffToList = new ArrayList<>(staff);

        Collections.sort(staffToList, comparatorLowestSalaryStaff);

        staffToList.subList(count, staffToList.size()).clear();

        return new ArrayList<>(staffToList);
    }

    public void hire(StaffEnum type, String name){

        if(StaffEnum.MANAGER == type){

            staff.add(new Manager(name));
        }else if (StaffEnum.TOPMANAGER == type){

            staff.add(new TopManager(name, budget));

        }else if(StaffEnum.OPERATOR == type){

            staff.add(new Operator(name));
        }

    }

    public void hireAll(){

        int topManager = 10;
        int manager = 80;
        int operator = 180;

        for(int i = 0; i < manager; i++){

            staff.add(new Manager(nameGenerator()));
        }

        for(int i = 0; i < topManager; i++){

            staff.add(new TopManager(nameGenerator(), budget));
        }

        for(int i = 0; i < operator; i++){

            staff.add(new Operator(nameGenerator()));
        }
    }

    public void fire(String name){

        for (Staff i: staff){

            if(i.getName().equals(name)){

                staff.remove(i);
                System.out.println("Работник уволен");
            }
        }
    }

    public void halfFire(){

        ArrayList<Staff> staffToListForHalfDelete = new ArrayList<>(staff);

        Collections.sort(staffToListForHalfDelete, comparatorIdStaff);

        staffToListForHalfDelete.subList(staffToListForHalfDelete.size() / 2, staffToListForHalfDelete.size()).clear();

        TreeSet<Staff> staffAfterDelete = new TreeSet<>(staffToListForHalfDelete);

        staff = staffAfterDelete;
    }

    public void getStaffInfo(String name){

        for (Staff i: staff){

            if(i.getName().equals(name)){

                System.out.println("Name: " + name + "\n"
                        + "Position: " + i.getPosition() + "\n"
                        + "Salary: " + i.getMonthSalary() + "р." + "\n"
                        + "id: " + i.identificationNumber());
            }
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
