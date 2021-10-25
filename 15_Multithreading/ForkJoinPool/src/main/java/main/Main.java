package main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
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
        try {
            Files.write(Paths.get("data/text.txt"), ListUrls.getList(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

