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
    }

    @Override
    protected void compute() {
        for (String s : list){
            if(!ListUrls.contains(s.trim())){
                ListUrls.add(s);
                new SiteSchemeGenerator(s).compute();
            }
        }
    }
}
