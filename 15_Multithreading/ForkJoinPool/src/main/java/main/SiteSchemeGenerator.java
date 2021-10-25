package main;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class SiteSchemeGenerator extends RecursiveAction {

    private List<String> list = null;

    public SiteSchemeGenerator(String url) {
        try {
            list = new UrlListsGenerator(url).getUrlList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(100 + (long) (Math.random() * ((150 - 100) + 1)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected synchronized void compute() {
        for (String s : list){
            ListUrls.add(s);
        }
    }


    private static String tab(String str, int count){

        return "\t".repeat(Math.max(0, count)) + str;
    }
}
