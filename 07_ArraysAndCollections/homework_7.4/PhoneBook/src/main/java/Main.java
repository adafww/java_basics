import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        String nameReg = "^[А-ЯЁа-яё]+";
        String numberReg = "^[0-9]+";

        while(true){

            System.out.println("Введите номер, имя или команду:");

            String input = scanner.nextLine();

            if (input.equals("0")) {

                break;
            }else if (input.equals("LIST")){

                phoneBook.getAllContacts();
            }else if (input.matches(nameReg)){

                phoneBook.getPhonesByName(input);
            }else if (input.matches(numberReg)){

                phoneBook.getNameByPhone(input);
            }else {

                System.out.println("Неверный формат ввода");
            }
        }
    }
}
