import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    while (true) {

      int firstSpaceCheck = 0;
      int firstCount = 0;
      int secondCount = 0;
      int stringCount = 0;

      boolean isNumeric = false;

      String lastName;
      String firstName;
      String patronymic;
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }else {
        for (int i = 0; i < input.length(); i++) {

          if (Character.isDigit(input.charAt(i))){
            isNumeric = true;
          }
          if (Character.toString(input.charAt(i)).equals(" ")) {

            stringCount += 1;

            if (stringCount == 1 && firstSpaceCheck == 0){
              firstCount = i;
              firstSpaceCheck++;
            }
            if (stringCount == 2 && firstSpaceCheck == 1){
              secondCount = i;
              firstSpaceCheck++;
            }
          }
        }

        if (stringCount == 0 || stringCount == 3 || isNumeric){
          System.out.println("Введенная строка не является ФИО");
          continue;
        }

        if (stringCount == 1 && !isNumeric) {
          lastName = input.substring(0, firstCount);
          firstName = input.substring(++firstCount);
          System.out.println("Фамилия: " + lastName + "\n" + "Имя: " + firstName);
          continue;
        }
        if (stringCount == 2 && !isNumeric ) {
          lastName = input.substring(0, firstCount);
          firstName = input.substring(++firstCount, secondCount);
          patronymic = input.substring(++secondCount);
          System.out.println("Фамилия: " + lastName + "\n" + "Имя: " + firstName + "\n" + "Отчество: " + patronymic);
          continue;
        }
      }
    }
  }
}