package main;

import java.util.concurrent.ForkJoinPool;

public class Main {

    private static final String url = "https://skillbox.ru/";
    private static final String regex = "(" + url + ".+)(\\/)";

    public static void main(String[] args) {

        Regex.setString(regex);
        SiteSchemeGenerator schemeGenerator = new SiteSchemeGenerator(url);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(schemeGenerator);

        //ListUrls.getAllStrings().stream().map(a -> a.trim()).toList().forEach(System.out::println);
    }
}

