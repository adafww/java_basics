import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 15;
        int month = 9;
        int year = 1995;

        System.out.println(collectBirthdays(year, month, day));
    }

    public static String collectBirthdays(int year, int month, int day) {

        LocalDate birthDay = LocalDate.of(year, month, day);

        LocalDate currentTime = LocalDate.now();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy - E", Locale.US);

        String result = "";

        for (int i = 0; i <= Period.between(birthDay, currentTime).getYears(); i++){

            if(Period.between(birthDay, currentTime).getMonths() >= 0 && Period.between(birthDay, currentTime).getDays() >= 0){

                result += i + " - " + format.format(birthDay.plusYears(i)) + System.lineSeparator();
            }
        }

        return result;
    }
}

//TODO реализуйте метод для построения строки в следующем виде
//0 - 31.12.1990 - Mon
//1 - 31.12.1991 - Tue
