import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    private static EmailList emailList = new EmailList();

    public static void main(String[] args) {

        String regex = "^(ADD|LIST)(\\s)([-._A-Za-z0-9]+[@][A-Za-z]+[.][A-Za-z]+)";
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            String input = scanner.nextLine();
            String patternAddList = Pattern.compile(regex).matcher(input).replaceAll("$1");
            if (input.equals("0")) {
                break;
            }else if(patternAddList.equals("ADD")){

                emailList.add(Pattern.compile(regex).matcher(input).replaceAll("$3"));
            }else if(patternAddList.equals("LIST")){


                for(String list : emailList.emailList){

                    System.out.println(list);
                }
            }else {

                System.out.println(WRONG_EMAIL_ANSWER);
            }
        }
    }
}
