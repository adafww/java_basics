import java.util.*;

public class EmailList {

    TreeSet<String> emailList = new TreeSet<>();

    public void add(String email) {

        emailList.add(email.toLowerCase(Locale.ROOT));
    }

    public TreeSet<String> getSortedEmails() {

        return emailList;
    }

}
