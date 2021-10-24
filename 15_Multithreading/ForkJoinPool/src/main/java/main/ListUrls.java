package main;

import java.util.ArrayList;
import java.util.List;

public class ListUrls {

    private static List<String> list = new ArrayList<>();

    public static List<String> getAllStrings(){
        return list;
    }

    public static String getString(int i){
        return list.get(i);
    }

    public static void addString(String str){
        list.add(str);
        System.out.println(str);
    }
}
