import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {

      String input = scanner.nextLine();
      boolean isDigit = false;

      if (input.equals("0")) {
        break;
      }else {

        for (int i = 0; i < input.length(); i++){

          if (Character.isDigit(input.charAt(i)) == true){

            isDigit = true;
          }
        }

        String[] inputArrive = input.split("[\\s]");

        if (inputArrive.length == 3 && isDigit == false){

          System.out.println("Фамилия: " + inputArrive[0] + "\n" + "Имя: " + inputArrive[1] + "\n" + "Отчество: " + inputArrive[2]);
          continue;
        }
        if (inputArrive.length == 2 && isDigit == false){

          System.out.println("Фамилия: " + inputArrive[0] + "\n" + "Имя: " + inputArrive[1]);
          continue;
        }
        if (inputArrive.length != 2 && inputArrive.length != 3 || isDigit == true) {

          System.out.println("Введенная строка не является ФИО");
          continue;
        }
      }
    }
  }

}