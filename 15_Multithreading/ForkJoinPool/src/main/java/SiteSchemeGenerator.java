import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class SiteSchemeGenerator extends RecursiveAction {


    private String directory = "data/text.txt";
    private String url;
    private String regex;
    private List<String> listFinal = Files.readAllLines(Paths.get(directory));



    public SiteSchemeGenerator(String url, String regex) throws IOException {
        this.url = url;
        this.regex = regex;
    }

    @Override
    protected void compute() {
        int tabCount = 0;
        List<String> list = null;
        try {
            list = new UrlListsGenerator(url, regex).getUrlList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : list) {
            if (isCheck(s, listFinal)) {
                tabCount++;
                try {
                    Thread.sleep(100 + (long) (Math.random() * ((150 - 100) + 1)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                listFinal.add(tab(s, tabCount));
                try {
                    Files.writeString(Paths.get(directory), (tab(s, tabCount) + "\n"), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(tab(s, tabCount));
                System.out.println(listFinal.size());
                try {
                    new SiteSchemeGenerator(s, regex).fork();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static String tab(String str, int count){
        return "\t".repeat(Math.max(0, count)) + str;
    }

    private static boolean isCheck(String str, List<String> listCheck){
        boolean swch1 = true;
        int count = 0;
        for (int k = 0; k < listCheck.size(); k++){
            if(listCheck.get(k).trim().equals(str)){
                count++;
            }else {
                swch1 = true;
            }
            if(count == 0){
                swch1 = true;
            }else {
                swch1 = false;
            }
        }
        return swch1;
    }
}
