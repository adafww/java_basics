import java.util.Comparator;

public class LowestSalaryStaff implements Comparator<Staff> {

    @Override
    public int compare(Staff o1, Staff o2){

        return o1.getMonthSalary() - o2.getMonthSalary();
    }
}