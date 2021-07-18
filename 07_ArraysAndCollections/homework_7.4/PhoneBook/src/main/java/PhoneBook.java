import javax.swing.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PhoneBook {

    public static HashMap<String, TreeSet> phoneBookList = new HashMap<>();
    TreeSet <String> phoneNumbers = new TreeSet<>();
    Scanner scanner = new Scanner(System.in);
    String input = "";
    String nameReg = "^[А-ЯЁа-яё]+";
    String numberReg = "^[0-9]+";

    public void addContact(String phone, String name) {

        if(phone.matches(numberReg) && name.matches(nameReg)){

            if (phoneBookList.containsKey(name)){

                phoneNumbers = phoneBookList.get(name);
                phoneNumbers.add(phone);
                phoneBookList.put(name, new TreeSet(phoneNumbers));
            }else {

                phoneNumbers.clear();
                phoneNumbers.add(phone);
                phoneBookList.put(name, new TreeSet(phoneNumbers));
            }
            System.out.println("Контакт сохранён!");
        }else {

            System.out.println("Неверный формат ввода");
        }
        // проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента
    }

    public String getNameByPhone(String phone) {

        String result = "";

        for (String i : phoneBookList.keySet()){

            if(phoneBookList.get(i).contains(phone)){

                System.out.println(i + " - " + phoneBookList.get(i));
            }else {

                System.out.println("Такого номера нет в телефонной книге.");
                System.out.println("Введите имя абонента для номера" + " \"" + phone + "\":");
                input = scanner.nextLine();

                if(input.matches(nameReg)){

                addContact(phone, input);
                result = input;
                }
            }
        }


        return result;
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
    }

    public Set<String> getPhonesByName(String name) {

        if(phoneBookList.containsKey(name)){

            System.out.println(name + " - " + phoneBookList.get(name));
            System.out.println("Введите номер телефона для абонента" + " \"" + name + "\":");
            input = scanner.nextLine();
            if(input.matches(numberReg)){

                addContact(input, name);
            }else {

                System.out.println("Неверный формат ввода");
            }
        }else {
            System.out.println("Такого имени в телефонной книге нет.");
            System.out.println("Введите номер телефона для абонента" + " \"" + name + "\":");
            input = scanner.nextLine();
            if(input.matches(numberReg)){

                addContact(input, name);
            }else {

                System.out.println("Неверный формат ввода");
            }
        }

        return new TreeSet<>(phoneBookList.get(name));
    }

    public Set<String> getAllContacts() {

        if(!phoneBookList.isEmpty()){

            for (String i : phoneBookList.keySet()){

                System.out.println(i + " - " + phoneBookList.get(i));
            }
        }
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        return new TreeSet<>();
    }
}