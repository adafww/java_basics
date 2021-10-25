package main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class UrlListsGenerator {

    private List<String> list1;

    UrlListsGenerator(String url) throws IOException {
        Document document = Jsoup.connect(url).maxBodySize(0).get();
        ArrayList<String> list = new ArrayList<>();
        document.select("a[href]").stream().forEach(a -> list.add((a.attr("abs:href"))));
        Set<String> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);
        list1 = list
                .stream()
                .filter(a -> Pattern.matches(Regex.getString(), a))
                .toList();
    }

    public List<String> getUrlList(){
        return list1;
    }
}
