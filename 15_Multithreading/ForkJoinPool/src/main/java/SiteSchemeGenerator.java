import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class SiteSchemeGenerator extends RecursiveAction {

    private String directory = "data/text.txt";
    private String url;
    private String regex;
    private volatile List<String> listFinal = Files.readAllLines(Paths.get(directory));
    private volatile List<String> list = null;

    public SiteSchemeGenerator(String url, String regex) throws IOException {
        this.url = url;
        this.regex = regex;
    }

    @Override
    protected void compute() {
        int tabCount = 1;
        try {
            list = new UrlListsGenerator(url, regex).getUrlList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : list){
            try {
                Thread.sleep(100 + (long) (Math.random() * ((150 - 100) + 1)));
                if (isCheck(s, Files.readAllLines(Paths.get(directory)))){
                    Files.writeString(Paths.get(directory), (tab(s, tabCount) + "\n"), StandardOpenOption.APPEND);
                    new SiteSchemeGenerator(s, regex).fork();
                    tabCount++;
                    //System.out.println(Files.readAllLines(Paths.get(directory)).size());
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
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
