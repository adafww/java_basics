import java.util.Comparator;

public class IdStaff implements Comparator<Staff> {

    @Override
    public int compare(Staff o1, Staff o2){

        return o1.identificationNumber() - o2.identificationNumber();
    }
}
