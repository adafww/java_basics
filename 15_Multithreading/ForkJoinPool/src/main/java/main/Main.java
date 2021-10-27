package main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.concurrent.ForkJoinPool;

public class Main {

    private static final String url = "https://skillbox.ru/";
    private static final String regex = "(" + url + ".+)(\\/)";
    private static final int numberOfCores = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {

        ListUrls.add(url);
        Regex.setString(regex);
        SiteSchemeGenerator schemeGenerator = new SiteSchemeGenerator(url);
        ForkJoinPool forkJoinPool = new ForkJoinPool(numberOfCores);
        forkJoinPool.invoke(schemeGenerator);

        ListFiles.addAll(ListUrls.getList().stream().toList());

        FinalGenerator finalGenerator = new FinalGenerator(2, 0, "");
        ForkJoinPool forkJoinPool1 = new ForkJoinPool(numberOfCores);
        forkJoinPool1.invoke(finalGenerator);

        try {
            Files.write(Paths.get("data/text.txt"), EmtyList.getList(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

