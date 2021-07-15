import java.util.*;

public class EmailList {

    TreeSet<String> emailList = new TreeSet<>();
    String regex = "([-._A-Za-z0-9]+[@][A-Za-z]+[.][A-Za-z]+)";

    public void add(String email) {

        if(email.matches(regex)){

            emailList.add(email.toLowerCase(Locale.ROOT));
        }else {

            System.out.println(Main.WRONG_EMAIL_ANSWER);
        }

    }

    public List<String> getSortedEmails() {

        return new ArrayList<>(emailList);
    }

}
