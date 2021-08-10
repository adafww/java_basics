import java.util.Comparator;

public class TopSalaryStaff implements Comparator<Staff> {

    @Override
    public int compare(Staff o1, Staff o2){

        return o2.getMonthSalary() - o1.getMonthSalary();
    }
}
