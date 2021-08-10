import java.util.*;

public class Main {

    public static void main(String[] args) {

        //1 Создайте и наймите в компанию: 180 операторов Operator, 80 менеджеров по
        // продажам Manager, 10 топ-менеджеров TopManager.

        Company company = new Company();
        company.hireAll();

        //2 Распечатайте список из 10–15 самых высоких зарплат в компании.

        for (Staff word : company.getTopSalaryStaff(10)){

            System.out.println(word.getMonthSalary() + " руб. - " + word.getName());
        }

        System.out.println("");

        //3 Распечатайте список из 30 самых низких зарплат в компании.

        for (Staff word : company.getLowestSalaryStaff(30)){

            System.out.println(word.getMonthSalary() + " руб. - " + word.getName());
        }

        System.out.println("");

        //4 Увольте 50% сотрудников.

        company.halfFire();

        //5 Распечатайте список из 10–15 самых высоких зарплат в компании.

        for (Staff word : company.getTopSalaryStaff(10)){

            System.out.println(word.getMonthSalary() + " руб. - " + word.getName());
        }

        System.out.println("");

        //6 Распечатайте список из 30 самых низких зарплат в компании.

        for (Staff word : company.getLowestSalaryStaff(30)){

            System.out.println(word.getMonthSalary() + " руб. - " + word.getName());
        }
    }
}
