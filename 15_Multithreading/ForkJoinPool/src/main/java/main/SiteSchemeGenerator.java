package main;

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
    private volatile List<String> list = null;

    public SiteSchemeGenerator(String url, String regex) {
        this.url = url;
        this.regex = regex;
        ListUrls.addString(url);
        try {
            Thread.sleep(100 + (long) (Math.random() * ((150 - 100) + 1)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
            if (check(s)){
                //ListUrls.addString(tab(s, tabCount) + "\n");
                ListUrls.addString(s);
                new SiteSchemeGenerator(s, regex).fork();
                tabCount++;
                //System.out.println(Files.readAllLines(Paths.get(directory)).size());
            }

        }
    }

    private static String tab(String str, int count){
        return "\t".repeat(Math.max(0, count)) + str;
    }

    private static boolean check(String str){
        boolean swch = true;
        for (int j = 0; j < ListUrls.getAllStrings().size(); j++){
            if (ListUrls.getString(j).trim().equals(str)) {
                swch = false;
            }
        }
        return swch;
    }
}
