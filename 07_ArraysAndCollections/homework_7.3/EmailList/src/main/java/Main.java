import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    private static EmailList emailList = new EmailList();
    
    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {

        String regex = "^(ADD|LIST|)(\\s|)([-._A-Za-z0-9]+|)([@]|)([A-Za-z]+|)(.|)([A-Za-z]+|)";
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            String input = scanner.nextLine();
            String pattern = Pattern.compile(regex).matcher(input).replaceAll("$1");
            if (input.equals("0")) {
                break;
            }else if(pattern.equals("ADD") &&
                    !Pattern.compile(regex).matcher(input).replaceAll("$2").equals("") &&
                    !Pattern.compile(regex).matcher(input).replaceAll("$3").equals("") &&
                    Pattern.compile(regex).matcher(input).replaceAll("$4").equals("@") &&
                    !Pattern.compile(regex).matcher(input).replaceAll("$5").equals("") &&
                    Pattern.compile(regex).matcher(input).replaceAll("$6").equals(".") &&
                    !Pattern.compile(regex).matcher(input).replaceAll("$7").equals("")){

                emailList.add(
                        Pattern.compile(regex).matcher(input).replaceAll("$3") +
                        Pattern.compile(regex).matcher(input).replaceAll("$4") +
                        Pattern.compile(regex).matcher(input).replaceAll("$5") +
                        Pattern.compile(regex).matcher(input).replaceAll("$6") +
                        Pattern.compile(regex).matcher(input).replaceAll("$7"));
            }else if(pattern.equals("LIST")){


                for(String list : emailList.emailList){

                    System.out.println(list);
                }
            }else {

                System.out.println(WRONG_EMAIL_ANSWER);
            }
        }
    }
}
