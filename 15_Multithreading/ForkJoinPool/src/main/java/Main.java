import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ForkJoinPool;

public class Main {
    //private static List<String> listFinal = new ArrayList<>();
    private static FileWriter fw;
    private static final String url = "https://skillbox.ru/";
    private static final String regex = "(" + url + ".+)(\\/)";

    static {
        try {
            fw = new FileWriter("data/text.txt");
            fw.write(url + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        SiteSchemeGenerator schemeGenerator = new SiteSchemeGenerator(url, regex);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(schemeGenerator);

        /*
        listFinal.add(url);
        recursion(url);
        */
    }
    /*
    private static void recursion(String originUrl) throws IOException, InterruptedException {

        int tabCount = 0;
        List<String> list = urlLists(originUrl);
        for (int i = 0; i < list.size(); i++){
            if(isCheck(list.get(i), listFinal)){
                tabCount++;
                Thread.sleep(100 + (long)(Math.random() * ((150 - 100) + 1)));
                listFinal.add(tab(list.get(i), tabCount));
                System.out.println(tab(list.get(i), tabCount));
                System.out.println(listFinal.size());
                recursion(list.get(i));
            }
        }
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
    private static List<String> urlLists(String url) throws IOException {
        Document document = null;
        try {
            document = Jsoup.connect(url).maxBodySize(0).ignoreHttpErrors(true).get();
        }catch (NullPointerException | HttpStatusException e){
            e.printStackTrace();
        }
        ArrayList<String> list = new ArrayList<>();
        document.select("a[href]").stream().forEach(a -> list.add((a.attr("abs:href"))));
        Set<String> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);
        return list
                .stream()
                .filter(a -> Pattern.matches(regex, a))
                .toList();
    }

    private static String tab(String str, int count){
        return "\t".repeat(Math.max(0, count)) + str;
    }

     */
}

