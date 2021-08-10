
public abstract class Staff implements Employee, Comparable<Staff> {

    public int identificationNumber(){

        return 10000 + (int) (Math.random() * 99999);
    }

    @Override
    public int compareTo(Staff o) {

        return o.getMonthSalary() - this.getMonthSalary();
    }
}
