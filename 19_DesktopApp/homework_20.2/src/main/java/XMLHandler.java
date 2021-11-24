import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class XMLHandler extends DefaultHandler {
    private Voter voter;
    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    /*private HashMap<Voter, Integer> voterCounts;
    public XMLHandler(){
        voterCounts = new HashMap<>() {
        };
    }*/

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("voter") && voter == null){
            Date birthDay = null;
            try {
                birthDay = birthDayFormat.parse(attributes.getValue("birthDay"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            voter = new Voter(attributes.getValue("name"), birthDay);
        }else if(qName.equals("visit") && voter != null){
            /*int count = voterCounts.getOrDefault(voter, 0);
            voterCounts.put(voter, count + 1);*/
        }
        //System.out.println(qName + " - started");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("voter")){
            voter = null;
        }
        //System.out.println(qName + " - ended");
    }

    public void printDuplicatesVoters(){

       /* for(Voter voter : voterCounts.keySet()){
            int count = voterCounts.get(voter);
            if(count > 1){
                System.out.println(voter.toString() + " - " + count);
            }
        }*/
    }
}
