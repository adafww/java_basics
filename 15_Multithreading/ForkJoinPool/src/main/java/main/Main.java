package main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ForkJoinPool;

public class Main {

    private static final String url = "https://skillbox.ru/";
    private static final String regex = "(" + url + ".+)(\\/)";
    private static final int numberOfCores = Runtime.getRuntime().availableProcessors();
    private static List<String> stringList = new ArrayList<>();
    private static List<String> emtyList = new ArrayList<>();

    public static void main(String[] args) {
        /*
        ListUrls.add(url);
        Regex.setString(regex);
        SiteSchemeGenerator schemeGenerator = new SiteSchemeGenerator(url);
        ForkJoinPool forkJoinPool = new ForkJoinPool(numberOfCores);
        forkJoinPool.invoke(schemeGenerator);

        */

        try {
            stringList = Files.readAllLines(Paths.get("data/text.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ListFiles.addAll(stringList);
        FinalGenerator finalGenerator = new FinalGenerator(2, 0, "");
        ForkJoinPool forkJoinPool1 = new ForkJoinPool(numberOfCores);
        forkJoinPool1.invoke(finalGenerator);



        //recursive(2,0, "");

        try {
            Files.write(Paths.get("data/text1.txt"), EmtyList.getList(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*

    private static void recursive(int count, int tabCount, String preStr){

        for (String s : stringList){
            if(check(s, emtyList)){
                if(strings(s).length == count){
                    emtyList.add(tab(s, tabCount));
                    System.out.println(tab(s, tabCount));
                    System.out.println(strings(s)[strings(s).length - 1]);
                    System.out.println(emtyList.size() + " +");
                    recursive(count++, tabCount++, strings(s)[strings(s).length - 1]);
                }

            }
        }
    }

    /*
    if(strings(s).length == count && preStr.equals(strings(s)[count - 1])){

                    recursive(count++, tabCount++, strings(s)[count - 1]);
                } else if(preStr.equals(strings(s)[count - 1])){
                    emtyList.add(tab(s, tabCount));
                    System.out.println(tab(s, tabCount));
                    System.out.println(emtyList.size() + " -");
                    recursive(count, tabCount, strings(s)[strings(s).length - 1]);
                }else if(strings(s).length == count){
                    emtyList.add(tab(s, tabCount));
                    System.out.println(tab(s, tabCount));
                    System.out.println(emtyList.size() + " -+");
                    recursive(count++, tabCount++, strings(s)[strings(s).length - 1]);
     */

    private static boolean check(String str, List<String> list){
        return (list.stream().filter(a -> a.trim().equals(str)).toList().size() == 0);
    }

    private static String[] strings(String str){
        return str.split("\\/+");
    }

    private static String tab(String str, int count){
        return "\t".repeat(Math.max(0, count)) + str;
    }
}

