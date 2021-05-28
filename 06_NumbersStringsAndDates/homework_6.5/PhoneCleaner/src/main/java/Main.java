import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int count = 0;
    String result = "7";

    while (true) {
      String input = scanner.nextLine();
      String[] digitCount = new String[input.length()];
      if (input.equals("0")) {
        break;
      }

      for (int i = 0; i < input.length(); i++) {

        if (Character.toString(input.charAt(i)).matches("[0-9]")) {

          digitCount[count] = Character.toString(input.charAt(i));
          count++;
        }
      }


      if (count > 11 || count < 10) {

        System.out.println("Неверный формат номера");
        result = "";
        count = 0;
        continue;
      }

      if (count == 10) {

        for (int i = 0; i < count; i++) {

          result += digitCount[i];
        }
      }

      if (count == 11){

        if(digitCount[0].equals("7") || digitCount[0].equals("8")){

          for (int i = 1; i < count; i++) {

            result += digitCount[i];
          }
        }

        if(!digitCount[0].equals("7") && !digitCount[0].equals("8")){

          System.out.println("Неверный формат номера");
          result = "";
          count = 0;
          continue;
        }
      }

      System.out.println(result);
      result = "";
      count = 0;
      continue;
    }
  }
}



