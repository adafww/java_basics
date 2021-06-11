import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    while (true) {

      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }

      if(input.length() == 12 && input.substring(0,1).equals("+") && input.substring(1,2).equals("7") || input.length() == 11 && input.substring(0,1).equals("8") || input.length() == 11 && input.substring(0,1).equals("7") || input.length() == 10){

        System.out.println(Pattern.compile("([0-9]|[+0-9]{2}|)([0-9]{3})([0-9]{3})([0-9]{2})([0-9]{2})").matcher(input).replaceAll("+7($2)$3-$4-$5"));
        continue;
      }else {

        System.out.println("Неверный формат номера");
        continue;
      }
    }
  }
}

