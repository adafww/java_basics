import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String result = "";

    while (true) {

      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }

      String[] inputCount = input.split("[^0-9]");

      for (int i = 0; i < inputCount.length; i++){

        result += inputCount[i];
      }

      if(result.length() < 10 || result.length() > 11 || result.length() == 11 && result.substring(0, 1).equals("7") != true && result.substring(0, 1).equals("8") != true){

        System.out.println("Неверный формат номера");
        continue;
      }

      if(result.length() == 10){

        System.out.println("7" + result);
      }

      if(result.length() == 11 && result.substring(0, 1).equals("7") == true || result.substring(0, 1).equals("8") == true){

        System.out.println("7" + result.substring(1, result.length()));
      }

      continue;
    }
  }
}



