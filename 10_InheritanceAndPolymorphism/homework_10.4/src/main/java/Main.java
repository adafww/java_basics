import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Company company = new Company();
        company.hireAll();
        company.getStaffInfo("Roman Vladimirov");
        for (Integer word : company.getTopSalaryStaff(30)){

            System.out.println(word);
        }



    }
}
